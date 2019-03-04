package com.slideme.sam.manager;

import android.app.NotificationManager;
import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.PurchaseResponse;

/* compiled from: SAM */
class C1866n extends C1600v {
    final /* synthetic */ SAM f3329a;

    C1866n(SAM sam) {
        this.f3329a = sam;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        PurchaseResponse purchaseResponse = (PurchaseResponse) baseNetworkResponse;
        if (purchaseResponse.getUnclaimedApplications().size() > 0) {
            ((NotificationManager) this.f3329a.getSystemService("notification")).notify(2, C1704f.m5071a(this.f3329a, purchaseResponse.getUnclaimedApplications().size()));
        }
    }
}
