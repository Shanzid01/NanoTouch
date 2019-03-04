package com.google.p043a;

import com.google.p043a.p045b.ag;
import com.google.p043a.p047d.C0686d;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: JsonElement */
public abstract class C0675w {
    public boolean m3269g() {
        return this instanceof C0753t;
    }

    public boolean m3270h() {
        return this instanceof C0756z;
    }

    public boolean m3271i() {
        return this instanceof ab;
    }

    public boolean m3272j() {
        return this instanceof C0755y;
    }

    public C0756z m3273k() {
        if (m3270h()) {
            return (C0756z) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C0753t m3274l() {
        if (m3269g()) {
            return (C0753t) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public ab m3275m() {
        if (m3271i()) {
            return (ab) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean mo1118f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean mo1119n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number mo1113a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String mo1114b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double mo1115c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long mo1116d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int mo1117e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            C0686d c0686d = new C0686d(stringWriter);
            c0686d.m3503b(true);
            ag.m3584a(this, c0686d);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
