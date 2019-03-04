package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.PurchaseResponse;
import com.slideme.sam.manager.net.wrappers.Catalog;
import java.util.List;

/* compiled from: StorageLockerApplicationListFragment */
class ah extends C1600v {
    final /* synthetic */ ag f2938a;
    private final /* synthetic */ Catalog f2939b;

    ah(ag agVar, Catalog catalog) {
        this.f2938a = agVar;
        this.f2939b = catalog;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        int i = 0;
        PurchaseResponse purchaseResponse = (PurchaseResponse) baseNetworkResponse;
        List purchasedApplications = purchaseResponse.getPurchasedApplications();
        List unclaimedApplications = purchaseResponse.getUnclaimedApplications();
        String[] strArr = new String[(purchasedApplications.size() + unclaimedApplications.size())];
        for (int i2 = 0; i2 < unclaimedApplications.size(); i2++) {
            strArr[i2] = (String) unclaimedApplications.get(i2);
        }
        while (i < purchasedApplications.size()) {
            strArr[i + unclaimedApplications.size()] = (String) purchasedApplications.get(i);
            i++;
        }
        this.f2939b.m5673c();
        this.f2939b.m5667a(strArr);
        this.f2939b.m5661a(new ai(this, purchaseResponse));
        this.f2939b.m5685f();
    }
}
