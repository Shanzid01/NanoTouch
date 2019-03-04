package com.facebook.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.android.C0572R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.model.GraphUser;
import com.facebook.widget.ToolTipPopup.Style;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LoginButton extends Button {
    private static final String TAG = LoginButton.class.getName();
    private String applicationId = null;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private OnClickListener listenerCallback;
    private String loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
    private String loginText;
    private String logoutText;
    private boolean nuxChecked;
    private long nuxDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    private ToolTipMode nuxMode = ToolTipMode.DEFAULT;
    private ToolTipPopup nuxPopup;
    private Style nuxStyle = Style.BLUE;
    private Fragment parentFragment;
    private LoginButtonProperties properties = new LoginButtonProperties();
    private SessionTracker sessionTracker;
    private GraphUser user = null;
    private UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession = null;

    class LoginButtonCallback implements StatusCallback {
        private LoginButtonCallback() {
        }

        public void call(Session session, SessionState sessionState, Exception exception) {
            LoginButton.this.fetchUserInfo();
            LoginButton.this.setButtonText();
            if (LoginButton.this.properties.sessionStatusCallback != null) {
                LoginButton.this.properties.sessionStatusCallback.call(session, sessionState, exception);
            } else if (exception != null) {
                LoginButton.this.handleError(exception);
            }
        }
    }

    class LoginButtonProperties {
        private SessionAuthorizationType authorizationType = null;
        private SessionDefaultAudience defaultAudience = SessionDefaultAudience.FRIENDS;
        private SessionLoginBehavior loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
        private OnErrorListener onErrorListener;
        private List<String> permissions = Collections.emptyList();
        private StatusCallback sessionStatusCallback;

        LoginButtonProperties() {
        }

        public void setOnErrorListener(OnErrorListener onErrorListener) {
            this.onErrorListener = onErrorListener;
        }

        public OnErrorListener getOnErrorListener() {
            return this.onErrorListener;
        }

        public void setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            this.defaultAudience = sessionDefaultAudience;
        }

        public SessionDefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public void setReadPermissions(List<String> list, Session session) {
            if (SessionAuthorizationType.PUBLISH.equals(this.authorizationType)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            } else if (validatePermissions(list, SessionAuthorizationType.READ, session)) {
                this.permissions = list;
                this.authorizationType = SessionAuthorizationType.READ;
            }
        }

        public void setPublishPermissions(List<String> list, Session session) {
            if (SessionAuthorizationType.READ.equals(this.authorizationType)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            } else if (validatePermissions(list, SessionAuthorizationType.PUBLISH, session)) {
                this.permissions = list;
                this.authorizationType = SessionAuthorizationType.PUBLISH;
            }
        }

        private boolean validatePermissions(List<String> list, SessionAuthorizationType sessionAuthorizationType, Session session) {
            if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType) && Utility.isNullOrEmpty((Collection) list)) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            } else if (session == null || !session.isOpened() || Utility.isSubset(list, session.getPermissions())) {
                return true;
            } else {
                Log.e(LoginButton.TAG, "Cannot set additional permissions when session is already open.");
                return false;
            }
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        public void clearPermissions() {
            this.permissions = null;
            this.authorizationType = null;
        }

        public void setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            this.loginBehavior = sessionLoginBehavior;
        }

        public SessionLoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public void setSessionStatusCallback(StatusCallback statusCallback) {
            this.sessionStatusCallback = statusCallback;
        }

        public StatusCallback getSessionStatusCallback() {
            return this.sessionStatusCallback;
        }
    }

    class LoginClickListener implements OnClickListener {
        private LoginClickListener() {
        }

        public void onClick(View view) {
            int i;
            Context context = LoginButton.this.getContext();
            final Session openSession = LoginButton.this.sessionTracker.getOpenSession();
            if (openSession == null) {
                Session session = LoginButton.this.sessionTracker.getSession();
                if (session == null || session.getState().isClosed()) {
                    LoginButton.this.sessionTracker.setSession(null);
                    session = new Builder(context).setApplicationId(LoginButton.this.applicationId).build();
                    Session.setActiveSession(session);
                }
                if (!session.isOpened()) {
                    OpenRequest openRequest;
                    if (LoginButton.this.parentFragment != null) {
                        openRequest = new OpenRequest(LoginButton.this.parentFragment);
                    } else if (context instanceof Activity) {
                        openRequest = new OpenRequest((Activity) context);
                    } else {
                        if (context instanceof ContextWrapper) {
                            context = ((ContextWrapper) context).getBaseContext();
                            if (context instanceof Activity) {
                                openRequest = new OpenRequest((Activity) context);
                            }
                        }
                        openRequest = null;
                    }
                    if (openRequest != null) {
                        openRequest.setDefaultAudience(LoginButton.this.properties.defaultAudience);
                        openRequest.setPermissions(LoginButton.this.properties.permissions);
                        openRequest.setLoginBehavior(LoginButton.this.properties.loginBehavior);
                        if (SessionAuthorizationType.PUBLISH.equals(LoginButton.this.properties.authorizationType)) {
                            session.openForPublish(openRequest);
                        } else {
                            session.openForRead(openRequest);
                        }
                    }
                }
            } else if (LoginButton.this.confirmLogout) {
                CharSequence string;
                CharSequence string2 = LoginButton.this.getResources().getString(C0572R.string.com_facebook_loginview_log_out_action);
                CharSequence string3 = LoginButton.this.getResources().getString(C0572R.string.com_facebook_loginview_cancel_action);
                if (LoginButton.this.user == null || LoginButton.this.user.getName() == null) {
                    string = LoginButton.this.getResources().getString(C0572R.string.com_facebook_loginview_logged_in_using_facebook);
                } else {
                    string = String.format(LoginButton.this.getResources().getString(C0572R.string.com_facebook_loginview_logged_in_as), new Object[]{LoginButton.this.user.getName()});
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(string).setCancelable(true).setPositiveButton(string2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openSession.closeAndClearTokenInformation();
                    }
                }).setNegativeButton(string3, null);
                builder.create().show();
            } else {
                openSession.closeAndClearTokenInformation();
            }
            AppEventsLogger newLogger = AppEventsLogger.newLogger(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            String str = "logging_in";
            if (openSession != null) {
                i = 0;
            } else {
                i = 1;
            }
            bundle.putInt(str, i);
            newLogger.logSdkEvent(LoginButton.this.loginLogoutEventName, null, bundle);
            if (LoginButton.this.listenerCallback != null) {
                LoginButton.this.listenerCallback.onClick(view);
            }
        }
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public enum ToolTipMode {
        DEFAULT,
        DISPLAY_ALWAYS,
        NEVER_DISPLAY
    }

    public interface UserInfoChangedCallback {
        void onUserInfoFetched(GraphUser graphUser);
    }

    public LoginButton(Context context) {
        super(context);
        initializeActiveSessionWithCachedToken(context);
        finishInit();
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet.getStyleAttribute() == 0) {
            setGravity(17);
            setTextColor(getResources().getColor(C0572R.color.com_facebook_loginview_text_color));
            setTextSize(0, getResources().getDimension(C0572R.dimen.com_facebook_loginview_text_size));
            setTypeface(Typeface.DEFAULT_BOLD);
            if (isInEditMode()) {
                setBackgroundColor(getResources().getColor(C0572R.color.com_facebook_blue));
                this.loginText = "Log in with Facebook";
            } else {
                setBackgroundResource(C0572R.drawable.com_facebook_button_blue);
                setCompoundDrawablesWithIntrinsicBounds(C0572R.drawable.com_facebook_inverse_icon, 0, 0, 0);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_loginview_compound_drawable_padding));
                setPadding(getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_loginview_padding_left), getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_loginview_padding_top), getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_loginview_padding_right), getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_loginview_padding_bottom));
            }
        }
        parseAttributes(attributeSet);
        if (!isInEditMode()) {
            initializeActiveSessionWithCachedToken(context);
        }
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        parseAttributes(attributeSet);
        initializeActiveSessionWithCachedToken(context);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.properties.setOnErrorListener(onErrorListener);
    }

    public OnErrorListener getOnErrorListener() {
        return this.properties.getOnErrorListener();
    }

    public void setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
        this.properties.setDefaultAudience(sessionDefaultAudience);
    }

    public SessionDefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public void setReadPermissions(List<String> list) {
        this.properties.setReadPermissions(list, this.sessionTracker.getSession());
    }

    public void setReadPermissions(String... strArr) {
        this.properties.setReadPermissions(Arrays.asList(strArr), this.sessionTracker.getSession());
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.setPublishPermissions(list, this.sessionTracker.getSession());
    }

    public void setPublishPermissions(String... strArr) {
        this.properties.setPublishPermissions(Arrays.asList(strArr), this.sessionTracker.getSession());
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public void setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
        this.properties.setLoginBehavior(sessionLoginBehavior);
    }

    public SessionLoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public UserInfoChangedCallback getUserInfoChangedCallback() {
        return this.userInfoChangedCallback;
    }

    public void setUserInfoChangedCallback(UserInfoChangedCallback userInfoChangedCallback) {
        this.userInfoChangedCallback = userInfoChangedCallback;
    }

    public void setSessionStatusCallback(StatusCallback statusCallback) {
        this.properties.setSessionStatusCallback(statusCallback);
    }

    public StatusCallback getSessionStatusCallback() {
        return this.properties.getSessionStatusCallback();
    }

    public void setToolTipStyle(Style style) {
        this.nuxStyle = style;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.nuxMode = toolTipMode;
    }

    public ToolTipMode getToolTipMode() {
        return this.nuxMode;
    }

    public void setToolTipDisplayTime(long j) {
        this.nuxDisplayTime = j;
    }

    public long getToolTipDisplayTime() {
        return this.nuxDisplayTime;
    }

    public void dismissToolTip() {
        if (this.nuxPopup != null) {
            this.nuxPopup.dismiss();
            this.nuxPopup = null;
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Session session = this.sessionTracker.getSession();
        if (session != null) {
            return session.onActivityResult((Activity) getContext(), i, i2, intent);
        }
        return false;
    }

    public void setSession(Session session) {
        this.sessionTracker.setSession(session);
        fetchUserInfo();
        setButtonText();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        finishInit();
    }

    private void finishInit() {
        super.setOnClickListener(new LoginClickListener());
        setButtonText();
        if (!isInEditMode()) {
            this.sessionTracker = new SessionTracker(getContext(), new LoginButtonCallback(), null, false);
            fetchUserInfo();
        }
    }

    public void setFragment(Fragment fragment) {
        this.parentFragment = fragment;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.sessionTracker != null && !this.sessionTracker.isTracking()) {
            this.sessionTracker.startTracking();
            fetchUserInfo();
            setButtonText();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.nuxChecked && this.nuxMode != ToolTipMode.NEVER_DISPLAY && !isInEditMode()) {
            this.nuxChecked = true;
            checkNuxSettings();
        }
    }

    private void showNuxPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
            displayNux(fetchedAppSettings.getNuxContent());
        }
    }

    private void displayNux(String str) {
        this.nuxPopup = new ToolTipPopup(str, this);
        this.nuxPopup.setStyle(this.nuxStyle);
        this.nuxPopup.setNuxDisplayTime(this.nuxDisplayTime);
        this.nuxPopup.show();
    }

    private void checkNuxSettings() {
        if (this.nuxMode == ToolTipMode.DISPLAY_ALWAYS) {
            displayNux(getResources().getString(C0572R.string.com_facebook_tooltip_default));
            return;
        }
        final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
        new AsyncTask<Void, Void, FetchedAppSettings>() {
            protected FetchedAppSettings doInBackground(Void... voidArr) {
                return Utility.queryAppSettings(metadataApplicationId, false);
            }

            protected void onPostExecute(FetchedAppSettings fetchedAppSettings) {
                LoginButton.this.showNuxPerSettings(fetchedAppSettings);
            }
        }.execute(null);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.sessionTracker != null) {
            this.sessionTracker.stopTracking();
        }
        dismissToolTip();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            dismissToolTip();
        }
    }

    List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    void setLoginLogoutEventName(String str) {
        this.loginLogoutEventName = str;
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0572R.styleable.com_facebook_login_view);
        this.confirmLogout = obtainStyledAttributes.getBoolean(C0572R.styleable.com_facebook_login_view_confirm_logout, true);
        this.fetchUserInfo = obtainStyledAttributes.getBoolean(C0572R.styleable.com_facebook_login_view_fetch_user_info, true);
        this.loginText = obtainStyledAttributes.getString(C0572R.styleable.com_facebook_login_view_login_text);
        this.logoutText = obtainStyledAttributes.getString(C0572R.styleable.com_facebook_login_view_logout_text);
        obtainStyledAttributes.recycle();
    }

    private void setButtonText() {
        CharSequence charSequence;
        if (this.sessionTracker == null || this.sessionTracker.getOpenSession() == null) {
            if (this.loginText != null) {
                charSequence = this.loginText;
            } else {
                charSequence = getResources().getString(C0572R.string.com_facebook_loginview_log_in_button);
            }
            setText(charSequence);
            return;
        }
        if (this.logoutText != null) {
            charSequence = this.logoutText;
        } else {
            charSequence = getResources().getString(C0572R.string.com_facebook_loginview_log_out_button);
        }
        setText(charSequence);
    }

    private boolean initializeActiveSessionWithCachedToken(Context context) {
        if (context == null) {
            return false;
        }
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            return activeSession.isOpened();
        }
        if (Utility.getMetadataApplicationId(context) == null || Session.openActiveSessionFromCache(context) == null) {
            return false;
        }
        return true;
    }

    private void fetchUserInfo() {
        if (this.fetchUserInfo) {
            final Session openSession = this.sessionTracker.getOpenSession();
            if (openSession == null) {
                this.user = null;
                if (this.userInfoChangedCallback != null) {
                    this.userInfoChangedCallback.onUserInfoFetched(this.user);
                }
            } else if (openSession != this.userInfoSession) {
                Request.executeBatchAsync(Request.newMeRequest(openSession, new GraphUserCallback() {
                    public void onCompleted(GraphUser graphUser, Response response) {
                        if (openSession == LoginButton.this.sessionTracker.getOpenSession()) {
                            LoginButton.this.user = graphUser;
                            if (LoginButton.this.userInfoChangedCallback != null) {
                                LoginButton.this.userInfoChangedCallback.onUserInfoFetched(LoginButton.this.user);
                            }
                        }
                        if (response.getError() != null) {
                            LoginButton.this.handleError(response.getError().getException());
                        }
                    }
                }));
                this.userInfoSession = openSession;
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.listenerCallback = onClickListener;
    }

    void handleError(Exception exception) {
        if (this.properties.onErrorListener == null) {
            return;
        }
        if (exception instanceof FacebookException) {
            this.properties.onErrorListener.onError((FacebookException) exception);
        } else {
            this.properties.onErrorListener.onError(new FacebookException((Throwable) exception));
        }
    }
}
