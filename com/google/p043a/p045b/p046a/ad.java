package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;

/* compiled from: TypeAdapters */
final class ad extends al<Character> {
    ad() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3314a(c0683a);
    }

    public Character m3314a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        String h = c0683a.mo1132h();
        if (h.length() == 1) {
            return Character.valueOf(h.charAt(0));
        }
        throw new ae("Expecting character, got: " + h);
    }

    public void m3315a(C0686d c0686d, Character ch) {
        c0686d.mo1147b(ch == null ? null : String.valueOf(ch));
    }
}
