package com.slideme.sam.manager.inapp;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.InAppListResponse;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: InAppPurchasingActivity */
class C1790g extends C1600v {
    final /* synthetic */ InAppPurchasingActivity f3216a;

    C1790g(InAppPurchasingActivity inAppPurchasingActivity) {
        this.f3216a = inAppPurchasingActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        InAppListResponse inAppListResponse = (InAppListResponse) baseNetworkResponse;
        this.f3216a.f3192e = inAppListResponse.getSingleIapDetails();
        if (this.f3216a.f3192e != null) {
            if (inAppListResponse.iapInhibited) {
                C1920k.m5782a(this.f3216a, "No charge will be applied", 0).show();
            }
            this.f3216a.m5332m();
            return;
        }
        this.f3216a.m5338h();
    }

    public void mo4233a(Throwable th, String str) {
        this.f3216a.m5338h();
    }
}
