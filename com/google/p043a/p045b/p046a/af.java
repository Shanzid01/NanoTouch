package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.math.BigDecimal;

/* compiled from: TypeAdapters */
final class af extends al<BigDecimal> {
    af() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3322a(c0683a);
    }

    public BigDecimal m3322a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        try {
            return new BigDecimal(c0683a.mo1132h());
        } catch (Throwable e) {
            throw new ae(e);
        }
    }

    public void m3324a(C0686d c0686d, BigDecimal bigDecimal) {
        c0686d.mo1142a((Number) bigDecimal);
    }
}
