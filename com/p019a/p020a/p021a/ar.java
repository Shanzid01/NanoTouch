package com.p019a.p020a.p021a;

import java.math.BigDecimal;
import java.util.Currency;

/* compiled from: StartCheckoutEvent */
public class ar extends C0342w<ar> {
    static final BigDecimal f1100a = BigDecimal.valueOf(1000000);

    public ar m2421a(int i) {
        this.d.m2447a("itemCount", Integer.valueOf(i));
        return this;
    }

    public ar m2422a(BigDecimal bigDecimal) {
        if (!this.b.m2452a((Object) bigDecimal, "totalPrice")) {
            this.d.m2447a("totalPrice", Long.valueOf(m2425b(bigDecimal)));
        }
        return this;
    }

    public ar m2423a(Currency currency) {
        if (!this.b.m2452a((Object) currency, "currency")) {
            this.d.m2449a("currency", currency.getCurrencyCode());
        }
        return this;
    }

    long m2425b(BigDecimal bigDecimal) {
        return f1100a.multiply(bigDecimal).longValue();
    }

    String mo533a() {
        return "startCheckout";
    }
}
