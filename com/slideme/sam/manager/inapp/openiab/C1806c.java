package com.slideme.sam.manager.inapp.openiab;

import com.slideme.sam.manager.inapp.openiab.p058a.C1799a;
import com.slideme.sam.manager.model.data.inapp.InAppProduct;

/* compiled from: OpenIabUtils */
public class C1806c {
    public static C1799a m5412a(InAppProduct inAppProduct) {
        return new C1799a(inAppProduct.type, inAppProduct.productId, inAppProduct.title, String.valueOf(inAppProduct.price), inAppProduct.description);
    }

    public static int m5411a(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 4) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 6;
        }
        if (i == 5) {
            return 7;
        }
        return 0;
    }
}
