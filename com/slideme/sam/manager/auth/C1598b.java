package com.slideme.sam.manager.auth;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

/* compiled from: AuthenticatorActivity */
class C1598b implements StatusCallback {
    final /* synthetic */ AuthenticatorActivity f2661a;

    C1598b(AuthenticatorActivity authenticatorActivity) {
        this.f2661a = authenticatorActivity;
    }

    public void call(Session session, SessionState sessionState, Exception exception) {
        this.f2661a.m4822a(session, sessionState, exception);
    }
}
