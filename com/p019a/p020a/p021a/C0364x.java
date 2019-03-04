package com.p019a.p020a.p021a;

import com.facebook.Response;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.math.BigDecimal;
import java.util.Currency;

/* compiled from: PurchaseEvent */
public class C0364x extends C0342w<C0364x> {
    static final BigDecimal f1143a = BigDecimal.valueOf(1000000);

    public C0364x m2495a(String str) {
        this.d.m2449a("itemId", str);
        return this;
    }

    public C0364x m2501b(String str) {
        this.d.m2449a("itemName", str);
        return this;
    }

    public C0364x m2502c(String str) {
        this.d.m2449a("itemType", str);
        return this;
    }

    public C0364x m2496a(BigDecimal bigDecimal) {
        if (!this.b.m2452a((Object) bigDecimal, "itemPrice")) {
            this.d.m2447a("itemPrice", Long.valueOf(m2500b(bigDecimal)));
        }
        return this;
    }

    public C0364x m2497a(Currency currency) {
        if (!this.b.m2452a((Object) currency, "currency")) {
            this.d.m2449a("currency", currency.getCurrencyCode());
        }
        return this;
    }

    public C0364x m2498a(boolean z) {
        this.d.m2449a(Response.SUCCESS_KEY, Boolean.toString(z));
        return this;
    }

    long m2500b(BigDecimal bigDecimal) {
        return f1143a.multiply(bigDecimal).longValue();
    }

    String mo533a() {
        return ProductAction.ACTION_PURCHASE;
    }
}
