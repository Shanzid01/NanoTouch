package com.slideme.sam.manager.inapp;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.InAppPurchaseResponse;

/* compiled from: InAppPurchasingFragment */
class C1793j extends C1600v {
    final /* synthetic */ C1791h f3222a;

    C1793j(C1791h c1791h) {
        this.f3222a = c1791h;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        this.f3222a.m5362a((InAppPurchaseResponse) baseNetworkResponse);
    }

    public void mo4233a(Throwable th, String str) {
        this.f3222a.m5365a().m5338h();
    }
}
