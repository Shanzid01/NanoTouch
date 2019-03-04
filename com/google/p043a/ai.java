package com.google.p043a;

import com.google.p043a.p045b.ag;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p048c.C0731a;

/* compiled from: TreeTypeAdapter */
final class ai<T> extends al<T> {
    private final ad<T> f1669a;
    private final C0673v<T> f1670b;
    private final C0743k f1671c;
    private final C0731a<T> f1672d;
    private final am f1673e;
    private al<T> f1674f;

    private ai(ad<T> adVar, C0673v<T> c0673v, C0743k c0743k, C0731a<T> c0731a, am amVar) {
        this.f1669a = adVar;
        this.f1670b = c0673v;
        this.f1671c = c0743k;
        this.f1672d = c0731a;
        this.f1673e = amVar;
    }

    public T mo1122b(C0683a c0683a) {
        if (this.f1670b == null) {
            return m3293a().mo1122b(c0683a);
        }
        C0675w a = ag.m3582a(c0683a);
        if (a.m3272j()) {
            return null;
        }
        return this.f1670b.deserialize(a, this.f1672d.m3661b(), this.f1671c.f1900a);
    }

    public void mo1121a(C0686d c0686d, T t) {
        if (this.f1669a == null) {
            m3293a().mo1121a(c0686d, t);
        } else if (t == null) {
            c0686d.mo1152f();
        } else {
            ag.m3584a(this.f1669a.mo1111a(t, this.f1672d.m3661b(), this.f1671c.f1901b), c0686d);
        }
    }

    private al<T> m3293a() {
        al<T> alVar = this.f1674f;
        if (alVar != null) {
            return alVar;
        }
        alVar = this.f1671c.m3670a(this.f1673e, this.f1672d);
        this.f1674f = alVar;
        return alVar;
    }

    public static am m3294a(C0731a<?> c0731a, Object obj) {
        return new ak(obj, c0731a, false, null);
    }

    public static am m3295b(C0731a<?> c0731a, Object obj) {
        return new ak(obj, c0731a, c0731a.m3661b() == c0731a.m3660a(), null);
    }
}
