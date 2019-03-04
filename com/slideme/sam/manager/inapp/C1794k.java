package com.slideme.sam.manager.inapp;

import android.os.Bundle;
import com.slideme.sam.manager.net.response.InAppListResponse;
import com.slideme.sam.manager.net.response.InAppPurchasesListResponse;
import java.util.ArrayList;
import java.util.List;

/* compiled from: InAppService */
public class C1794k extends C1786c {
    final /* synthetic */ InAppService f3223a;

    public C1794k(InAppService inAppService) {
        this.f3223a = inAppService;
    }

    public Bundle mo4276a(int i, List<String> list, String str) {
        InAppListResponse a = this.f3223a.m5345a(i, (List) list, str);
        Bundle a2 = InAppService.m5342a(a.status);
        a2.putStringArrayList("com.slideme.sam.manager.inapp.BUNDLE_PRODUCTS", a.productsToJson());
        return a2;
    }

    public Bundle mo4275a(int i, String str, String str2, String str3) {
        Bundle a = InAppService.m5342a(1);
        a.putParcelable("com.slideme.sam.manager.inapp.BUNDLE_BUY_INTENT", this.f3223a.m5343a(i, str, str2, str3));
        return a;
    }

    public Bundle mo4274a(int i, String str, String str2) {
        InAppPurchasesListResponse a = this.f3223a.m5346a(i, str2);
        Bundle a2 = InAppService.m5342a(a.status);
        a2.putStringArrayList("com.slideme.sam.manager.inapp.BUNDLE_IAP_PRODUCT_IDS", new ArrayList(a.productIds));
        a2.putStringArrayList("com.slideme.sam.manager.inapp.BUNDLE_PURCHASE_DATA", new ArrayList(a.itemData));
        a2.putStringArrayList("com.slideme.sam.manager.inapp.BUNDLE_SIGNATURES", new ArrayList(a.signatures));
        return a2;
    }

    public Bundle mo4277b(int i, String str, String str2) {
        return InAppService.m5342a(this.f3223a.m5344a(i, str, str2).status);
    }
}
