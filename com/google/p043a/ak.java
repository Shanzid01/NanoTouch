package com.google.p043a;

import com.google.p043a.p045b.C0704a;
import com.google.p043a.p048c.C0731a;

/* compiled from: TreeTypeAdapter */
class ak implements am {
    private final C0731a<?> f1675a;
    private final boolean f1676b;
    private final Class<?> f1677c;
    private final ad<?> f1678d;
    private final C0673v<?> f1679e;

    private ak(Object obj, C0731a<?> c0731a, boolean z, Class<?> cls) {
        this.f1678d = obj instanceof ad ? (ad) obj : null;
        if (obj instanceof C0673v) {
            obj = (C0673v) obj;
        } else {
            obj = null;
        }
        this.f1679e = obj;
        boolean z2 = (this.f1678d == null && this.f1679e == null) ? false : true;
        C0704a.m3574a(z2);
        this.f1675a = c0731a;
        this.f1676b = z;
        this.f1677c = cls;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        boolean isAssignableFrom = this.f1675a != null ? this.f1675a.equals(c0731a) || (this.f1676b && this.f1675a.m3661b() == c0731a.m3660a()) : this.f1677c.isAssignableFrom(c0731a.m3660a());
        if (isAssignableFrom) {
            return new ai(this.f1678d, this.f1679e, c0743k, c0731a, this);
        }
        return null;
    }
}
