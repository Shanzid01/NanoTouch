package com.slideme.sam.manager.controller.activities.market.product;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.view.touchme.ExpandableTextContainer;

/* compiled from: TermsActivity */
class C1688m implements Runnable {
    final /* synthetic */ C1687l f2865a;
    private final /* synthetic */ String f2866b;

    C1688m(C1687l c1687l, String str) {
        this.f2865a = c1687l;
        this.f2866b = str;
    }

    public void run() {
        if (this.f2866b == null || this.f2866b.equals("")) {
            ((ExpandableTextContainer) this.f2865a.f2864a.findViewById(R.id.privacyPolicyText)).setText(R.string.privacy_policy_unspecified);
        } else {
            ((ExpandableTextContainer) this.f2865a.f2864a.findViewById(R.id.privacyPolicyText)).m5936a(this.f2866b);
        }
    }
}
