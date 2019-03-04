package com.slideme.sam.manager.controller.activities.market.product;

import com.slideme.sam.manager.model.data.ApplicationHolder.OnTextReadyListener;

/* compiled from: TermsActivity */
class C1685j implements OnTextReadyListener {
    final /* synthetic */ TermsActivity f2861a;

    C1685j(TermsActivity termsActivity) {
        this.f2861a = termsActivity;
    }

    public void textReady(String str) {
        this.f2861a.runOnUiThread(new C1686k(this, str));
    }
}
