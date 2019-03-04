package com.google.p043a;

import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: Gson */
class C0748o extends al<Number> {
    final /* synthetic */ C0743k f1913a;

    C0748o(C0743k c0743k) {
        this.f1913a = c0743k;
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3688a(c0683a);
    }

    public Float m3688a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return Float.valueOf((float) c0683a.mo1135k());
        }
        c0683a.mo1134j();
        return null;
    }

    public void m3689a(C0686d c0686d, Number number) {
        if (number == null) {
            c0686d.mo1152f();
            return;
        }
        this.f1913a.m3666a((double) number.floatValue());
        c0686d.mo1142a(number);
    }
}
