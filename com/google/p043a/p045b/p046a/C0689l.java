package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p045b.C0705b;
import com.google.p043a.p045b.C0709f;
import com.google.p043a.p045b.ae;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory */
public final class C0689l implements am {
    private final C0709f f1743a;
    private final boolean f1744b;

    public C0689l(C0709f c0709f, boolean z) {
        this.f1743a = c0709f;
        this.f1744b = z;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Type b = c0731a.m3661b();
        if (!Map.class.isAssignableFrom(c0731a.m3660a())) {
            return null;
        }
        Type[] b2 = C0705b.m3605b(b, C0705b.m3608e(b));
        al a = m3527a(c0743k, b2[0]);
        al a2 = c0743k.m3671a(C0731a.m3657a(b2[1]));
        ae a3 = this.f1743a.m3616a((C0731a) c0731a);
        return new C0690m(this, c0743k, b2[0], a, b2[1], a2, a3);
    }

    private al<?> m3527a(C0743k c0743k, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C0703z.f1796f : c0743k.m3671a(C0731a.m3657a(type));
    }
}
