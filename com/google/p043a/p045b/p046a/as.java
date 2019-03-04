package com.google.p043a.p045b.p046a;

import com.google.p043a.C0675w;
import com.google.p043a.C0753t;
import com.google.p043a.C0755y;
import com.google.p043a.C0756z;
import com.google.p043a.ab;
import com.google.p043a.al;
import com.google.p043a.p045b.C0725v;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: TypeAdapters */
final class as extends al<C0675w> {
    as() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3371a(c0683a);
    }

    public C0675w m3371a(C0683a c0683a) {
        C0675w c0753t;
        switch (ba.f1697a[c0683a.mo1130f().ordinal()]) {
            case 1:
                return new ab(new C0725v(c0683a.mo1132h()));
            case 2:
                return new ab(Boolean.valueOf(c0683a.mo1133i()));
            case 3:
                return new ab(c0683a.mo1132h());
            case 4:
                c0683a.mo1134j();
                return C0755y.f1932a;
            case 5:
                c0753t = new C0753t();
                c0683a.mo1124a();
                while (c0683a.mo1129e()) {
                    c0753t.m3705a(m3371a(c0683a));
                }
                c0683a.mo1125b();
                return c0753t;
            case 6:
                c0753t = new C0756z();
                c0683a.mo1126c();
                while (c0683a.mo1129e()) {
                    c0753t.m3711a(c0683a.mo1131g(), m3371a(c0683a));
                }
                c0683a.mo1128d();
                return c0753t;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void m3372a(C0686d c0686d, C0675w c0675w) {
        if (c0675w == null || c0675w.m3272j()) {
            c0686d.mo1152f();
        } else if (c0675w.m3271i()) {
            ab m = c0675w.m3275m();
            if (m.m3288p()) {
                c0686d.mo1142a(m.mo1113a());
            } else if (m.m3287o()) {
                c0686d.mo1144a(m.mo1118f());
            } else {
                c0686d.mo1147b(m.mo1114b());
            }
        } else if (c0675w.m3269g()) {
            c0686d.mo1146b();
            Iterator it = c0675w.m3274l().iterator();
            while (it.hasNext()) {
                m3372a(c0686d, (C0675w) it.next());
            }
            c0686d.mo1148c();
        } else if (c0675w.m3270h()) {
            c0686d.mo1150d();
            for (Entry entry : c0675w.m3273k().m3712o()) {
                c0686d.mo1143a((String) entry.getKey());
                m3372a(c0686d, (C0675w) entry.getValue());
            }
            c0686d.mo1151e();
        } else {
            throw new IllegalArgumentException("Couldn't write " + c0675w.getClass());
        }
    }
}
