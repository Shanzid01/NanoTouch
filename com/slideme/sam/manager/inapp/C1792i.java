package com.slideme.sam.manager.inapp;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.p053a.C1617h;

/* compiled from: InAppPurchasingFragment */
class C1792i implements OnClickListener {
    final /* synthetic */ C1791h f3221a;

    C1792i(C1791h c1791h) {
        this.f3221a = c1791h;
    }

    public void onClick(View view) {
        if (!C1617h.m4866a(this.f3221a.getActivity(), 20)) {
            this.f3221a.m5363b();
        } else if (((C1617h) this.f3221a.getActivity().getSupportFragmentManager().findFragmentByTag("PasswordCheckDialog")) == null) {
            new C1617h().m4871a(this.f3221a).show(this.f3221a.getActivity().getSupportFragmentManager(), "PasswordCheckDialog");
        }
    }
}
