package com.google.p043a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class C0753t extends C0675w implements Iterable<C0675w> {
    private final List<C0675w> f1931a = new ArrayList();

    public void m3705a(C0675w c0675w) {
        if (c0675w == null) {
            c0675w = C0755y.f1932a;
        }
        this.f1931a.add(c0675w);
    }

    public Iterator<C0675w> iterator() {
        return this.f1931a.iterator();
    }

    public Number mo1113a() {
        if (this.f1931a.size() == 1) {
            return ((C0675w) this.f1931a.get(0)).mo1113a();
        }
        throw new IllegalStateException();
    }

    public String mo1114b() {
        if (this.f1931a.size() == 1) {
            return ((C0675w) this.f1931a.get(0)).mo1114b();
        }
        throw new IllegalStateException();
    }

    public double mo1115c() {
        if (this.f1931a.size() == 1) {
            return ((C0675w) this.f1931a.get(0)).mo1115c();
        }
        throw new IllegalStateException();
    }

    public long mo1116d() {
        if (this.f1931a.size() == 1) {
            return ((C0675w) this.f1931a.get(0)).mo1116d();
        }
        throw new IllegalStateException();
    }

    public int mo1117e() {
        if (this.f1931a.size() == 1) {
            return ((C0675w) this.f1931a.get(0)).mo1117e();
        }
        throw new IllegalStateException();
    }

    public boolean mo1118f() {
        if (this.f1931a.size() == 1) {
            return ((C0675w) this.f1931a.get(0)).mo1118f();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0753t) && ((C0753t) obj).f1931a.equals(this.f1931a));
    }

    public int hashCode() {
        return this.f1931a.hashCode();
    }
}
