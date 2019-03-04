package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: TypeAdapters */
final class ax extends al<Boolean> {
    ax() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3379a(c0683a);
    }

    public Boolean m3379a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        } else if (c0683a.mo1130f() == C0734c.STRING) {
            return Boolean.valueOf(Boolean.parseBoolean(c0683a.mo1132h()));
        } else {
            return Boolean.valueOf(c0683a.mo1133i());
        }
    }

    public void m3380a(C0686d c0686d, Boolean bool) {
        if (bool == null) {
            c0686d.mo1152f();
        } else {
            c0686d.mo1144a(bool.booleanValue());
        }
    }
}
