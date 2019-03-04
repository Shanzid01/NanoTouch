package com.slideme.sam.manager.controller.activities.market.product;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.SAM;

/* compiled from: TermsActivity */
class C1690o implements OnClickListener {
    final /* synthetic */ TermsActivity f2868a;

    C1690o(TermsActivity termsActivity) {
        this.f2868a = termsActivity;
    }

    public void onClick(View view) {
        boolean d = SAM.f2617j.m5521d();
        if (d && this.f2868a.f2837b.app.price == 0.0d) {
            d = !SAM.f2617j.m5523f();
        }
        if (d) {
            this.f2868a.m5008m();
        } else if (this.f2868a.f2844i != null) {
            this.f2868a.f2844i.onClick(view);
        }
    }
}
