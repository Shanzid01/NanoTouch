package com.slideme.sam.manager.auth;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.activities.access.RegisterActivity;

/* compiled from: AuthenticatorActivity */
class C1605g implements OnClickListener {
    final /* synthetic */ AuthenticatorActivity f2667a;

    C1605g(AuthenticatorActivity authenticatorActivity) {
        this.f2667a = authenticatorActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f2667a, RegisterActivity.class);
        intent.putExtra("is_adding_new_account", true);
        this.f2667a.startActivityForResult(intent, 1);
    }
}
