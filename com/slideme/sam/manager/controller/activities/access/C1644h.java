package com.slideme.sam.manager.controller.activities.access;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.p053a.C1627r;

/* compiled from: RegisterActivity */
class C1644h implements OnClickListener {
    final /* synthetic */ RegisterActivity f2769a;

    C1644h(RegisterActivity registerActivity) {
        this.f2769a = registerActivity;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("com.slideme.sam.manager.extra.TEXT", this.f2769a.getString(R.string.privacy_policy_text));
        C1627r c1627r = new C1627r();
        c1627r.setArguments(bundle);
        c1627r.show(this.f2769a.getSupportFragmentManager(), "privacy_policy_dialog");
    }
}
