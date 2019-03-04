package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.net.InetAddress;

/* compiled from: TypeAdapters */
final class am extends al<InetAddress> {
    am() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3350a(c0683a);
    }

    public InetAddress m3350a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return InetAddress.getByName(c0683a.mo1132h());
        }
        c0683a.mo1134j();
        return null;
    }

    public void m3352a(C0686d c0686d, InetAddress inetAddress) {
        c0686d.mo1147b(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
