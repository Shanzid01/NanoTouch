package com.google.p043a;

import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;

/* compiled from: Gson */
class C0750q<T> extends al<T> {
    private al<T> f1915a;

    C0750q() {
    }

    public void m3696a(al<T> alVar) {
        if (this.f1915a != null) {
            throw new AssertionError();
        }
        this.f1915a = alVar;
    }

    public T mo1122b(C0683a c0683a) {
        if (this.f1915a != null) {
            return this.f1915a.mo1122b(c0683a);
        }
        throw new IllegalStateException();
    }

    public void mo1121a(C0686d c0686d, T t) {
        if (this.f1915a == null) {
            throw new IllegalStateException();
        }
        this.f1915a.mo1121a(c0686d, t);
    }
}
