package com.google.p043a.p045b;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber */
public final class C0725v extends Number {
    private final String f1884a;

    public C0725v(String str) {
        this.f1884a = str;
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f1884a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f1884a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f1884a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f1884a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f1884a).longValue();
        }
    }

    public float floatValue() {
        return Float.parseFloat(this.f1884a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f1884a);
    }

    public String toString() {
        return this.f1884a;
    }

    private Object writeReplace() {
        return new BigDecimal(this.f1884a);
    }
}
