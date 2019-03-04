package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: TypeAdapters */
final class ar extends al<Locale> {
    ar() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3367a(c0683a);
    }

    public Locale m3367a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        String nextToken;
        String nextToken2;
        String nextToken3;
        StringTokenizer stringTokenizer = new StringTokenizer(c0683a.mo1132h(), "_");
        if (stringTokenizer.hasMoreElements()) {
            nextToken = stringTokenizer.nextToken();
        } else {
            nextToken = null;
        }
        if (stringTokenizer.hasMoreElements()) {
            nextToken2 = stringTokenizer.nextToken();
        } else {
            nextToken2 = null;
        }
        if (stringTokenizer.hasMoreElements()) {
            nextToken3 = stringTokenizer.nextToken();
        } else {
            nextToken3 = null;
        }
        if (nextToken2 == null && nextToken3 == null) {
            return new Locale(nextToken);
        }
        if (nextToken3 == null) {
            return new Locale(nextToken, nextToken2);
        }
        return new Locale(nextToken, nextToken2, nextToken3);
    }

    public void m3369a(C0686d c0686d, Locale locale) {
        c0686d.mo1147b(locale == null ? null : locale.toString());
    }
}
