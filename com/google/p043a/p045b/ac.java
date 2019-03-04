package com.google.p043a.p045b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: LinkedTreeMap */
abstract class ac<T> implements Iterator<T> {
    ad<K, V> f1818b;
    ad<K, V> f1819c;
    int f1820d;
    final /* synthetic */ C0726w f1821e;

    private ac(C0726w c0726w) {
        this.f1821e = c0726w;
        this.f1818b = this.f1821e.f1891e.f1826d;
        this.f1819c = null;
        this.f1820d = this.f1821e.f1890d;
    }

    public final boolean hasNext() {
        return this.f1818b != this.f1821e.f1891e;
    }

    final ad<K, V> m3575b() {
        ad<K, V> adVar = this.f1818b;
        if (adVar == this.f1821e.f1891e) {
            throw new NoSuchElementException();
        } else if (this.f1821e.f1890d != this.f1820d) {
            throw new ConcurrentModificationException();
        } else {
            this.f1818b = adVar.f1826d;
            this.f1819c = adVar;
            return adVar;
        }
    }

    public final void remove() {
        if (this.f1819c == null) {
            throw new IllegalStateException();
        }
        this.f1821e.m3651a(this.f1819c, true);
        this.f1819c = null;
        this.f1820d = this.f1821e.f1890d;
    }
}
