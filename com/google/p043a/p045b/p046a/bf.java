package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: TypeAdapters */
final class bf extends al<Number> {
    bf() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3402a(c0683a);
    }

    public Number m3402a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        try {
            return Long.valueOf(c0683a.mo1136l());
        } catch (Throwable e) {
            throw new ae(e);
        }
    }

    public void m3403a(C0686d c0686d, Number number) {
        c0686d.mo1142a(number);
    }
}
