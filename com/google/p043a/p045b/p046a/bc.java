package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: TypeAdapters */
final class bc extends al<Number> {
    bc() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3390a(c0683a);
    }

    public Number m3390a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        try {
            return Byte.valueOf((byte) c0683a.mo1137m());
        } catch (Throwable e) {
            throw new ae(e);
        }
    }

    public void m3391a(C0686d c0686d, Number number) {
        c0686d.mo1142a(number);
    }
}
