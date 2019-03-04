package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.p045b.C0725v;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: TypeAdapters */
final class ac extends al<Number> {
    ac() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3310a(c0683a);
    }

    public Number m3310a(C0683a c0683a) {
        C0734c f = c0683a.mo1130f();
        switch (ba.f1697a[f.ordinal()]) {
            case 1:
                return new C0725v(c0683a.mo1132h());
            case 4:
                c0683a.mo1134j();
                return null;
            default:
                throw new ae("Expecting number, got: " + f);
        }
    }

    public void m3311a(C0686d c0686d, Number number) {
        c0686d.mo1142a(number);
    }
}
