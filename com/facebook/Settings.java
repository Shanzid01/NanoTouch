package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.facebook.Request.Callback;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class Settings {
    private static final String ANALYTICS_EVENT = "event";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    private static final String AUTO_PUBLISH = "auto_publish";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new C05651();
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK = new Object();
    private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = Settings.class.getCanonicalName();
    private static volatile String appClientToken;
    private static volatile String appVersion;
    private static volatile String applicationId;
    private static volatile boolean defaultsLoaded = false;
    private static volatile Executor executor;
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static volatile boolean isDebugEnabled = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static volatile boolean platformCompatibilityEnabled;
    private static Boolean sdkInitialized = Boolean.valueOf(false);
    private static volatile boolean shouldAutoPublishInstall;

    class C05651 implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(0);

        C05651() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    }

    class C05672 implements Runnable {
        private final /* synthetic */ Context val$applicationContext;
        private final /* synthetic */ String val$applicationId;
        private final /* synthetic */ Callback val$callback;

        C05672(Context context, String str, Callback callback) {
            this.val$applicationContext = context;
            this.val$applicationId = str;
            this.val$callback = callback;
        }

        public void run() {
            final Response publishInstallAndWaitForResponse = Settings.publishInstallAndWaitForResponse(this.val$applicationContext, this.val$applicationId, false);
            if (this.val$callback != null) {
                Handler handler = new Handler(Looper.getMainLooper());
                final Callback callback = this.val$callback;
                handler.post(new Runnable() {
                    public void run() {
                        callback.onCompleted(publishInstallAndWaitForResponse);
                    }
                });
            }
        }
    }

    public static synchronized void sdkInitialize(Context context) {
        synchronized (Settings.class) {
            if (!sdkInitialized.booleanValue()) {
                loadDefaultsFromMetadataIfNeeded(context);
                Utility.loadAppSettingsAsync(context, getApplicationId());
                BoltsMeasurementEventListener.getInstance(context.getApplicationContext());
                sdkInitialized = Boolean.valueOf(true);
            }
        }
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static final void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
        }
    }

    public static final void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static final void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (loggingBehaviors) {
            z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
        }
        return z;
    }

    @Deprecated
    public static final boolean isLoggingEnabled() {
        return isDebugEnabled();
    }

    @Deprecated
    public static final void setIsLoggingEnabled(boolean z) {
        setIsDebugEnabled(z);
    }

    public static final boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static final void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                Executor asyncTaskExecutor = getAsyncTaskExecutor();
                if (asyncTaskExecutor == null) {
                    asyncTaskExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
                }
                executor = asyncTaskExecutor;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor) {
        Validate.notNull(executor, "executor");
        synchronized (LOCK) {
            executor = executor;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    private static Executor getAsyncTaskExecutor() {
        try {
            try {
                Object obj = AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Executor) {
                    return (Executor) obj;
                }
                return null;
            } catch (IllegalAccessException e) {
                return null;
            }
        } catch (NoSuchFieldException e2) {
            return null;
        }
    }

    static void publishInstallAsync(Context context, String str, Callback callback) {
        getExecutor().execute(new C05672(context.getApplicationContext(), str, callback));
    }

    @Deprecated
    public static void setShouldAutoPublishInstall(boolean z) {
        shouldAutoPublishInstall = z;
    }

    @Deprecated
    public static boolean getShouldAutoPublishInstall() {
        return shouldAutoPublishInstall;
    }

    static Response publishInstallAndWaitForResponse(Context context, String str, boolean z) {
        if (context == null || str == null) {
            try {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            } catch (Exception e) {
                Exception exception = e;
                Utility.logd("Facebook-publish", exception);
                return new Response(null, null, new FacebookRequestError(null, exception));
            }
        }
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
        String stringBuilder = new StringBuilder(String.valueOf(str)).append("ping").toString();
        String stringBuilder2 = new StringBuilder(String.valueOf(str)).append("json").toString();
        long j = sharedPreferences.getLong(stringBuilder, 0);
        String string = sharedPreferences.getString(stringBuilder2, null);
        if (!z) {
            setShouldAutoPublishInstall(false);
        }
        GraphObject create = Factory.create();
        create.setProperty("event", MOBILE_INSTALL_EVENT);
        Utility.setAppEventAttributionParameters(create, attributionIdentifiers, Utility.getHashedDeviceAndAppID(context, str), getLimitEventAndDataUsage(context));
        create.setProperty(AUTO_PUBLISH, Boolean.valueOf(z));
        create.setProperty("application_package_name", context.getPackageName());
        Request newPostRequest = Request.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, new Object[]{str}), create, null);
        if (j != 0) {
            GraphObject graphObject = null;
            if (string != null) {
                try {
                    graphObject = Factory.create(new JSONObject(string));
                } catch (JSONException e2) {
                }
            }
            if (graphObject != null) {
                return new Response(null, null, null, graphObject, true);
            }
            return (Response) Response.createResponsesFromString(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, null, new RequestBatch(newPostRequest), true).get(0);
        } else if (attributionIdentifiers == null || (attributionIdentifiers.getAndroidAdvertiserId() == null && attributionIdentifiers.getAttributionId() == null)) {
            throw new FacebookException("No attribution id available to send to server.");
        } else if (Utility.queryAppSettings(str, false).supportsAttribution()) {
            Response executeAndWait = newPostRequest.executeAndWait();
            Editor edit = sharedPreferences.edit();
            edit.putLong(stringBuilder, System.currentTimeMillis());
            if (!(executeAndWait.getGraphObject() == null || executeAndWait.getGraphObject().getInnerJSONObject() == null)) {
                edit.putString(stringBuilder2, executeAndWait.getGraphObject().getInnerJSONObject().toString());
            }
            edit.apply();
            return executeAndWait;
        } else {
            throw new FacebookException("Install attribution has been disabled on the server.");
        }
    }

    public static String getAttributionId(ContentResolver contentResolver) {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("aid"));
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static void setAppVersion(String str) {
        appVersion = str;
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static long getOnProgressThreshold() {
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    public static boolean getPlatformCompatibilityEnabled() {
        return platformCompatibilityEnabled;
    }

    public static void setPlatformCompatibilityEnabled(boolean z) {
        platformCompatibilityEnabled = z;
    }

    public static void loadDefaultsFromMetadata(Context context) {
        defaultsLoaded = true;
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        applicationId = applicationInfo.metaData.getString(APPLICATION_ID_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    static void loadDefaultsFromMetadataIfNeeded(Context context) {
        if (!defaultsLoaded) {
            loadDefaultsFromMetadata(context);
        }
    }

    public static String getApplicationSignature(Context context) {
        String str = null;
        if (context == null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(instance.digest(), 9);
            } catch (NoSuchAlgorithmException e) {
                return str;
            }
        } catch (NameNotFoundException e2) {
            return str;
        }
    }

    public static String getApplicationId() {
        return applicationId;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getClientToken() {
        return appClientToken;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }
}
