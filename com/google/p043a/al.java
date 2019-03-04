package com.google.p043a;

import com.google.p043a.p045b.p046a.C0687j;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;

/* compiled from: TypeAdapter */
public abstract class al<T> {
    public abstract void mo1121a(C0686d c0686d, T t);

    public abstract T mo1122b(C0683a c0683a);

    public final C0675w m3290a(T t) {
        try {
            C0686d c0687j = new C0687j();
            mo1121a(c0687j, t);
            return c0687j.mo1145a();
        } catch (Throwable e) {
            throw new C0754x(e);
        }
    }
}
