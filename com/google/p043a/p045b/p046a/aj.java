package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.net.URL;

/* compiled from: TypeAdapters */
final class aj extends al<URL> {
    aj() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3338a(c0683a);
    }

    public URL m3338a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        String h = c0683a.mo1132h();
        if ("null".equals(h)) {
            return null;
        }
        return new URL(h);
    }

    public void m3340a(C0686d c0686d, URL url) {
        c0686d.mo1147b(url == null ? null : url.toExternalForm());
    }
}
