package com.facebook.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.C0090q;
import android.util.Log;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Builder;
import com.facebook.widget.FacebookDialog.DialogFeature;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class LikeActionController {
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
    private static final String JSON_BUNDLE_PENDING_CALL_ANALYTICS_BUNDLE = "pending_call_analytics_bundle";
    private static final String JSON_INT_VERSION_KEY = "com.facebook.internal.LikeActionController.version";
    private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
    private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
    private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
    private static final String JSON_STRING_PENDING_CALL_ID_KEY = "pending_call_id";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
    private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
    private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
    private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
    private static final int LIKE_ACTION_CONTROLLER_VERSION = 2;
    private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
    private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
    private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
    private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final int MAX_CACHE_SIZE = 128;
    private static final int MAX_OBJECT_SUFFIX = 1000;
    private static final String TAG = LikeActionController.class.getSimpleName();
    private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
    private static FileLruCache controllerDiskCache;
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
    private static Handler handler;
    private static boolean isInitialized;
    private static boolean isPendingBroadcastReset;
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static String objectIdForPendingController;
    private static volatile int objectSuffix;
    private AppEventsLogger appEventsLogger;
    private Context context;
    private boolean isObjectLiked;
    private boolean isObjectLikedOnServer;
    private boolean isPendingLikeOrUnlike;
    private String likeCountStringWithLike;
    private String likeCountStringWithoutLike;
    private String objectId;
    private boolean objectIsPage;
    private Bundle pendingCallAnalyticsBundle;
    private UUID pendingCallId;
    private Session session;
    private String socialSentenceWithLike;
    private String socialSentenceWithoutLike;
    private String unlikeToken;
    private String verifiedObjectId;

    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController);
    }

    class C05881 implements CreationCallback {
        private final /* synthetic */ UUID val$callId;
        private final /* synthetic */ Intent val$data;
        private final /* synthetic */ int val$requestCode;
        private final /* synthetic */ int val$resultCode;

        C05881(int i, int i2, Intent intent, UUID uuid) {
            this.val$requestCode = i;
            this.val$resultCode = i2;
            this.val$data = intent;
            this.val$callId = uuid;
        }

        public void onComplete(LikeActionController likeActionController) {
            likeActionController.onActivityResult(this.val$requestCode, this.val$resultCode, this.val$data, this.val$callId);
        }
    }

    class C05892 implements Runnable {
        private final /* synthetic */ LikeActionController val$controllerToRefresh;

        C05892(LikeActionController likeActionController) {
            this.val$controllerToRefresh = likeActionController;
        }

        public void run() {
            this.val$controllerToRefresh.refreshStatusAsync();
        }
    }

    class C05903 implements Runnable {
        private final /* synthetic */ CreationCallback val$callback;
        private final /* synthetic */ LikeActionController val$controller;

        C05903(CreationCallback creationCallback, LikeActionController likeActionController) {
            this.val$callback = creationCallback;
            this.val$controller = likeActionController;
        }

        public void run() {
            this.val$callback.onComplete(this.val$controller);
        }
    }

    class C05924 extends BroadcastReceiver {
        C05924() {
        }

        public void onReceive(final Context context, Intent intent) {
            if (!LikeActionController.isPendingBroadcastReset) {
                String action = intent.getAction();
                final boolean z = Utility.areObjectsEqual(Session.ACTION_ACTIVE_SESSION_UNSET, action) || Utility.areObjectsEqual(Session.ACTION_ACTIVE_SESSION_CLOSED, action);
                LikeActionController.isPendingBroadcastReset = true;
                LikeActionController.handler.postDelayed(new Runnable() {
                    public void run() {
                        if (z) {
                            LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % 1000;
                            context.getSharedPreferences(LikeActionController.LIKE_ACTION_CONTROLLER_STORE, 0).edit().putInt(LikeActionController.LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, LikeActionController.objectSuffix).apply();
                            LikeActionController.cache.clear();
                            LikeActionController.controllerDiskCache.clearCache();
                        }
                        LikeActionController.broadcastAction(context, null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
                        LikeActionController.isPendingBroadcastReset = false;
                    }
                }, 100);
            }
        }
    }

    interface RequestCompletionCallback {
        void onComplete();
    }

    class C05988 implements RequestCompletionCallback {
        C05988() {
        }

        public void onComplete() {
            final GetOGObjectLikesRequestWrapper getOGObjectLikesRequestWrapper = new GetOGObjectLikesRequestWrapper(LikeActionController.this.verifiedObjectId);
            final GetEngagementRequestWrapper getEngagementRequestWrapper = new GetEngagementRequestWrapper(LikeActionController.this.verifiedObjectId);
            RequestBatch requestBatch = new RequestBatch();
            getOGObjectLikesRequestWrapper.addToBatch(requestBatch);
            getEngagementRequestWrapper.addToBatch(requestBatch);
            requestBatch.addCallback(new Callback() {
                public void onBatchCompleted(RequestBatch requestBatch) {
                    if (getOGObjectLikesRequestWrapper.error == null && getEngagementRequestWrapper.error == null) {
                        LikeActionController.this.updateState(getOGObjectLikesRequestWrapper.objectIsLiked, getEngagementRequestWrapper.likeCountStringWithLike, getEngagementRequestWrapper.likeCountStringWithoutLike, getEngagementRequestWrapper.socialSentenceStringWithLike, getEngagementRequestWrapper.socialSentenceStringWithoutLike, getOGObjectLikesRequestWrapper.unlikeToken);
                        return;
                    }
                    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", LikeActionController.this.objectId);
                }
            });
            requestBatch.executeAsync();
        }
    }

    class C05999 implements CompletedListener {
        C05999() {
        }

        public void completed(Bundle bundle) {
            if (bundle != null && bundle.containsKey(NativeProtocol.EXTRA_OBJECT_IS_LIKED)) {
                String string;
                String string2;
                String string3;
                String string4;
                String string5;
                boolean z = bundle.getBoolean(NativeProtocol.EXTRA_OBJECT_IS_LIKED);
                if (bundle.containsKey(NativeProtocol.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
                    string = bundle.getString(NativeProtocol.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
                } else {
                    string = LikeActionController.this.likeCountStringWithLike;
                }
                if (bundle.containsKey(NativeProtocol.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
                    string2 = bundle.getString(NativeProtocol.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
                } else {
                    string2 = LikeActionController.this.likeCountStringWithoutLike;
                }
                if (bundle.containsKey(NativeProtocol.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
                    string3 = bundle.getString(NativeProtocol.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
                } else {
                    string3 = LikeActionController.this.socialSentenceWithLike;
                }
                if (bundle.containsKey(NativeProtocol.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
                    string4 = bundle.getString(NativeProtocol.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
                } else {
                    string4 = LikeActionController.this.socialSentenceWithoutLike;
                }
                if (bundle.containsKey(NativeProtocol.EXTRA_UNLIKE_TOKEN)) {
                    string5 = bundle.getString(NativeProtocol.EXTRA_UNLIKE_TOKEN);
                } else {
                    string5 = LikeActionController.this.unlikeToken;
                }
                LikeActionController.this.updateState(z, string, string2, string3, string4, string5);
            }
        }
    }

    abstract class AbstractRequestWrapper {
        FacebookRequestError error;
        protected String objectId;
        private Request request;

        class C06001 implements Request.Callback {
            C06001() {
            }

            public void onCompleted(Response response) {
                AbstractRequestWrapper.this.error = response.getError();
                if (AbstractRequestWrapper.this.error != null) {
                    AbstractRequestWrapper.this.processError(AbstractRequestWrapper.this.error);
                } else {
                    AbstractRequestWrapper.this.processSuccess(response);
                }
            }
        }

        protected abstract void processSuccess(Response response);

        protected AbstractRequestWrapper(String str) {
            this.objectId = str;
        }

        void addToBatch(RequestBatch requestBatch) {
            requestBatch.add(this.request);
        }

        protected void setRequest(Request request) {
            this.request = request;
            request.setVersion(ServerProtocol.GRAPH_API_VERSION);
            request.setCallback(new C06001());
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' : %s", this.objectId, facebookRequestError);
        }
    }

    class CreateLikeActionControllerWorkItem implements Runnable {
        private CreationCallback callback;
        private Context context;
        private String objectId;

        CreateLikeActionControllerWorkItem(Context context, String str, CreationCallback creationCallback) {
            this.context = context;
            this.objectId = str;
            this.callback = creationCallback;
        }

        public void run() {
            LikeActionController.createControllerForObjectId(this.context, this.objectId, this.callback);
        }
    }

    class GetEngagementRequestWrapper extends AbstractRequestWrapper {
        String likeCountStringWithLike;
        String likeCountStringWithoutLike;
        String socialSentenceStringWithLike;
        String socialSentenceStringWithoutLike;

        GetEngagementRequestWrapper(String str) {
            super(str);
            this.likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
            this.likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
            this.socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
            this.socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            setRequest(new Request(LikeActionController.this.session, str, bundle, HttpMethod.GET));
        }

        protected void processSuccess(Response response) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(response.getGraphObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.likeCountStringWithLike = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.likeCountStringWithLike);
                this.likeCountStringWithoutLike = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
                this.socialSentenceStringWithLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, this.socialSentenceStringWithLike);
                this.socialSentenceStringWithoutLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, this.socialSentenceStringWithoutLike);
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' : %s", this.objectId, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_engagement", facebookRequestError);
        }
    }

    class GetOGObjectIdRequestWrapper extends AbstractRequestWrapper {
        String verifiedObjectId;

        GetOGObjectIdRequestWrapper(String str) {
            super(str);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            setRequest(new Request(LikeActionController.this.session, "", bundle, HttpMethod.GET));
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.error = null;
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' : %s", this.objectId, facebookRequestError);
        }

        protected void processSuccess(Response response) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(response.getGraphObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                tryGetJSONObjectFromResponse = tryGetJSONObjectFromResponse.optJSONObject("og_object");
                if (tryGetJSONObjectFromResponse != null) {
                    this.verifiedObjectId = tryGetJSONObjectFromResponse.optString("id");
                }
            }
        }
    }

    class GetOGObjectLikesRequestWrapper extends AbstractRequestWrapper {
        boolean objectIsLiked;
        String unlikeToken;

        GetOGObjectLikesRequestWrapper(String str) {
            super(str);
            this.objectIsLiked = LikeActionController.this.isObjectLiked;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", str);
            setRequest(new Request(LikeActionController.this.session, "me/og.likes", bundle, HttpMethod.GET));
        }

        protected void processSuccess(Response response) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(response.getGraphObject(), "data");
            if (tryGetJSONArrayFromResponse != null) {
                for (int i = 0; i < tryGetJSONArrayFromResponse.length(); i++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.objectIsLiked = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        if (optJSONObject2 != null && Utility.areObjectsEqual(LikeActionController.this.session.getApplicationId(), optJSONObject2.optString("id"))) {
                            this.unlikeToken = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' : %s", this.objectId, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_og_object_like", facebookRequestError);
        }
    }

    class GetPageIdRequestWrapper extends AbstractRequestWrapper {
        boolean objectIsPage;
        String verifiedObjectId;

        GetPageIdRequestWrapper(String str) {
            super(str);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", str);
            setRequest(new Request(LikeActionController.this.session, "", bundle, HttpMethod.GET));
        }

        protected void processSuccess(Response response) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(response.getGraphObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                this.verifiedObjectId = tryGetJSONObjectFromResponse.optString("id");
                this.objectIsPage = !Utility.isNullOrEmpty(this.verifiedObjectId);
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' : %s", this.objectId, facebookRequestError);
        }
    }

    class LikeDialogBuilder extends Builder<LikeDialogBuilder> {
        private String objectId;

        public LikeDialogBuilder(Activity activity, String str) {
            super(activity);
            this.objectId = str;
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(LikeDialogFeature.LIKE_DIALOG);
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("object_id", this.objectId);
            return bundle;
        }

        public PendingCall getAppCall() {
            return this.appCall;
        }

        public String getApplicationId() {
            return this.applicationId;
        }

        public String getWebFallbackUrl() {
            return getWebFallbackUrlInternal();
        }
    }

    enum LikeDialogFeature implements DialogFeature {
        LIKE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140701);
        
        private int minVersion;

        private LikeDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_LIKE_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    class MRUCacheWorkItem implements Runnable {
        private static ArrayList<String> mruCachedItems = new ArrayList();
        private String cacheItem;
        private boolean shouldTrim;

        MRUCacheWorkItem(String str, boolean z) {
            this.cacheItem = str;
            this.shouldTrim = z;
        }

        public void run() {
            if (this.cacheItem != null) {
                mruCachedItems.remove(this.cacheItem);
                mruCachedItems.add(0, this.cacheItem);
            }
            if (this.shouldTrim && mruCachedItems.size() >= 128) {
                while (64 < mruCachedItems.size()) {
                    LikeActionController.cache.remove((String) mruCachedItems.remove(mruCachedItems.size() - 1));
                }
            }
        }
    }

    class PublishLikeRequestWrapper extends AbstractRequestWrapper {
        String unlikeToken;

        PublishLikeRequestWrapper(String str) {
            super(str);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            setRequest(new Request(LikeActionController.this.session, "me/og.likes", bundle, HttpMethod.POST));
        }

        protected void processSuccess(Response response) {
            this.unlikeToken = Utility.safeGetStringFromResponse(response.getGraphObject(), "id");
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == LikeActionController.ERROR_CODE_OBJECT_ALREADY_LIKED) {
                this.error = null;
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' : %s", this.objectId, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_like", facebookRequestError);
        }
    }

    class PublishUnlikeRequestWrapper extends AbstractRequestWrapper {
        private String unlikeToken;

        PublishUnlikeRequestWrapper(String str) {
            super(null);
            this.unlikeToken = str;
            setRequest(new Request(LikeActionController.this.session, str, null, HttpMethod.DELETE));
        }

        protected void processSuccess(Response response) {
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.unlikeToken, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_unlike", facebookRequestError);
        }
    }

    class SerializeToDiskWorkItem implements Runnable {
        private String cacheKey;
        private String controllerJson;

        SerializeToDiskWorkItem(String str, String str2) {
            this.cacheKey = str;
            this.controllerJson = str2;
        }

        public void run() {
            LikeActionController.serializeToDiskSynchronously(this.cacheKey, this.controllerJson);
        }
    }

    private static void serializeToDiskSynchronously(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = 0;
        r0 = controllerDiskCache;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1 = r0.openPutStream(r4);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r0 = r5.getBytes();	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r1.write(r0);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        com.facebook.internal.Utility.closeQuietly(r1);
    L_0x0013:
        return;
    L_0x0014:
        r0 = move-exception;
        r2 = TAG;	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        r3 = "Unable to serialize controller to disk";	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ IOException -> 0x0014, all -> 0x0022 }
        if (r1 == 0) goto L_0x0013;
    L_0x001e:
        com.facebook.internal.Utility.closeQuietly(r1);
        goto L_0x0013;
    L_0x0022:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        com.facebook.internal.Utility.closeQuietly(r1);
    L_0x0028:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.LikeActionController.serializeToDiskSynchronously(java.lang.String, java.lang.String):void");
    }

    public static boolean handleOnActivityResult(Context context, int i, int i2, Intent intent) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return false;
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = context.getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            return false;
        }
        getControllerForObjectId(context, objectIdForPendingController, new C05881(i, i2, intent, callIdFromIntent));
        return true;
    }

    public static void getControllerForObjectId(Context context, String str, CreationCallback creationCallback) {
        if (!isInitialized) {
            performFirstInitialize(context);
        }
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            invokeCallbackWithController(creationCallback, controllerFromInMemoryCache);
        } else {
            diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(context, str, creationCallback));
        }
    }

    private static void createControllerForObjectId(Context context, String str, CreationCallback creationCallback) {
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            invokeCallbackWithController(creationCallback, controllerFromInMemoryCache);
            return;
        }
        controllerFromInMemoryCache = deserializeFromDiskSynchronously(context, str);
        if (controllerFromInMemoryCache == null) {
            controllerFromInMemoryCache = new LikeActionController(context, Session.getActiveSession(), str);
            serializeToDiskAsync(controllerFromInMemoryCache);
        }
        putControllerInMemoryCache(str, controllerFromInMemoryCache);
        handler.post(new C05892(controllerFromInMemoryCache));
        invokeCallbackWithController(creationCallback, controllerFromInMemoryCache);
    }

    private static synchronized void performFirstInitialize(Context context) {
        synchronized (LikeActionController.class) {
            if (!isInitialized) {
                handler = new Handler(Looper.getMainLooper());
                objectSuffix = context.getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getInt(LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, 1);
                controllerDiskCache = new FileLruCache(context, TAG, new Limits());
                registerSessionBroadcastReceivers(context);
                isInitialized = true;
            }
        }
    }

    private static void invokeCallbackWithController(CreationCallback creationCallback, LikeActionController likeActionController) {
        if (creationCallback != null) {
            handler.post(new C05903(creationCallback, likeActionController));
        }
    }

    private static void registerSessionBroadcastReceivers(Context context) {
        C0090q a = C0090q.m145a(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_CLOSED);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_OPENED);
        a.m149a(new C05924(), intentFilter);
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
    }

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = (LikeActionController) cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, false));
        }
        return likeActionController;
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (!Utility.isNullOrEmpty(serializeToJson) && !Utility.isNullOrEmpty(cacheKeyForObjectId)) {
            diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(cacheKeyForObjectId, serializeToJson));
        }
    }

    private static LikeActionController deserializeFromDiskSynchronously(Context context, String str) {
        Closeable closeable;
        Throwable e;
        Throwable th;
        LikeActionController likeActionController = null;
        try {
            closeable = controllerDiskCache.get(getCacheKeyForObjectId(str));
            if (closeable != null) {
                try {
                    String readStreamToString = Utility.readStreamToString(closeable);
                    if (!Utility.isNullOrEmpty(readStreamToString)) {
                        likeActionController = deserializeFromJson(context, readStreamToString);
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.e(TAG, "Unable to deserialize controller from disk", e);
                        if (closeable != null) {
                            Utility.closeQuietly(closeable);
                        }
                        return likeActionController;
                    } catch (Throwable th2) {
                        th = th2;
                        if (closeable != null) {
                            Utility.closeQuietly(closeable);
                        }
                        throw th;
                    }
                }
            }
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
        } catch (IOException e3) {
            e = e3;
            closeable = null;
            Log.e(TAG, "Unable to deserialize controller from disk", e);
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
            return likeActionController;
        } catch (Throwable e4) {
            closeable = null;
            th = e4;
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
            throw th;
        }
        return likeActionController;
    }

    private static LikeActionController deserializeFromJson(Context context, String str) {
        LikeActionController likeActionController;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(JSON_INT_VERSION_KEY, -1) != 2) {
                return null;
            }
            likeActionController = new LikeActionController(context, Session.getActiveSession(), jSONObject.getString("object_id"));
            likeActionController.likeCountStringWithLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, null);
            likeActionController.likeCountStringWithoutLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, null);
            likeActionController.socialSentenceWithLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, null);
            likeActionController.socialSentenceWithoutLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, null);
            likeActionController.isObjectLiked = jSONObject.optBoolean(JSON_BOOL_IS_OBJECT_LIKED_KEY);
            likeActionController.unlikeToken = jSONObject.optString("unlike_token", null);
            String optString = jSONObject.optString(JSON_STRING_PENDING_CALL_ID_KEY, null);
            if (!Utility.isNullOrEmpty(optString)) {
                likeActionController.pendingCallId = UUID.fromString(optString);
            }
            jSONObject = jSONObject.optJSONObject(JSON_BUNDLE_PENDING_CALL_ANALYTICS_BUNDLE);
            if (jSONObject != null) {
                likeActionController.pendingCallAnalyticsBundle = BundleJSONConverter.convertToBundle(jSONObject);
            }
            return likeActionController;
        } catch (Throwable e) {
            Log.e(TAG, "Unable to deserialize controller from JSON", e);
            likeActionController = null;
        }
    }

    private static String serializeToJson(LikeActionController likeActionController) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_INT_VERSION_KEY, 2);
            jSONObject.put("object_id", likeActionController.objectId);
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, likeActionController.likeCountStringWithLike);
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, likeActionController.likeCountStringWithoutLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, likeActionController.socialSentenceWithLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, likeActionController.socialSentenceWithoutLike);
            jSONObject.put(JSON_BOOL_IS_OBJECT_LIKED_KEY, likeActionController.isObjectLiked);
            jSONObject.put("unlike_token", likeActionController.unlikeToken);
            if (likeActionController.pendingCallId != null) {
                jSONObject.put(JSON_STRING_PENDING_CALL_ID_KEY, likeActionController.pendingCallId.toString());
            }
            if (likeActionController.pendingCallAnalyticsBundle != null) {
                JSONObject convertToJSON = BundleJSONConverter.convertToJSON(likeActionController.pendingCallAnalyticsBundle);
                if (convertToJSON != null) {
                    jSONObject.put(JSON_BUNDLE_PENDING_CALL_ANALYTICS_BUNDLE, convertToJSON);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.e(TAG, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String getCacheKeyForObjectId(String str) {
        String str2 = null;
        Session activeSession = Session.getActiveSession();
        if (activeSession != null && activeSession.isOpened()) {
            str2 = activeSession.getAccessToken();
        }
        if (str2 != null) {
            str2 = Utility.md5hash(str2);
        }
        return String.format("%s|%s|com.fb.sdk.like|%d", new Object[]{str, Utility.coerceValueIfNullOrEmpty(str2, ""), Integer.valueOf(objectSuffix)});
    }

    private static void broadcastAction(Context context, LikeActionController likeActionController, String str) {
        broadcastAction(context, likeActionController, str, null);
    }

    private static void broadcastAction(Context context, LikeActionController likeActionController, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        C0090q.m145a(context.getApplicationContext()).m150a(intent);
    }

    private LikeActionController(Context context, Session session, String str) {
        this.context = context;
        this.session = session;
        this.objectId = str;
        this.appEventsLogger = AppEventsLogger.newLogger(context, session);
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    public void toggleLike(Activity activity, Bundle bundle) {
        this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_TAP, null, bundle);
        boolean z = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
            if (this.isPendingLikeOrUnlike) {
                this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, null, bundle);
                return;
            }
        }
        performLikeOrUnlike(activity, z, bundle);
    }

    private void performLikeOrUnlike(Activity activity, boolean z, Bundle bundle) {
        if (!canUseOGPublish()) {
            presentLikeDialog(activity, bundle);
        } else if (z) {
            publishLikeAsync(activity, bundle);
        } else if (Utility.isNullOrEmpty(this.unlikeToken)) {
            fallbackToDialog(activity, bundle, true);
        } else {
            publishUnlikeAsync(activity, bundle);
        }
    }

    private void fallbackToDialog(Activity activity, Bundle bundle, boolean z) {
        updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
        presentLikeDialog(activity, bundle);
    }

    private void updateState(boolean z, String str, String str2, String str3, String str4, String str5) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        Object obj = (z == this.isObjectLiked && Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.likeCountStringWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.likeCountStringWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.socialSentenceWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.socialSentenceWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.unlikeToken)) ? null : 1;
        if (obj != null) {
            this.isObjectLiked = z;
            this.likeCountStringWithLike = coerceValueIfNullOrEmpty;
            this.likeCountStringWithoutLike = coerceValueIfNullOrEmpty2;
            this.socialSentenceWithLike = coerceValueIfNullOrEmpty3;
            this.socialSentenceWithoutLike = coerceValueIfNullOrEmpty4;
            this.unlikeToken = coerceValueIfNullOrEmpty5;
            serializeToDiskAsync(this);
            broadcastAction(this.context, this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        }
    }

    private void presentLikeDialog(Activity activity, Bundle bundle) {
        LikeDialogBuilder likeDialogBuilder = new LikeDialogBuilder(activity, this.objectId);
        if (likeDialogBuilder.canPresent()) {
            trackPendingCall(likeDialogBuilder.build().present(), bundle);
            this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, null, bundle);
            return;
        }
        String webFallbackUrl = likeDialogBuilder.getWebFallbackUrl();
        if (!Utility.isNullOrEmpty(webFallbackUrl) && FacebookWebFallbackDialog.presentWebFallback(activity, webFallbackUrl, likeDialogBuilder.getApplicationId(), likeDialogBuilder.getAppCall(), getFacebookDialogCallback(bundle))) {
            this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK, null, bundle);
        }
    }

    private boolean onActivityResult(int i, int i2, Intent intent, UUID uuid) {
        if (this.pendingCallId == null || !this.pendingCallId.equals(uuid)) {
            return false;
        }
        PendingCall pendingCallById = PendingCallStore.getInstance().getPendingCallById(this.pendingCallId);
        if (pendingCallById == null) {
            return false;
        }
        FacebookDialog.handleActivityResult(this.context, pendingCallById, i, intent, getFacebookDialogCallback(this.pendingCallAnalyticsBundle));
        stopTrackingPendingCall();
        return true;
    }

    private FacebookDialog.Callback getFacebookDialogCallback(final Bundle bundle) {
        return new FacebookDialog.Callback() {
            public void onComplete(PendingCall pendingCall, Bundle bundle) {
                if (bundle != null && bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                    String string;
                    boolean z = bundle.getBoolean(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY);
                    String access$4 = LikeActionController.this.likeCountStringWithLike;
                    String access$5 = LikeActionController.this.likeCountStringWithoutLike;
                    if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY)) {
                        access$5 = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY);
                        access$4 = access$5;
                    }
                    String access$6 = LikeActionController.this.socialSentenceWithLike;
                    String access$7 = LikeActionController.this.socialSentenceWithoutLike;
                    if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY)) {
                        access$7 = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY);
                        access$6 = access$7;
                    }
                    if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                        string = bundle.getString("unlike_token");
                    } else {
                        string = LikeActionController.this.unlikeToken;
                    }
                    Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                    bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, pendingCall.getCallId().toString());
                    LikeActionController.this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, null, bundle2);
                    LikeActionController.this.updateState(z, access$4, access$5, access$6, access$7, string);
                }
            }

            public void onError(PendingCall pendingCall, Exception exception, Bundle bundle) {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", exception);
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, pendingCall.getCallId().toString());
                LikeActionController.this.logAppEventForError("present_dialog", bundle2);
                LikeActionController.broadcastAction(LikeActionController.this.context, LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
            }
        };
    }

    private void trackPendingCall(PendingCall pendingCall, Bundle bundle) {
        PendingCallStore.getInstance().trackPendingCall(pendingCall);
        this.pendingCallId = pendingCall.getCallId();
        storeObjectIdForPendingController(this.objectId);
        this.pendingCallAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
    }

    private void stopTrackingPendingCall() {
        PendingCallStore.getInstance().stopTrackingPendingCall(this.pendingCallId);
        this.pendingCallId = null;
        this.pendingCallAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
    }

    private void storeObjectIdForPendingController(String str) {
        objectIdForPendingController = str;
        this.context.getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).edit().putString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, objectIdForPendingController).apply();
    }

    private boolean canUseOGPublish() {
        return (this.objectIsPage || this.verifiedObjectId == null || this.session == null || this.session.getPermissions() == null || !this.session.getPermissions().contains("publish_actions")) ? false : true;
    }

    private void publishLikeAsync(final Activity activity, final Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new RequestCompletionCallback() {
            public void onComplete() {
                if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID);
                    LikeActionController.broadcastAction(LikeActionController.this.context, LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
                    return;
                }
                RequestBatch requestBatch = new RequestBatch();
                final PublishLikeRequestWrapper publishLikeRequestWrapper = new PublishLikeRequestWrapper(LikeActionController.this.verifiedObjectId);
                publishLikeRequestWrapper.addToBatch(requestBatch);
                final Activity activity = activity;
                final Bundle bundle2 = bundle;
                requestBatch.addCallback(new Callback() {
                    public void onBatchCompleted(RequestBatch requestBatch) {
                        LikeActionController.this.isPendingLikeOrUnlike = false;
                        if (publishLikeRequestWrapper.error != null) {
                            LikeActionController.this.fallbackToDialog(activity, bundle2, false);
                            return;
                        }
                        LikeActionController.this.unlikeToken = Utility.coerceValueIfNullOrEmpty(publishLikeRequestWrapper.unlikeToken, null);
                        LikeActionController.this.isObjectLikedOnServer = true;
                        LikeActionController.this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, bundle2);
                        LikeActionController.this.toggleAgainIfNeeded(activity, bundle2);
                    }
                });
                requestBatch.executeAsync();
            }
        });
    }

    private void publishUnlikeAsync(final Activity activity, final Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        RequestBatch requestBatch = new RequestBatch();
        final PublishUnlikeRequestWrapper publishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(this.unlikeToken);
        publishUnlikeRequestWrapper.addToBatch(requestBatch);
        requestBatch.addCallback(new Callback() {
            public void onBatchCompleted(RequestBatch requestBatch) {
                LikeActionController.this.isPendingLikeOrUnlike = false;
                if (publishUnlikeRequestWrapper.error != null) {
                    LikeActionController.this.fallbackToDialog(activity, bundle, true);
                    return;
                }
                LikeActionController.this.unlikeToken = null;
                LikeActionController.this.isObjectLikedOnServer = false;
                LikeActionController.this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, bundle);
                LikeActionController.this.toggleAgainIfNeeded(activity, bundle);
            }
        });
        requestBatch.executeAsync();
    }

    private void refreshStatusAsync() {
        if (this.session == null || this.session.isClosed() || SessionState.CREATED.equals(this.session.getState())) {
            refreshStatusViaService();
        } else if (this.session.isOpened()) {
            fetchVerifiedObjectId(new C05988());
        }
    }

    private void refreshStatusViaService() {
        LikeStatusClient likeStatusClient = new LikeStatusClient(this.context, Settings.getApplicationId(), this.objectId);
        if (likeStatusClient.start()) {
            likeStatusClient.setCompletedListener(new C05999());
        }
    }

    private void toggleAgainIfNeeded(Activity activity, Bundle bundle) {
        if (this.isObjectLiked != this.isObjectLikedOnServer) {
            performLikeOrUnlike(activity, this.isObjectLiked, bundle);
        }
    }

    private void fetchVerifiedObjectId(final RequestCompletionCallback requestCompletionCallback) {
        if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
            final GetOGObjectIdRequestWrapper getOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(this.objectId);
            final GetPageIdRequestWrapper getPageIdRequestWrapper = new GetPageIdRequestWrapper(this.objectId);
            RequestBatch requestBatch = new RequestBatch();
            getOGObjectIdRequestWrapper.addToBatch(requestBatch);
            getPageIdRequestWrapper.addToBatch(requestBatch);
            requestBatch.addCallback(new Callback() {
                public void onBatchCompleted(RequestBatch requestBatch) {
                    LikeActionController.this.verifiedObjectId = getOGObjectIdRequestWrapper.verifiedObjectId;
                    if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                        LikeActionController.this.verifiedObjectId = getPageIdRequestWrapper.verifiedObjectId;
                        LikeActionController.this.objectIsPage = getPageIdRequestWrapper.objectIsPage;
                    }
                    if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.objectId);
                        LikeActionController.this.logAppEventForError("get_verified_id", getPageIdRequestWrapper.error != null ? getPageIdRequestWrapper.error : getOGObjectIdRequestWrapper.error);
                    }
                    if (requestCompletionCallback != null) {
                        requestCompletionCallback.onComplete();
                    }
                }
            });
            requestBatch.executeAsync();
        } else if (requestCompletionCallback != null) {
            requestCompletionCallback.onComplete();
        }
    }

    private void logAppEventForError(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.objectId);
        bundle2.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_CURRENT_ACTION, str);
        this.appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_ERROR, null, bundle2);
    }

    private void logAppEventForError(String str, FacebookRequestError facebookRequestError) {
        Bundle bundle = new Bundle();
        if (facebookRequestError != null) {
            JSONObject requestResult = facebookRequestError.getRequestResult();
            if (requestResult != null) {
                bundle.putString("error", requestResult.toString());
            }
        }
        logAppEventForError(str, bundle);
    }
}
