package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.util.UUID;

/* compiled from: TypeAdapters */
final class an extends al<UUID> {
    an() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3354a(c0683a);
    }

    public UUID m3354a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return UUID.fromString(c0683a.mo1132h());
        }
        c0683a.mo1134j();
        return null;
    }

    public void m3356a(C0686d c0686d, UUID uuid) {
        c0686d.mo1147b(uuid == null ? null : uuid.toString());
    }
}
