package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: TypeAdapters */
final class ae extends al<String> {
    ae() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3318a(c0683a);
    }

    public String m3318a(C0683a c0683a) {
        C0734c f = c0683a.mo1130f();
        if (f == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        } else if (f == C0734c.BOOLEAN) {
            return Boolean.toString(c0683a.mo1133i());
        } else {
            return c0683a.mo1132h();
        }
    }

    public void m3320a(C0686d c0686d, String str) {
        c0686d.mo1147b(str);
    }
}
