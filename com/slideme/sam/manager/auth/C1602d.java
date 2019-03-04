package com.slideme.sam.manager.auth;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: AuthenticatorActivity */
class C1602d implements OnEditorActionListener {
    final /* synthetic */ AuthenticatorActivity f2664a;

    C1602d(AuthenticatorActivity authenticatorActivity) {
        this.f2664a = authenticatorActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        this.f2664a.m4819a(this.f2664a.f2657f.getText().toString(), this.f2664a.f2658g.getText().toString());
        return true;
    }
}
