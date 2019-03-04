package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.response.PurchaseResponse;
import com.slideme.sam.manager.net.wrappers.C1711e;
import com.slideme.sam.manager.util.C1922m;
import java.util.HashMap;

/* compiled from: StorageLockerApplicationListFragment */
class ai implements C1711e {
    final /* synthetic */ ah f2940a;
    private final /* synthetic */ PurchaseResponse f2941b;

    ai(ah ahVar, PurchaseResponse purchaseResponse) {
        this.f2940a = ahVar;
        this.f2941b = purchaseResponse;
    }

    public boolean mo4259a(Application application) {
        HashMap transactionMap = this.f2941b.getTransactionMap();
        if (!transactionMap.containsKey(application.bundleId)) {
            return false;
        }
        application.token = (String) transactionMap.get(application.bundleId);
        C1922m.m5797b(ag.f2937a, "Token for " + application.getName() + " : " + application.token);
        return true;
    }
}
