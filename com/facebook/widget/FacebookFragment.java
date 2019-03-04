package com.facebook.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import java.util.Date;
import java.util.List;

class FacebookFragment extends Fragment {
    private SessionTracker sessionTracker;

    class DefaultSessionStatusCallback implements StatusCallback {
        private DefaultSessionStatusCallback() {
        }

        public void call(Session session, SessionState sessionState, Exception exception) {
            FacebookFragment.this.onSessionStateChange(sessionState, exception);
        }
    }

    FacebookFragment() {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker(getActivity(), new DefaultSessionStatusCallback());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.sessionTracker.getSession().onActivityResult(getActivity(), i, i2, intent);
    }

    public void onDestroy() {
        super.onDestroy();
        this.sessionTracker.stopTracking();
    }

    public void setSession(Session session) {
        if (this.sessionTracker != null) {
            this.sessionTracker.setSession(session);
        }
    }

    protected void onSessionStateChange(SessionState sessionState, Exception exception) {
    }

    protected final Session getSession() {
        if (this.sessionTracker != null) {
            return this.sessionTracker.getSession();
        }
        return null;
    }

    protected final boolean isSessionOpen() {
        if (this.sessionTracker == null || this.sessionTracker.getOpenSession() == null) {
            return false;
        }
        return true;
    }

    protected final SessionState getSessionState() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session session = this.sessionTracker.getSession();
        if (session != null) {
            return session.getState();
        }
        return null;
    }

    protected final String getAccessToken() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session openSession = this.sessionTracker.getOpenSession();
        if (openSession != null) {
            return openSession.getAccessToken();
        }
        return null;
    }

    protected final Date getExpirationDate() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session openSession = this.sessionTracker.getOpenSession();
        if (openSession != null) {
            return openSession.getExpirationDate();
        }
        return null;
    }

    protected final void closeSession() {
        if (this.sessionTracker != null) {
            Session openSession = this.sessionTracker.getOpenSession();
            if (openSession != null) {
                openSession.close();
            }
        }
    }

    protected final void closeSessionAndClearTokenInformation() {
        if (this.sessionTracker != null) {
            Session openSession = this.sessionTracker.getOpenSession();
            if (openSession != null) {
                openSession.closeAndClearTokenInformation();
            }
        }
    }

    protected final List<String> getSessionPermissions() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session session = this.sessionTracker.getSession();
        if (session != null) {
            return session.getPermissions();
        }
        return null;
    }

    protected final void openSession() {
        openSessionForRead(null, null);
    }

    protected final void openSessionForRead(String str, List<String> list) {
        openSessionForRead(str, list, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForRead(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i) {
        openSession(str, list, sessionLoginBehavior, i, SessionAuthorizationType.READ);
    }

    protected final void openSessionForPublish(String str, List<String> list) {
        openSessionForPublish(str, list, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForPublish(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i) {
        openSession(str, list, sessionLoginBehavior, i, SessionAuthorizationType.PUBLISH);
    }

    private void openSession(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i, SessionAuthorizationType sessionAuthorizationType) {
        if (this.sessionTracker != null) {
            Session session = this.sessionTracker.getSession();
            if (session == null || session.getState().isClosed()) {
                session = new Builder(getActivity()).setApplicationId(str).build();
                Session.setActiveSession(session);
            }
            if (!session.isOpened()) {
                OpenRequest requestCode = new OpenRequest((Fragment) this).setPermissions((List) list).setLoginBehavior(sessionLoginBehavior).setRequestCode(i);
                if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                    session.openForPublish(requestCode);
                } else {
                    session.openForRead(requestCode);
                }
            }
        }
    }
}
