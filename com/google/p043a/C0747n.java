package com.google.p043a;

import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: Gson */
class C0747n extends al<Number> {
    final /* synthetic */ C0743k f1912a;

    C0747n(C0743k c0743k) {
        this.f1912a = c0743k;
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3684a(c0683a);
    }

    public Double m3684a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return Double.valueOf(c0683a.mo1135k());
        }
        c0683a.mo1134j();
        return null;
    }

    public void m3685a(C0686d c0686d, Number number) {
        if (number == null) {
            c0686d.mo1152f();
            return;
        }
        this.f1912a.m3666a(number.doubleValue());
        c0686d.mo1142a(number);
    }
}
