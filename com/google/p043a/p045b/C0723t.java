package com.google.p043a.p045b;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p048c.C0731a;

/* compiled from: Excluder */
class C0723t extends al<T> {
    final /* synthetic */ boolean f1877a;
    final /* synthetic */ boolean f1878b;
    final /* synthetic */ C0743k f1879c;
    final /* synthetic */ C0731a f1880d;
    final /* synthetic */ C0722s f1881e;
    private al<T> f1882f;

    C0723t(C0722s c0722s, boolean z, boolean z2, C0743k c0743k, C0731a c0731a) {
        this.f1881e = c0722s;
        this.f1877a = z;
        this.f1878b = z2;
        this.f1879c = c0743k;
        this.f1880d = c0731a;
    }

    public T mo1122b(C0683a c0683a) {
        if (!this.f1877a) {
            return m3639a().mo1122b(c0683a);
        }
        c0683a.mo1138n();
        return null;
    }

    public void mo1121a(C0686d c0686d, T t) {
        if (this.f1878b) {
            c0686d.mo1152f();
        } else {
            m3639a().mo1121a(c0686d, t);
        }
    }

    private al<T> m3639a() {
        al<T> alVar = this.f1882f;
        if (alVar != null) {
            return alVar;
        }
        alVar = this.f1879c.m3670a(this.f1881e, this.f1880d);
        this.f1882f = alVar;
        return alVar;
    }
}
