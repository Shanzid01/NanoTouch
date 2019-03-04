package com.slideme.sam.manager.auth;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.R;

/* compiled from: AuthenticatorActivity */
class C1606h implements OnClickListener {
    final /* synthetic */ AuthenticatorActivity f2668a;

    C1606h(AuthenticatorActivity authenticatorActivity) {
        this.f2668a = authenticatorActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f2668a.getString(R.string.SLIDEME_FORGOT_PASS)));
        this.f2668a.startActivity(intent);
    }
}
