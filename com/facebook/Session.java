package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.content.C0090q;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.Request.Callback;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class Session implements Serializable {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$SessionState = null;
    public static final String ACTION_ACTIVE_SESSION_CLOSED = "com.facebook.sdk.ACTIVE_SESSION_CLOSED";
    public static final String ACTION_ACTIVE_SESSION_OPENED = "com.facebook.sdk.ACTIVE_SESSION_OPENED";
    public static final String ACTION_ACTIVE_SESSION_SET = "com.facebook.sdk.ACTIVE_SESSION_SET";
    public static final String ACTION_ACTIVE_SESSION_UNSET = "com.facebook.sdk.ACTIVE_SESSION_UNSET";
    private static final String AUTH_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.authBundleKey";
    public static final int DEFAULT_AUTHORIZE_ACTIVITY_CODE = 64206;
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = new C05561();
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String SESSION_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.saveSessionKey";
    private static final Object STATIC_LOCK = new Object();
    public static final String TAG = Session.class.getCanonicalName();
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    public static final String WEB_VIEW_ERROR_CODE_KEY = "com.facebook.sdk.WebViewErrorCode";
    public static final String WEB_VIEW_FAILING_URL_KEY = "com.facebook.sdk.FailingUrl";
    private static Session activeSession = null;
    private static final long serialVersionUID = 1;
    private static volatile Context staticContext;
    private AppEventsLogger appEventsLogger;
    private String applicationId;
    private volatile Bundle authorizationBundle;
    private AuthorizationClient authorizationClient;
    private AutoPublishAsyncTask autoPublishAsyncTask;
    private final List<StatusCallback> callbacks;
    private volatile TokenRefreshRequest currentTokenRefreshRequest;
    private Handler handler;
    private Date lastAttemptedTokenExtendDate;
    private final Object lock;
    private AuthorizationRequest pendingAuthorizationRequest;
    private SessionState state;
    private TokenCachingStrategy tokenCachingStrategy;
    private AccessToken tokenInfo;

    class C05561 extends HashSet<String> {
        C05561() {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    }

    class C05572 implements Callback {
        C05572() {
        }

        public void onCompleted(Response response) {
            PermissionsPair handlePermissionResponse = Session.handlePermissionResponse(response);
            if (handlePermissionResponse != null) {
                synchronized (Session.this.lock) {
                    Session.this.tokenInfo = AccessToken.createFromTokenWithRefreshedPermissions(Session.this.tokenInfo, handlePermissionResponse.getGrantedPermissions(), handlePermissionResponse.getDeclinedPermissions());
                    Session.this.postStateChange(Session.this.state, SessionState.OPENED_TOKEN_UPDATED, null);
                }
            }
        }
    }

    class C05583 implements OnCompletedListener {
        C05583() {
        }

        public void onCompleted(Result result) {
            int i;
            if (result.code == Code.CANCEL) {
                i = 0;
            } else {
                i = -1;
            }
            Session.this.handleAuthorizationResult(i, result);
        }
    }

    interface StartActivityDelegate {
        Activity getActivityContext();

        void startActivityForResult(Intent intent, int i);
    }

    public class AuthorizationRequest implements Serializable {
        private static final long serialVersionUID = 1;
        private String applicationId;
        private final String authId;
        private SessionDefaultAudience defaultAudience;
        private boolean isLegacy;
        private final Map<String, String> loggingExtras;
        private SessionLoginBehavior loginBehavior;
        private List<String> permissions;
        private int requestCode;
        private final StartActivityDelegate startActivityDelegate;
        private StatusCallback statusCallback;
        private String validateSameFbidAsToken;

        class C05633 implements StartActivityDelegate {
            C05633() {
            }

            public void startActivityForResult(Intent intent, int i) {
                throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
            }

            public Activity getActivityContext() {
                throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
            }
        }

        class C05644 implements StartActivityDelegate {
            C05644() {
            }

            public void startActivityForResult(Intent intent, int i) {
                AuthorizationRequest.this.startActivityDelegate.startActivityForResult(intent, i);
            }

            public Activity getActivityContext() {
                return AuthorizationRequest.this.startActivityDelegate.getActivityContext();
            }
        }

        class AuthRequestSerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -8748347685113614927L;
            private final String applicationId;
            private final String defaultAudience;
            private boolean isLegacy;
            private final SessionLoginBehavior loginBehavior;
            private final List<String> permissions;
            private final int requestCode;
            private final String validateSameFbidAsToken;

            private AuthRequestSerializationProxyV1(SessionLoginBehavior sessionLoginBehavior, int i, List<String> list, String str, boolean z, String str2, String str3) {
                this.loginBehavior = sessionLoginBehavior;
                this.requestCode = i;
                this.permissions = list;
                this.defaultAudience = str;
                this.isLegacy = z;
                this.applicationId = str2;
                this.validateSameFbidAsToken = str3;
            }

            private Object readResolve() {
                return new AuthorizationRequest(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience, this.isLegacy, this.applicationId, this.validateSameFbidAsToken);
            }
        }

        AuthorizationRequest(final Activity activity) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.authId = UUID.randomUUID().toString();
            this.loggingExtras = new HashMap();
            this.startActivityDelegate = new StartActivityDelegate() {
                public void startActivityForResult(Intent intent, int i) {
                    activity.startActivityForResult(intent, i);
                }

                public Activity getActivityContext() {
                    return activity;
                }
            };
        }

        AuthorizationRequest(final Fragment fragment) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.authId = UUID.randomUUID().toString();
            this.loggingExtras = new HashMap();
            this.startActivityDelegate = new StartActivityDelegate() {
                public void startActivityForResult(Intent intent, int i) {
                    fragment.startActivityForResult(intent, i);
                }

                public Activity getActivityContext() {
                    return fragment.getActivity();
                }
            };
        }

        private AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, List<String> list, String str, boolean z, String str2, String str3) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.authId = UUID.randomUUID().toString();
            this.loggingExtras = new HashMap();
            this.startActivityDelegate = new C05633();
            this.loginBehavior = sessionLoginBehavior;
            this.requestCode = i;
            this.permissions = list;
            this.defaultAudience = SessionDefaultAudience.valueOf(str);
            this.isLegacy = z;
            this.applicationId = str2;
            this.validateSameFbidAsToken = str3;
        }

        public void setIsLegacy(boolean z) {
            this.isLegacy = z;
        }

        boolean isLegacy() {
            return this.isLegacy;
        }

        AuthorizationRequest setCallback(StatusCallback statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        StatusCallback getCallback() {
            return this.statusCallback;
        }

        AuthorizationRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            if (sessionLoginBehavior != null) {
                this.loginBehavior = sessionLoginBehavior;
            }
            return this;
        }

        SessionLoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        AuthorizationRequest setRequestCode(int i) {
            if (i >= 0) {
                this.requestCode = i;
            }
            return this;
        }

        int getRequestCode() {
            return this.requestCode;
        }

        AuthorizationRequest setPermissions(List<String> list) {
            if (list != null) {
                this.permissions = list;
            }
            return this;
        }

        AuthorizationRequest setPermissions(String... strArr) {
            return setPermissions(Arrays.asList(strArr));
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        AuthorizationRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            if (sessionDefaultAudience != null) {
                this.defaultAudience = sessionDefaultAudience;
            }
            return this;
        }

        SessionDefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        StartActivityDelegate getStartActivityDelegate() {
            return this.startActivityDelegate;
        }

        String getApplicationId() {
            return this.applicationId;
        }

        void setApplicationId(String str) {
            this.applicationId = str;
        }

        String getValidateSameFbidAsToken() {
            return this.validateSameFbidAsToken;
        }

        void setValidateSameFbidAsToken(String str) {
            this.validateSameFbidAsToken = str;
        }

        String getAuthId() {
            return this.authId;
        }

        AuthorizationRequest getAuthorizationClientRequest() {
            return new AuthorizationRequest(this.loginBehavior, this.requestCode, this.isLegacy, this.permissions, this.defaultAudience, this.applicationId, this.validateSameFbidAsToken, new C05644(), this.authId);
        }

        Object writeReplace() {
            return new AuthRequestSerializationProxyV1(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience.name(), this.isLegacy, this.applicationId, this.validateSameFbidAsToken);
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("Cannot readObject, serialization proxy required");
        }
    }

    class AutoPublishAsyncTask extends AsyncTask<Void, Void, Void> {
        private final Context mApplicationContext;
        private final String mApplicationId;

        public AutoPublishAsyncTask(String str, Context context) {
            this.mApplicationId = str;
            this.mApplicationContext = context.getApplicationContext();
        }

        protected Void doInBackground(Void... voidArr) {
            try {
                Settings.publishInstallAndWaitForResponse(this.mApplicationContext, this.mApplicationId, true);
            } catch (Exception e) {
                Utility.logd("Facebook-publish", e);
            }
            return null;
        }

        protected void onPostExecute(Void voidR) {
            synchronized (Session.this) {
                Session.this.autoPublishAsyncTask = null;
            }
        }
    }

    public final class Builder {
        private String applicationId;
        private final Context context;
        private TokenCachingStrategy tokenCachingStrategy;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setApplicationId(String str) {
            this.applicationId = str;
            return this;
        }

        public Builder setTokenCachingStrategy(TokenCachingStrategy tokenCachingStrategy) {
            this.tokenCachingStrategy = tokenCachingStrategy;
            return this;
        }

        public Session build() {
            return new Session(this.context, this.applicationId, this.tokenCachingStrategy);
        }
    }

    public final class NewPermissionsRequest extends AuthorizationRequest {
        private static final long serialVersionUID = 1;

        public NewPermissionsRequest(Activity activity, List<String> list) {
            super(activity);
            setPermissions((List) list);
        }

        public NewPermissionsRequest(Fragment fragment, List<String> list) {
            super(fragment);
            setPermissions((List) list);
        }

        public NewPermissionsRequest(Activity activity, String... strArr) {
            super(activity);
            setPermissions(strArr);
        }

        public NewPermissionsRequest(Fragment fragment, String... strArr) {
            super(fragment);
            setPermissions(strArr);
        }

        public final NewPermissionsRequest setCallback(StatusCallback statusCallback) {
            super.setCallback(statusCallback);
            return this;
        }

        public final NewPermissionsRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            super.setLoginBehavior(sessionLoginBehavior);
            return this;
        }

        public final NewPermissionsRequest setRequestCode(int i) {
            super.setRequestCode(i);
            return this;
        }

        public final NewPermissionsRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            super.setDefaultAudience(sessionDefaultAudience);
            return this;
        }

        AuthorizationRequest getAuthorizationClientRequest() {
            AuthorizationRequest authorizationClientRequest = super.getAuthorizationClientRequest();
            authorizationClientRequest.setRerequest(true);
            return authorizationClientRequest;
        }
    }

    public final class OpenRequest extends AuthorizationRequest {
        private static final long serialVersionUID = 1;

        public OpenRequest(Activity activity) {
            super(activity);
        }

        public OpenRequest(Fragment fragment) {
            super(fragment);
        }

        public final OpenRequest setCallback(StatusCallback statusCallback) {
            super.setCallback(statusCallback);
            return this;
        }

        public final OpenRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            super.setLoginBehavior(sessionLoginBehavior);
            return this;
        }

        public final OpenRequest setRequestCode(int i) {
            super.setRequestCode(i);
            return this;
        }

        public final OpenRequest setPermissions(List<String> list) {
            super.setPermissions((List) list);
            return this;
        }

        public final OpenRequest setPermissions(String... strArr) {
            super.setPermissions(strArr);
            return this;
        }

        public final OpenRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            super.setDefaultAudience(sessionDefaultAudience);
            return this;
        }
    }

    class PermissionsPair {
        List<String> declinedPermissions;
        List<String> grantedPermissions;

        public PermissionsPair(List<String> list, List<String> list2) {
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
        }

        public List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }
    }

    class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 7663436173185080063L;
        private final String applicationId;
        private final Date lastAttemptedTokenExtendDate;
        private final AuthorizationRequest pendingAuthorizationRequest;
        private final boolean shouldAutoPublish;
        private final SessionState state;
        private final AccessToken tokenInfo;

        SerializationProxyV1(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest) {
            this.applicationId = str;
            this.state = sessionState;
            this.tokenInfo = accessToken;
            this.lastAttemptedTokenExtendDate = date;
            this.shouldAutoPublish = z;
            this.pendingAuthorizationRequest = authorizationRequest;
        }

        private Object readResolve() {
            return new Session(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, this.shouldAutoPublish, this.pendingAuthorizationRequest);
        }
    }

    class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 7663436173185080064L;
        private final String applicationId;
        private final Date lastAttemptedTokenExtendDate;
        private final AuthorizationRequest pendingAuthorizationRequest;
        private final Set<String> requestedPermissions;
        private final boolean shouldAutoPublish;
        private final SessionState state;
        private final AccessToken tokenInfo;

        SerializationProxyV2(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest, Set<String> set) {
            this.applicationId = str;
            this.state = sessionState;
            this.tokenInfo = accessToken;
            this.lastAttemptedTokenExtendDate = date;
            this.shouldAutoPublish = z;
            this.pendingAuthorizationRequest = authorizationRequest;
            this.requestedPermissions = set;
        }

        private Object readResolve() {
            return new Session(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, this.shouldAutoPublish, this.pendingAuthorizationRequest, this.requestedPermissions);
        }
    }

    public interface StatusCallback {
        void call(Session session, SessionState sessionState, Exception exception);
    }

    class TokenRefreshRequest implements ServiceConnection {
        final Messenger messageReceiver;
        Messenger messageSender = null;

        TokenRefreshRequest() {
            this.messageReceiver = new Messenger(new TokenRefreshRequestHandler(Session.this, this));
        }

        public void bind() {
            Intent createTokenRefreshIntent = NativeProtocol.createTokenRefreshIntent(Session.getStaticContext());
            if (createTokenRefreshIntent == null || !Session.staticContext.bindService(createTokenRefreshIntent, this, 1)) {
                cleanup();
            } else {
                Session.this.setLastAttemptedTokenExtendDate(new Date());
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.messageSender = new Messenger(iBinder);
            refreshToken();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            cleanup();
            try {
                Session.staticContext.unbindService(this);
            } catch (IllegalArgumentException e) {
            }
        }

        private void cleanup() {
            if (Session.this.currentTokenRefreshRequest == this) {
                Session.this.currentTokenRefreshRequest = null;
            }
        }

        private void refreshToken() {
            Bundle bundle = new Bundle();
            bundle.putString("access_token", Session.this.getTokenInfo().getToken());
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            obtain.replyTo = this.messageReceiver;
            try {
                this.messageSender.send(obtain);
            } catch (RemoteException e) {
                cleanup();
            }
        }
    }

    class TokenRefreshRequestHandler extends Handler {
        private WeakReference<TokenRefreshRequest> refreshRequestWeakReference;
        private WeakReference<Session> sessionWeakReference;

        TokenRefreshRequestHandler(Session session, TokenRefreshRequest tokenRefreshRequest) {
            super(Looper.getMainLooper());
            this.sessionWeakReference = new WeakReference(session);
            this.refreshRequestWeakReference = new WeakReference(tokenRefreshRequest);
        }

        public void handleMessage(Message message) {
            String string = message.getData().getString("access_token");
            Session session = (Session) this.sessionWeakReference.get();
            if (!(session == null || string == null)) {
                session.extendTokenCompleted(message.getData());
            }
            TokenRefreshRequest tokenRefreshRequest = (TokenRefreshRequest) this.refreshRequestWeakReference.get();
            if (tokenRefreshRequest != null) {
                Session.staticContext.unbindService(tokenRefreshRequest);
                tokenRefreshRequest.cleanup();
            }
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$SessionState() {
        int[] iArr = $SWITCH_TABLE$com$facebook$SessionState;
        if (iArr == null) {
            iArr = new int[SessionState.values().length];
            try {
                iArr[SessionState.CLOSED.ordinal()] = 7;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SessionState.CLOSED_LOGIN_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SessionState.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SessionState.CREATED_TOKEN_LOADED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SessionState.OPENED.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[SessionState.OPENED_TOKEN_UPDATED.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[SessionState.OPENING.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            $SWITCH_TABLE$com$facebook$SessionState = iArr;
        }
        return iArr;
    }

    private Session(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest) {
        this.lastAttemptedTokenExtendDate = new Date(0);
        this.lock = new Object();
        this.applicationId = str;
        this.state = sessionState;
        this.tokenInfo = accessToken;
        this.lastAttemptedTokenExtendDate = date;
        this.pendingAuthorizationRequest = authorizationRequest;
        this.handler = new Handler(Looper.getMainLooper());
        this.currentTokenRefreshRequest = null;
        this.tokenCachingStrategy = null;
        this.callbacks = new ArrayList();
    }

    private Session(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest, Set<String> set) {
        this.lastAttemptedTokenExtendDate = new Date(0);
        this.lock = new Object();
        this.applicationId = str;
        this.state = sessionState;
        this.tokenInfo = accessToken;
        this.lastAttemptedTokenExtendDate = date;
        this.pendingAuthorizationRequest = authorizationRequest;
        this.handler = new Handler(Looper.getMainLooper());
        this.currentTokenRefreshRequest = null;
        this.tokenCachingStrategy = null;
        this.callbacks = new ArrayList();
    }

    public Session(Context context) {
        this(context, null, null, true);
    }

    Session(Context context, String str, TokenCachingStrategy tokenCachingStrategy) {
        this(context, str, tokenCachingStrategy, true);
    }

    Session(Context context, String str, TokenCachingStrategy tokenCachingStrategy, boolean z) {
        Bundle bundle = null;
        this.lastAttemptedTokenExtendDate = new Date(0);
        this.lock = new Object();
        if (context != null && str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        initializeStaticContext(context);
        if (tokenCachingStrategy == null) {
            tokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(staticContext);
        }
        this.applicationId = str;
        this.tokenCachingStrategy = tokenCachingStrategy;
        this.state = SessionState.CREATED;
        this.pendingAuthorizationRequest = null;
        this.callbacks = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        if (z) {
            bundle = tokenCachingStrategy.load();
        }
        if (TokenCachingStrategy.hasTokenInformation(bundle)) {
            Date date = TokenCachingStrategy.getDate(bundle, TokenCachingStrategy.EXPIRATION_DATE_KEY);
            Date date2 = new Date();
            if (date == null || date.before(date2)) {
                tokenCachingStrategy.clear();
                this.tokenInfo = AccessToken.createEmptyToken();
                return;
            }
            this.tokenInfo = AccessToken.createFromCache(bundle);
            this.state = SessionState.CREATED_TOKEN_LOADED;
            return;
        }
        this.tokenInfo = AccessToken.createEmptyToken();
    }

    public final Bundle getAuthorizationBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = this.authorizationBundle;
        }
        return bundle;
    }

    public final boolean isOpened() {
        boolean isOpened;
        synchronized (this.lock) {
            isOpened = this.state.isOpened();
        }
        return isOpened;
    }

    public final boolean isClosed() {
        boolean isClosed;
        synchronized (this.lock) {
            isClosed = this.state.isClosed();
        }
        return isClosed;
    }

    public final SessionState getState() {
        SessionState sessionState;
        synchronized (this.lock) {
            sessionState = this.state;
        }
        return sessionState;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getAccessToken() {
        String token;
        synchronized (this.lock) {
            token = this.tokenInfo == null ? null : this.tokenInfo.getToken();
        }
        return token;
    }

    public final Date getExpirationDate() {
        Date expires;
        synchronized (this.lock) {
            expires = this.tokenInfo == null ? null : this.tokenInfo.getExpires();
        }
        return expires;
    }

    public final List<String> getPermissions() {
        List<String> permissions;
        synchronized (this.lock) {
            permissions = this.tokenInfo == null ? null : this.tokenInfo.getPermissions();
        }
        return permissions;
    }

    public boolean isPermissionGranted(String str) {
        List permissions = getPermissions();
        if (permissions != null) {
            return permissions.contains(str);
        }
        return false;
    }

    public final List<String> getDeclinedPermissions() {
        List<String> declinedPermissions;
        synchronized (this.lock) {
            declinedPermissions = this.tokenInfo == null ? null : this.tokenInfo.getDeclinedPermissions();
        }
        return declinedPermissions;
    }

    public final void openForRead(OpenRequest openRequest) {
        open(openRequest, SessionAuthorizationType.READ);
    }

    public final void openForPublish(OpenRequest openRequest) {
        open(openRequest, SessionAuthorizationType.PUBLISH);
    }

    public final void open(AccessToken accessToken, StatusCallback statusCallback) {
        synchronized (this.lock) {
            if (this.pendingAuthorizationRequest != null) {
                throw new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request.");
            } else if (this.state.isClosed()) {
                throw new UnsupportedOperationException("Session: an attempt was made to open a previously-closed session.");
            } else if (this.state == SessionState.CREATED || this.state == SessionState.CREATED_TOKEN_LOADED) {
                if (statusCallback != null) {
                    addCallback(statusCallback);
                }
                this.tokenInfo = accessToken;
                if (this.tokenCachingStrategy != null) {
                    this.tokenCachingStrategy.save(accessToken.toCacheBundle());
                }
                SessionState sessionState = this.state;
                this.state = SessionState.OPENED;
                postStateChange(sessionState, this.state, null);
            } else {
                throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
            }
        }
        autoPublishAsync();
    }

    public final void requestNewReadPermissions(NewPermissionsRequest newPermissionsRequest) {
        requestNewPermissions(newPermissionsRequest, SessionAuthorizationType.READ);
    }

    public final void requestNewPublishPermissions(NewPermissionsRequest newPermissionsRequest) {
        requestNewPermissions(newPermissionsRequest, SessionAuthorizationType.PUBLISH);
    }

    public final void refreshPermissions() {
        Request request = new Request(this, "me/permissions");
        request.setCallback(new C05572());
        request.executeAsync();
    }

    static PermissionsPair handlePermissionResponse(Response response) {
        if (response.getError() != null) {
            return null;
        }
        GraphMultiResult graphMultiResult = (GraphMultiResult) response.getGraphObjectAs(GraphMultiResult.class);
        if (graphMultiResult == null) {
            return null;
        }
        GraphObjectList<GraphObject> data = graphMultiResult.getData();
        if (data == null || data.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(data.size());
        List arrayList2 = new ArrayList(data.size());
        GraphObject graphObject = (GraphObject) data.get(0);
        if (graphObject.getProperty("permission") != null) {
            for (GraphObject graphObject2 : data) {
                String str = (String) graphObject2.getProperty("permission");
                if (!str.equals("installed")) {
                    String str2 = (String) graphObject2.getProperty("status");
                    if (str2.equals("granted")) {
                        arrayList.add(str);
                    } else if (str2.equals("declined")) {
                        arrayList2.add(str);
                    }
                }
            }
        } else {
            for (Entry entry : graphObject2.asMap().entrySet()) {
                if (!((String) entry.getKey()).equals("installed") && ((Integer) entry.getValue()).intValue() == 1) {
                    arrayList.add((String) entry.getKey());
                }
            }
        }
        return new PermissionsPair(arrayList, arrayList2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onActivityResult(android.app.Activity r7, int r8, int r9, android.content.Intent r10) {
        /*
        r6 = this;
        r3 = 0;
        r1 = 1;
        r0 = "currentActivity";
        com.facebook.internal.Validate.notNull(r7, r0);
        initializeStaticContext(r7);
        r2 = r6.lock;
        monitor-enter(r2);
        r0 = r6.pendingAuthorizationRequest;	 Catch:{ all -> 0x0030 }
        if (r0 == 0) goto L_0x0019;
    L_0x0011:
        r0 = r6.pendingAuthorizationRequest;	 Catch:{ all -> 0x0030 }
        r0 = r0.getRequestCode();	 Catch:{ all -> 0x0030 }
        if (r8 == r0) goto L_0x001c;
    L_0x0019:
        monitor-exit(r2);	 Catch:{ all -> 0x0030 }
        r0 = 0;
    L_0x001b:
        return r0;
    L_0x001c:
        monitor-exit(r2);	 Catch:{ all -> 0x0030 }
        r2 = com.facebook.AuthorizationClient.Result.Code.ERROR;
        if (r10 == 0) goto L_0x003e;
    L_0x0021:
        r0 = "com.facebook.LoginActivity:Result";
        r0 = r10.getSerializableExtra(r0);
        r0 = (com.facebook.AuthorizationClient.Result) r0;
        if (r0 == 0) goto L_0x0033;
    L_0x002b:
        r6.handleAuthorizationResult(r9, r0);
        r0 = r1;
        goto L_0x001b;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0030 }
        throw r0;
    L_0x0033:
        r0 = r6.authorizationClient;
        if (r0 == 0) goto L_0x005d;
    L_0x0037:
        r0 = r6.authorizationClient;
        r0.onActivityResult(r8, r9, r10);
        r0 = r1;
        goto L_0x001b;
    L_0x003e:
        if (r9 != 0) goto L_0x005d;
    L_0x0040:
        r2 = new com.facebook.FacebookOperationCanceledException;
        r0 = "User canceled operation.";
        r2.<init>(r0);
        r0 = com.facebook.AuthorizationClient.Result.Code.CANCEL;
        r5 = r0;
        r0 = r2;
        r2 = r5;
    L_0x004c:
        if (r0 != 0) goto L_0x0055;
    L_0x004e:
        r0 = new com.facebook.FacebookException;
        r4 = "Unexpected call to Session.onActivityResult";
        r0.<init>(r4);
    L_0x0055:
        r6.logAuthorizationComplete(r2, r3, r0);
        r6.finishAuthOrReauth(r3, r0);
        r0 = r1;
        goto L_0x001b;
    L_0x005d:
        r0 = r3;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.Session.onActivityResult(android.app.Activity, int, int, android.content.Intent):boolean");
    }

    public final void close() {
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            switch ($SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()]) {
                case 1:
                case 3:
                    this.state = SessionState.CLOSED_LOGIN_FAILED;
                    postStateChange(sessionState, this.state, new FacebookException("Log in attempt aborted."));
                    break;
                case 2:
                case 4:
                case 5:
                    this.state = SessionState.CLOSED;
                    postStateChange(sessionState, this.state, null);
                    break;
            }
        }
    }

    public final void closeAndClearTokenInformation() {
        if (this.tokenCachingStrategy != null) {
            this.tokenCachingStrategy.clear();
        }
        Utility.clearFacebookCookies(staticContext);
        Utility.clearCaches(staticContext);
        close();
    }

    public final void addCallback(StatusCallback statusCallback) {
        synchronized (this.callbacks) {
            if (statusCallback != null) {
                if (!this.callbacks.contains(statusCallback)) {
                    this.callbacks.add(statusCallback);
                }
            }
        }
    }

    public final void removeCallback(StatusCallback statusCallback) {
        synchronized (this.callbacks) {
            this.callbacks.remove(statusCallback);
        }
    }

    public String toString() {
        return "{Session" + " state:" + this.state + ", token:" + (this.tokenInfo == null ? "null" : this.tokenInfo) + ", appId:" + (this.applicationId == null ? "null" : this.applicationId) + "}";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void extendTokenCompleted(android.os.Bundle r5) {
        /*
        r4 = this;
        r1 = r4.lock;
        monitor-enter(r1);
        r0 = r4.state;	 Catch:{ all -> 0x004f }
        r2 = $SWITCH_TABLE$com$facebook$SessionState();	 Catch:{ all -> 0x004f }
        r3 = r4.state;	 Catch:{ all -> 0x004f }
        r3 = r3.ordinal();	 Catch:{ all -> 0x004f }
        r2 = r2[r3];	 Catch:{ all -> 0x004f }
        switch(r2) {
            case 4: goto L_0x002c;
            case 5: goto L_0x0036;
            default: goto L_0x0014;
        };	 Catch:{ all -> 0x004f }
    L_0x0014:
        r0 = TAG;	 Catch:{ all -> 0x004f }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004f }
        r3 = "refreshToken ignored in state ";
        r2.<init>(r3);	 Catch:{ all -> 0x004f }
        r3 = r4.state;	 Catch:{ all -> 0x004f }
        r2 = r2.append(r3);	 Catch:{ all -> 0x004f }
        r2 = r2.toString();	 Catch:{ all -> 0x004f }
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x004f }
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
    L_0x002b:
        return;
    L_0x002c:
        r2 = com.facebook.SessionState.OPENED_TOKEN_UPDATED;	 Catch:{ all -> 0x004f }
        r4.state = r2;	 Catch:{ all -> 0x004f }
        r2 = r4.state;	 Catch:{ all -> 0x004f }
        r3 = 0;
        r4.postStateChange(r0, r2, r3);	 Catch:{ all -> 0x004f }
    L_0x0036:
        r0 = r4.tokenInfo;	 Catch:{ all -> 0x004f }
        r0 = com.facebook.AccessToken.createFromRefresh(r0, r5);	 Catch:{ all -> 0x004f }
        r4.tokenInfo = r0;	 Catch:{ all -> 0x004f }
        r0 = r4.tokenCachingStrategy;	 Catch:{ all -> 0x004f }
        if (r0 == 0) goto L_0x004d;
    L_0x0042:
        r0 = r4.tokenCachingStrategy;	 Catch:{ all -> 0x004f }
        r2 = r4.tokenInfo;	 Catch:{ all -> 0x004f }
        r2 = r2.toCacheBundle();	 Catch:{ all -> 0x004f }
        r0.save(r2);	 Catch:{ all -> 0x004f }
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        goto L_0x002b;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.Session.extendTokenCompleted(android.os.Bundle):void");
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, false, this.pendingAuthorizationRequest);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Cannot readObject, serialization proxy required");
    }

    public static final void saveSession(Session session, Bundle bundle) {
        if (bundle != null && session != null && !bundle.containsKey(SESSION_BUNDLE_SAVE_KEY)) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new ObjectOutputStream(byteArrayOutputStream).writeObject(session);
                bundle.putByteArray(SESSION_BUNDLE_SAVE_KEY, byteArrayOutputStream.toByteArray());
                bundle.putBundle(AUTH_BUNDLE_SAVE_KEY, session.authorizationBundle);
            } catch (Throwable e) {
                throw new FacebookException("Unable to save session.", e);
            }
        }
    }

    public static final Session restoreSession(Context context, TokenCachingStrategy tokenCachingStrategy, StatusCallback statusCallback, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        byte[] byteArray = bundle.getByteArray(SESSION_BUNDLE_SAVE_KEY);
        if (byteArray != null) {
            try {
                Session session = (Session) new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
                initializeStaticContext(context);
                if (tokenCachingStrategy != null) {
                    session.tokenCachingStrategy = tokenCachingStrategy;
                } else {
                    session.tokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(context);
                }
                if (statusCallback != null) {
                    session.addCallback(statusCallback);
                }
                session.authorizationBundle = bundle.getBundle(AUTH_BUNDLE_SAVE_KEY);
                return session;
            } catch (Throwable e) {
                Log.w(TAG, "Unable to restore session", e);
            } catch (Throwable e2) {
                Log.w(TAG, "Unable to restore session.", e2);
            }
        }
        return null;
    }

    public static final Session getActiveSession() {
        Session session;
        synchronized (STATIC_LOCK) {
            session = activeSession;
        }
        return session;
    }

    public static final void setActiveSession(Session session) {
        synchronized (STATIC_LOCK) {
            if (session != activeSession) {
                Session session2 = activeSession;
                if (session2 != null) {
                    session2.close();
                }
                activeSession = session;
                if (session2 != null) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_UNSET);
                }
                if (session != null) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_SET);
                    if (session.isOpened()) {
                        postActiveSessionAction(ACTION_ACTIVE_SESSION_OPENED);
                    }
                }
            }
        }
    }

    public static Session openActiveSessionFromCache(Context context) {
        return openActiveSession(context, false, null);
    }

    public static Session openActiveSession(Activity activity, boolean z, StatusCallback statusCallback) {
        return openActiveSession((Context) activity, z, new OpenRequest(activity).setCallback(statusCallback));
    }

    public static Session openActiveSession(Activity activity, boolean z, List<String> list, StatusCallback statusCallback) {
        return openActiveSession((Context) activity, z, new OpenRequest(activity).setCallback(statusCallback).setPermissions((List) list));
    }

    public static Session openActiveSession(Context context, Fragment fragment, boolean z, StatusCallback statusCallback) {
        return openActiveSession(context, z, new OpenRequest(fragment).setCallback(statusCallback));
    }

    public static Session openActiveSession(Context context, Fragment fragment, boolean z, List<String> list, StatusCallback statusCallback) {
        return openActiveSession(context, z, new OpenRequest(fragment).setCallback(statusCallback).setPermissions((List) list));
    }

    public static Session openActiveSessionWithAccessToken(Context context, AccessToken accessToken, StatusCallback statusCallback) {
        Session session = new Session(context, null, null, false);
        setActiveSession(session);
        session.open(accessToken, statusCallback);
        return session;
    }

    private static Session openActiveSession(Context context, boolean z, OpenRequest openRequest) {
        Session build = new Builder(context).build();
        if (!SessionState.CREATED_TOKEN_LOADED.equals(build.getState()) && !z) {
            return null;
        }
        setActiveSession(build);
        build.openForRead(openRequest);
        return build;
    }

    static Context getStaticContext() {
        return staticContext;
    }

    static void initializeStaticContext(Context context) {
        if (context != null && staticContext == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            staticContext = context;
        }
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        boolean z;
        authorizationRequest.setApplicationId(this.applicationId);
        autoPublishAsync();
        logAuthorizationStart();
        boolean tryLoginActivity = tryLoginActivity(authorizationRequest);
        this.pendingAuthorizationRequest.loggingExtras.put("try_login_activity", tryLoginActivity ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (tryLoginActivity || !authorizationRequest.isLegacy) {
            z = tryLoginActivity;
        } else {
            this.pendingAuthorizationRequest.loggingExtras.put("try_legacy", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            tryLegacyAuth(authorizationRequest);
            z = true;
        }
        if (!z) {
            synchronized (this.lock) {
                SessionState sessionState = this.state;
                switch ($SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()]) {
                    case 6:
                    case 7:
                        return;
                    default:
                        this.state = SessionState.CLOSED_LOGIN_FAILED;
                        Exception facebookException = new FacebookException("Log in attempt failed: LoginActivity could not be started, and not legacy request");
                        logAuthorizationComplete(Code.ERROR, null, facebookException);
                        postStateChange(sessionState, this.state, facebookException);
                        return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void open(com.facebook.Session.OpenRequest r6, com.facebook.internal.SessionAuthorizationType r7) {
        /*
        r5 = this;
        r5.validatePermissions(r6, r7);
        r5.validateLoginBehavior(r6);
        r1 = r5.lock;
        monitor-enter(r1);
        r0 = r5.pendingAuthorizationRequest;	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x001d;
    L_0x000d:
        r0 = r5.state;	 Catch:{ all -> 0x0036 }
        r2 = r5.state;	 Catch:{ all -> 0x0036 }
        r3 = new java.lang.UnsupportedOperationException;	 Catch:{ all -> 0x0036 }
        r4 = "Session: an attempt was made to open a session that has a pending request.";
        r3.<init>(r4);	 Catch:{ all -> 0x0036 }
        r5.postStateChange(r0, r2, r3);	 Catch:{ all -> 0x0036 }
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
    L_0x001c:
        return;
    L_0x001d:
        r2 = r5.state;	 Catch:{ all -> 0x0036 }
        r0 = $SWITCH_TABLE$com$facebook$SessionState();	 Catch:{ all -> 0x0036 }
        r3 = r5.state;	 Catch:{ all -> 0x0036 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0036 }
        r0 = r0[r3];	 Catch:{ all -> 0x0036 }
        switch(r0) {
            case 1: goto L_0x0039;
            case 2: goto L_0x005f;
            default: goto L_0x002e;
        };	 Catch:{ all -> 0x0036 }
    L_0x002e:
        r0 = new java.lang.UnsupportedOperationException;	 Catch:{ all -> 0x0036 }
        r2 = "Session: an attempt was made to open an already opened session.";
        r0.<init>(r2);	 Catch:{ all -> 0x0036 }
        throw r0;	 Catch:{ all -> 0x0036 }
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        throw r0;
    L_0x0039:
        r0 = com.facebook.SessionState.OPENING;	 Catch:{ all -> 0x0036 }
        r5.state = r0;	 Catch:{ all -> 0x0036 }
        if (r6 != 0) goto L_0x0047;
    L_0x003f:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0036 }
        r2 = "openRequest cannot be null when opening a new Session";
        r0.<init>(r2);	 Catch:{ all -> 0x0036 }
        throw r0;	 Catch:{ all -> 0x0036 }
    L_0x0047:
        r5.pendingAuthorizationRequest = r6;	 Catch:{ all -> 0x0036 }
    L_0x0049:
        if (r6 == 0) goto L_0x0052;
    L_0x004b:
        r3 = r6.getCallback();	 Catch:{ all -> 0x0036 }
        r5.addCallback(r3);	 Catch:{ all -> 0x0036 }
    L_0x0052:
        r3 = 0;
        r5.postStateChange(r2, r0, r3);	 Catch:{ all -> 0x0036 }
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        r1 = com.facebook.SessionState.OPENING;
        if (r0 != r1) goto L_0x001c;
    L_0x005b:
        r5.authorize(r6);
        goto L_0x001c;
    L_0x005f:
        if (r6 == 0) goto L_0x007b;
    L_0x0061:
        r0 = r6.getPermissions();	 Catch:{ all -> 0x0036 }
        r0 = com.facebook.internal.Utility.isNullOrEmpty(r0);	 Catch:{ all -> 0x0036 }
        if (r0 != 0) goto L_0x007b;
    L_0x006b:
        r0 = r6.getPermissions();	 Catch:{ all -> 0x0036 }
        r3 = r5.getPermissions();	 Catch:{ all -> 0x0036 }
        r0 = com.facebook.internal.Utility.isSubset(r0, r3);	 Catch:{ all -> 0x0036 }
        if (r0 != 0) goto L_0x007b;
    L_0x0079:
        r5.pendingAuthorizationRequest = r6;	 Catch:{ all -> 0x0036 }
    L_0x007b:
        r0 = r5.pendingAuthorizationRequest;	 Catch:{ all -> 0x0036 }
        if (r0 != 0) goto L_0x0084;
    L_0x007f:
        r0 = com.facebook.SessionState.OPENED;	 Catch:{ all -> 0x0036 }
        r5.state = r0;	 Catch:{ all -> 0x0036 }
        goto L_0x0049;
    L_0x0084:
        r0 = com.facebook.SessionState.OPENING;	 Catch:{ all -> 0x0036 }
        r5.state = r0;	 Catch:{ all -> 0x0036 }
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.Session.open(com.facebook.Session$OpenRequest, com.facebook.internal.SessionAuthorizationType):void");
    }

    private void requestNewPermissions(NewPermissionsRequest newPermissionsRequest, SessionAuthorizationType sessionAuthorizationType) {
        validatePermissions(newPermissionsRequest, sessionAuthorizationType);
        validateLoginBehavior(newPermissionsRequest);
        if (newPermissionsRequest != null) {
            synchronized (this.lock) {
                if (this.pendingAuthorizationRequest != null) {
                    throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that has a pending request.");
                } else if (this.state.isOpened()) {
                    this.pendingAuthorizationRequest = newPermissionsRequest;
                } else if (this.state.isClosed()) {
                    throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that has been closed.");
                } else {
                    throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that is not currently open.");
                }
            }
            newPermissionsRequest.setValidateSameFbidAsToken(getAccessToken());
            addCallback(newPermissionsRequest.getCallback());
            authorize(newPermissionsRequest);
        }
    }

    private void validateLoginBehavior(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest != null && !authorizationRequest.isLegacy) {
            Intent intent = new Intent();
            intent.setClass(getStaticContext(), LoginActivity.class);
            if (!resolveIntent(intent)) {
                throw new FacebookException(String.format("Cannot use SessionLoginBehavior %s when %s is not declared as an activity in AndroidManifest.xml", new Object[]{authorizationRequest.getLoginBehavior(), LoginActivity.class.getName()}));
            }
        }
    }

    private void validatePermissions(AuthorizationRequest authorizationRequest, SessionAuthorizationType sessionAuthorizationType) {
        if (authorizationRequest != null && !Utility.isNullOrEmpty(authorizationRequest.getPermissions())) {
            for (String isPublishPermission : authorizationRequest.getPermissions()) {
                if (isPublishPermission(isPublishPermission)) {
                    if (SessionAuthorizationType.READ.equals(sessionAuthorizationType)) {
                        throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{isPublishPermission}));
                    }
                } else if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                    Log.w(TAG, String.format("Should not pass a read permission (%s) to a request for publish or manage authorization", new Object[]{isPublishPermission}));
                }
            }
        } else if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
            throw new FacebookException("Cannot request publish or manage authorization with no permissions.");
        }
    }

    public static boolean isPublishPermission(String str) {
        return str != null && (str.startsWith(PUBLISH_PERMISSION_PREFIX) || str.startsWith(MANAGE_PERMISSION_PREFIX) || OTHER_PUBLISH_PERMISSIONS.contains(str));
    }

    private void handleAuthorizationResult(int i, Result result) {
        AccessToken accessToken;
        Exception exception;
        if (i == -1) {
            if (result.code == Code.SUCCESS) {
                accessToken = result.token;
                exception = null;
            } else {
                exception = new FacebookAuthorizationException(result.errorMessage);
                accessToken = null;
            }
        } else if (i == 0) {
            exception = new FacebookOperationCanceledException(result.errorMessage);
            accessToken = null;
        } else {
            exception = null;
            accessToken = null;
        }
        logAuthorizationComplete(result.code, result.loggingExtras, exception);
        this.authorizationClient = null;
        finishAuthOrReauth(accessToken, exception);
    }

    private void logAuthorizationStart() {
        Bundle newAuthorizationLoggingBundle = AuthorizationClient.newAuthorizationLoggingBundle(this.pendingAuthorizationRequest.getAuthId());
        newAuthorizationLoggingBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", this.pendingAuthorizationRequest.loginBehavior.toString());
            jSONObject.put("request_code", this.pendingAuthorizationRequest.requestCode);
            jSONObject.put("is_legacy", this.pendingAuthorizationRequest.isLegacy);
            jSONObject.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, TextUtils.join(",", this.pendingAuthorizationRequest.permissions));
            jSONObject.put(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, this.pendingAuthorizationRequest.defaultAudience.toString());
            newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
        } catch (JSONException e) {
        }
        getAppEventsLogger().logSdkEvent("fb_mobile_login_start", null, newAuthorizationLoggingBundle);
    }

    private void logAuthorizationComplete(Code code, Map<String, String> map, Exception exception) {
        Bundle newAuthorizationLoggingBundle;
        if (this.pendingAuthorizationRequest == null) {
            newAuthorizationLoggingBundle = AuthorizationClient.newAuthorizationLoggingBundle("");
            newAuthorizationLoggingBundle.putString("2_result", Code.ERROR.getLoggingValue());
            newAuthorizationLoggingBundle.putString("5_error_message", "Unexpected call to logAuthorizationComplete with null pendingAuthorizationRequest.");
        } else {
            JSONObject jSONObject;
            Bundle newAuthorizationLoggingBundle2 = AuthorizationClient.newAuthorizationLoggingBundle(this.pendingAuthorizationRequest.getAuthId());
            if (code != null) {
                newAuthorizationLoggingBundle2.putString("2_result", code.getLoggingValue());
            }
            if (!(exception == null || exception.getMessage() == null)) {
                newAuthorizationLoggingBundle2.putString("5_error_message", exception.getMessage());
            }
            if (this.pendingAuthorizationRequest.loggingExtras.isEmpty()) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(this.pendingAuthorizationRequest.loggingExtras);
            }
            if (map != null) {
                JSONObject jSONObject2;
                if (jSONObject == null) {
                    jSONObject2 = new JSONObject();
                } else {
                    jSONObject2 = jSONObject;
                }
                try {
                    for (Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    jSONObject = jSONObject2;
                } catch (JSONException e) {
                    jSONObject = jSONObject2;
                }
            }
            if (jSONObject != null) {
                newAuthorizationLoggingBundle2.putString("6_extras", jSONObject.toString());
            }
            newAuthorizationLoggingBundle = newAuthorizationLoggingBundle2;
        }
        newAuthorizationLoggingBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        getAppEventsLogger().logSdkEvent("fb_mobile_login_complete", null, newAuthorizationLoggingBundle);
    }

    private boolean tryLoginActivity(AuthorizationRequest authorizationRequest) {
        Intent loginActivityIntent = getLoginActivityIntent(authorizationRequest);
        if (!resolveIntent(loginActivityIntent)) {
            return false;
        }
        try {
            authorizationRequest.getStartActivityDelegate().startActivityForResult(loginActivityIntent, authorizationRequest.getRequestCode());
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    private boolean resolveIntent(Intent intent) {
        if (getStaticContext().getPackageManager().resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }

    private Intent getLoginActivityIntent(AuthorizationRequest authorizationRequest) {
        Intent intent = new Intent();
        intent.setClass(getStaticContext(), LoginActivity.class);
        intent.setAction(authorizationRequest.getLoginBehavior().toString());
        intent.putExtras(LoginActivity.populateIntentExtras(authorizationRequest.getAuthorizationClientRequest()));
        return intent;
    }

    private void tryLegacyAuth(AuthorizationRequest authorizationRequest) {
        this.authorizationClient = new AuthorizationClient();
        this.authorizationClient.setOnCompletedListener(new C05583());
        this.authorizationClient.setContext(getStaticContext());
        this.authorizationClient.startOrContinueAuth(authorizationRequest.getAuthorizationClientRequest());
    }

    void finishAuthOrReauth(AccessToken accessToken, Exception exception) {
        if (accessToken != null && accessToken.isInvalid()) {
            accessToken = null;
            exception = new FacebookException("Invalid access token.");
        }
        synchronized (this.lock) {
            switch ($SWITCH_TABLE$com$facebook$SessionState()[this.state.ordinal()]) {
                case 1:
                case 2:
                case 6:
                case 7:
                    Log.d(TAG, "Unexpected call to finishAuthOrReauth in state " + this.state);
                    break;
                case 3:
                    finishAuthorization(accessToken, exception);
                    break;
                case 4:
                case 5:
                    finishReauthorization(accessToken, exception);
                    break;
            }
        }
    }

    private void finishAuthorization(AccessToken accessToken, Exception exception) {
        SessionState sessionState = this.state;
        if (accessToken != null) {
            this.tokenInfo = accessToken;
            saveTokenToCache(accessToken);
            this.state = SessionState.OPENED;
        } else if (exception != null) {
            this.state = SessionState.CLOSED_LOGIN_FAILED;
        }
        this.pendingAuthorizationRequest = null;
        postStateChange(sessionState, this.state, exception);
    }

    private void finishReauthorization(AccessToken accessToken, Exception exception) {
        SessionState sessionState = this.state;
        if (accessToken != null) {
            this.tokenInfo = accessToken;
            saveTokenToCache(accessToken);
            this.state = SessionState.OPENED_TOKEN_UPDATED;
        }
        this.pendingAuthorizationRequest = null;
        postStateChange(sessionState, this.state, exception);
    }

    private void saveTokenToCache(AccessToken accessToken) {
        if (accessToken != null && this.tokenCachingStrategy != null) {
            this.tokenCachingStrategy.save(accessToken.toCacheBundle());
        }
    }

    void postStateChange(SessionState sessionState, final SessionState sessionState2, final Exception exception) {
        if (sessionState != sessionState2 || sessionState == SessionState.OPENED_TOKEN_UPDATED || exception != null) {
            if (sessionState2.isClosed()) {
                this.tokenInfo = AccessToken.createEmptyToken();
            }
            runWithHandlerOrExecutor(this.handler, new Runnable() {
                public void run() {
                    synchronized (Session.this.callbacks) {
                        for (final StatusCallback statusCallback : Session.this.callbacks) {
                            final SessionState sessionState = sessionState2;
                            final Exception exception = exception;
                            Session.runWithHandlerOrExecutor(Session.this.handler, new Runnable() {
                                public void run() {
                                    statusCallback.call(Session.this, sessionState, exception);
                                }
                            });
                        }
                    }
                }
            });
            if (this == activeSession && sessionState.isOpened() != sessionState2.isOpened()) {
                if (sessionState2.isOpened()) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_OPENED);
                } else {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_CLOSED);
                }
            }
        }
    }

    static void postActiveSessionAction(String str) {
        C0090q.m145a(getStaticContext()).m150a(new Intent(str));
    }

    private static void runWithHandlerOrExecutor(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            Settings.getExecutor().execute(runnable);
        }
    }

    void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            extendAccessToken();
        }
    }

    void extendAccessToken() {
        TokenRefreshRequest tokenRefreshRequest = null;
        synchronized (this.lock) {
            if (this.currentTokenRefreshRequest == null) {
                tokenRefreshRequest = new TokenRefreshRequest();
                this.currentTokenRefreshRequest = tokenRefreshRequest;
            }
        }
        if (tokenRefreshRequest != null) {
            tokenRefreshRequest.bind();
        }
    }

    boolean shouldExtendAccessToken() {
        if (this.currentTokenRefreshRequest != null) {
            return false;
        }
        Date date = new Date();
        if (!this.state.isOpened() || !this.tokenInfo.getSource().canExtendToken() || date.getTime() - this.lastAttemptedTokenExtendDate.getTime() <= 3600000 || date.getTime() - this.tokenInfo.getLastRefresh().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    private AppEventsLogger getAppEventsLogger() {
        AppEventsLogger appEventsLogger;
        synchronized (this.lock) {
            if (this.appEventsLogger == null) {
                this.appEventsLogger = AppEventsLogger.newLogger(staticContext, this.applicationId);
            }
            appEventsLogger = this.appEventsLogger;
        }
        return appEventsLogger;
    }

    AccessToken getTokenInfo() {
        return this.tokenInfo;
    }

    void setTokenInfo(AccessToken accessToken) {
        this.tokenInfo = accessToken;
    }

    Date getLastAttemptedTokenExtendDate() {
        return this.lastAttemptedTokenExtendDate;
    }

    void setLastAttemptedTokenExtendDate(Date date) {
        this.lastAttemptedTokenExtendDate = date;
    }

    void setCurrentTokenRefreshRequest(TokenRefreshRequest tokenRefreshRequest) {
        this.currentTokenRefreshRequest = tokenRefreshRequest;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        if (areEqual(session.applicationId, this.applicationId) && areEqual(session.authorizationBundle, this.authorizationBundle) && areEqual(session.state, this.state) && areEqual(session.getExpirationDate(), getExpirationDate())) {
            return true;
        }
        return false;
    }

    private static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    private void autoPublishAsync() {
        AutoPublishAsyncTask autoPublishAsyncTask = null;
        synchronized (this) {
            if (this.autoPublishAsyncTask == null && Settings.getShouldAutoPublishInstall()) {
                String str = this.applicationId;
                if (str != null) {
                    autoPublishAsyncTask = new AutoPublishAsyncTask(str, staticContext);
                    this.autoPublishAsyncTask = autoPublishAsyncTask;
                }
            }
        }
        if (autoPublishAsyncTask != null) {
            autoPublishAsyncTask.execute(new Void[0]);
        }
    }
}
