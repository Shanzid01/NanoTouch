package com.slideme.sam.manager.auth;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: AuthenticatorActivity */
class C1603e implements OnEditorActionListener {
    final /* synthetic */ AuthenticatorActivity f2665a;

    C1603e(AuthenticatorActivity authenticatorActivity) {
        this.f2665a = authenticatorActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.f2665a.f2657f.focusSearch(130).requestFocus();
        return true;
    }
}
