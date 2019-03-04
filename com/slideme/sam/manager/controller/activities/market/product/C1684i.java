package com.slideme.sam.manager.controller.activities.market.product;

import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.ar;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.p054b.C1683i;
import com.slideme.sam.manager.net.response.PurchaseResponse;
import com.slideme.sam.manager.util.C1922m;
import java.math.BigDecimal;
import java.util.Currency;

/* compiled from: TermsActivity */
class C1684i extends C1683i {
    final /* synthetic */ TermsActivity f2860a;

    C1684i(TermsActivity termsActivity) {
        this.f2860a = termsActivity;
    }

    protected void mo4250a() {
        this.f2860a.m4997d(true);
        this.f2860a.m4995c(true);
        C0345b.m2427c().m2435a(new ar().m2422a(BigDecimal.valueOf(this.f2860a.f2837b.app.price)).m2423a(Currency.getInstance("USD")).m2421a(1));
    }

    protected void mo4251a(PurchaseResponse purchaseResponse) {
        if (purchaseResponse != null) {
            if (purchaseResponse.error > 0) {
                this.f2860a.m5006k();
            } else if (!C1922m.m5795a(purchaseResponse.applications)) {
                SAM.m4763a(this.f2860a);
                this.f2860a.f2837b.app.token = purchaseResponse.applications[0].token;
                this.f2860a.m5005j();
            }
        }
        this.f2860a.m4997d(false);
        this.f2860a.m4995c(false);
    }
}
