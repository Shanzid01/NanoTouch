package com.google.p043a.p045b.p046a;

import com.google.p043a.C0754x;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.net.URI;

/* compiled from: TypeAdapters */
final class ak extends al<URI> {
    ak() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3342a(c0683a);
    }

    public URI m3342a(C0683a c0683a) {
        URI uri = null;
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
        } else {
            try {
                String h = c0683a.mo1132h();
                if (!"null".equals(h)) {
                    uri = new URI(h);
                }
            } catch (Throwable e) {
                throw new C0754x(e);
            }
        }
        return uri;
    }

    public void m3344a(C0686d c0686d, URI uri) {
        c0686d.mo1147b(uri == null ? null : uri.toASCIIString());
    }
}
