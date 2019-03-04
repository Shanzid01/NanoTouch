package com.google.p043a.p045b.p046a;

import com.google.p043a.C0675w;
import com.google.p043a.C0753t;
import com.google.p043a.C0755y;
import com.google.p043a.C0756z;
import com.google.p043a.ab;
import com.google.p043a.p047d.C0686d;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
public final class C0687j extends C0686d {
    private static final Writer f1738a = new C0688k();
    private static final ab f1739b = new ab("closed");
    private final List<C0675w> f1740c = new ArrayList();
    private String f1741d;
    private C0675w f1742e = C0755y.f1932a;

    public C0687j() {
        super(f1738a);
    }

    public C0675w mo1145a() {
        if (this.f1740c.isEmpty()) {
            return this.f1742e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f1740c);
    }

    private C0675w m3515j() {
        return (C0675w) this.f1740c.get(this.f1740c.size() - 1);
    }

    private void m3514a(C0675w c0675w) {
        if (this.f1741d != null) {
            if (!c0675w.m3272j() || m3513i()) {
                ((C0756z) m3515j()).m3711a(this.f1741d, c0675w);
            }
            this.f1741d = null;
        } else if (this.f1740c.isEmpty()) {
            this.f1742e = c0675w;
        } else {
            C0675w j = m3515j();
            if (j instanceof C0753t) {
                ((C0753t) j).m3705a(c0675w);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public C0686d mo1146b() {
        C0675w c0753t = new C0753t();
        m3514a(c0753t);
        this.f1740c.add(c0753t);
        return this;
    }

    public C0686d mo1148c() {
        if (this.f1740c.isEmpty() || this.f1741d != null) {
            throw new IllegalStateException();
        } else if (m3515j() instanceof C0753t) {
            this.f1740c.remove(this.f1740c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0686d mo1150d() {
        C0675w c0756z = new C0756z();
        m3514a(c0756z);
        this.f1740c.add(c0756z);
        return this;
    }

    public C0686d mo1151e() {
        if (this.f1740c.isEmpty() || this.f1741d != null) {
            throw new IllegalStateException();
        } else if (m3515j() instanceof C0756z) {
            this.f1740c.remove(this.f1740c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0686d mo1143a(String str) {
        if (this.f1740c.isEmpty() || this.f1741d != null) {
            throw new IllegalStateException();
        } else if (m3515j() instanceof C0756z) {
            this.f1741d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C0686d mo1147b(String str) {
        if (str == null) {
            return mo1152f();
        }
        m3514a(new ab(str));
        return this;
    }

    public C0686d mo1152f() {
        m3514a(C0755y.f1932a);
        return this;
    }

    public C0686d mo1144a(boolean z) {
        m3514a(new ab(Boolean.valueOf(z)));
        return this;
    }

    public C0686d mo1141a(long j) {
        m3514a(new ab(Long.valueOf(j)));
        return this;
    }

    public C0686d mo1142a(Number number) {
        if (number == null) {
            return mo1152f();
        }
        if (!m3511g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m3514a(new ab(number));
        return this;
    }

    public void flush() {
    }

    public void close() {
        if (this.f1740c.isEmpty()) {
            this.f1740c.add(f1739b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
