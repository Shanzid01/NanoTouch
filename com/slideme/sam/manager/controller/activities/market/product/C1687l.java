package com.slideme.sam.manager.controller.activities.market.product;

import com.slideme.sam.manager.model.data.ApplicationHolder.OnTextReadyListener;

/* compiled from: TermsActivity */
class C1687l implements OnTextReadyListener {
    final /* synthetic */ TermsActivity f2864a;

    C1687l(TermsActivity termsActivity) {
        this.f2864a = termsActivity;
    }

    public void textReady(String str) {
        this.f2864a.runOnUiThread(new C1688m(this, str));
    }
}
