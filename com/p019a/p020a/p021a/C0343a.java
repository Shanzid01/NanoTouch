package com.p019a.p020a.p021a;

import java.math.BigDecimal;
import java.util.Currency;

/* compiled from: AddToCartEvent */
public class C0343a extends C0342w<C0343a> {
    static final BigDecimal f1059a = BigDecimal.valueOf(1000000);

    public C0343a m2368a(String str) {
        this.d.m2449a("itemId", str);
        return this;
    }

    public C0343a m2373b(String str) {
        this.d.m2449a("itemName", str);
        return this;
    }

    public C0343a m2374c(String str) {
        this.d.m2449a("itemType", str);
        return this;
    }

    public C0343a m2369a(BigDecimal bigDecimal) {
        if (!this.b.m2452a((Object) bigDecimal, "itemPrice")) {
            this.d.m2447a("itemPrice", Long.valueOf(m2372b(bigDecimal)));
        }
        return this;
    }

    public C0343a m2370a(Currency currency) {
        if (!this.b.m2452a((Object) currency, "currency")) {
            this.d.m2449a("currency", currency.getCurrencyCode());
        }
        return this;
    }

    long m2372b(BigDecimal bigDecimal) {
        return f1059a.multiply(bigDecimal).longValue();
    }

    String mo533a() {
        return "addToCart";
    }
}
