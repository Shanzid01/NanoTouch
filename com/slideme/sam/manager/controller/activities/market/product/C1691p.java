package com.slideme.sam.manager.controller.activities.market.product;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.PurchaseResponse;
import java.util.List;

/* compiled from: TermsActivity */
class C1691p extends C1600v {
    final /* synthetic */ TermsActivity f2869a;

    C1691p(TermsActivity termsActivity) {
        this.f2869a = termsActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        PurchaseResponse purchaseResponse = (PurchaseResponse) baseNetworkResponse;
        List purchasedApplications = purchaseResponse.getPurchasedApplications();
        List unclaimedApplications = purchaseResponse.getUnclaimedApplications();
        if (purchasedApplications.contains(this.f2869a.f2837b.app.bundleId) || unclaimedApplications.contains(this.f2869a.f2837b.app.bundleId)) {
            this.f2869a.f2837b.app.token = (String) purchaseResponse.getTransactionMap().get(this.f2869a.f2837b.app.bundleId);
        }
        this.f2869a.runOnUiThread(new C1692q(this));
    }

    public void mo4231a() {
        this.f2869a.m4997d(false);
    }
}
