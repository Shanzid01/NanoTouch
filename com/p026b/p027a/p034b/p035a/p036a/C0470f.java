package com.p026b.p027a.p034b.p035a.p036a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: LinkedBlockingDeque */
abstract class C0470f implements Iterator<E> {
    C0472h<E> f1418a;
    E f1419b;
    final /* synthetic */ C0467d f1420c;
    private C0472h<E> f1421d;

    abstract C0472h<E> mo928a();

    abstract C0472h<E> mo929a(C0472h<E> c0472h);

    C0470f(C0467d c0467d) {
        this.f1420c = c0467d;
        ReentrantLock reentrantLock = c0467d.f1413c;
        reentrantLock.lock();
        try {
            this.f1418a = mo928a();
            this.f1419b = this.f1418a == null ? null : this.f1418a.f1423a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private C0472h<E> m2957b(C0472h<E> c0472h) {
        while (true) {
            C0472h<E> a = mo929a(c0472h);
            if (a == null) {
                return null;
            }
            if (a.f1423a != null) {
                return a;
            }
            if (a == c0472h) {
                return mo928a();
            }
            c0472h = a;
        }
    }

    void m2960b() {
        ReentrantLock reentrantLock = this.f1420c.f1413c;
        reentrantLock.lock();
        try {
            this.f1418a = m2957b(this.f1418a);
            this.f1419b = this.f1418a == null ? null : this.f1418a.f1423a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean hasNext() {
        return this.f1418a != null;
    }

    public E next() {
        if (this.f1418a == null) {
            throw new NoSuchElementException();
        }
        this.f1421d = this.f1418a;
        E e = this.f1419b;
        m2960b();
        return e;
    }

    public void remove() {
        C0472h c0472h = this.f1421d;
        if (c0472h == null) {
            throw new IllegalStateException();
        }
        this.f1421d = null;
        ReentrantLock reentrantLock = this.f1420c.f1413c;
        reentrantLock.lock();
        try {
            if (c0472h.f1423a != null) {
                this.f1420c.m2946a(c0472h);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }
}
