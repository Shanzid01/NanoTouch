package com.google.p043a;

import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: Gson */
class C0749p extends al<Number> {
    final /* synthetic */ C0743k f1914a;

    C0749p(C0743k c0743k) {
        this.f1914a = c0743k;
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3692a(c0683a);
    }

    public Number m3692a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return Long.valueOf(c0683a.mo1136l());
        }
        c0683a.mo1134j();
        return null;
    }

    public void m3693a(C0686d c0686d, Number number) {
        if (number == null) {
            c0686d.mo1152f();
        } else {
            c0686d.mo1147b(number.toString());
        }
    }
}
