package com.slideme.sam.manager.controller.activities.market.product;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.view.touchme.ExpandableTextContainer;

/* compiled from: TermsActivity */
class C1686k implements Runnable {
    final /* synthetic */ C1685j f2862a;
    private final /* synthetic */ String f2863b;

    C1686k(C1685j c1685j, String str) {
        this.f2862a = c1685j;
        this.f2863b = str;
    }

    public void run() {
        if (this.f2863b == null || this.f2863b.equals("")) {
            ((ExpandableTextContainer) this.f2862a.f2861a.findViewById(R.id.dev_terms)).setText(R.string.terms_unspecified);
        } else {
            ((ExpandableTextContainer) this.f2862a.f2861a.findViewById(R.id.dev_terms)).m5936a(this.f2863b);
        }
    }
}
