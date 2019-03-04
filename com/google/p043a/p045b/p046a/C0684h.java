package com.google.p043a.p045b.p046a;

import com.google.p043a.C0753t;
import com.google.p043a.C0755y;
import com.google.p043a.C0756z;
import com.google.p043a.ab;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0734c;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: JsonTreeReader */
public final class C0684h extends C0683a {
    private static final Reader f1724a = new C0685i();
    private static final Object f1725b = new Object();
    private final List<Object> f1726c;

    public void mo1124a() {
        m3469a(C0734c.BEGIN_ARRAY);
        this.f1726c.add(((C0753t) m3470r()).iterator());
    }

    public void mo1125b() {
        m3469a(C0734c.END_ARRAY);
        m3471s();
        m3471s();
    }

    public void mo1126c() {
        m3469a(C0734c.BEGIN_OBJECT);
        this.f1726c.add(((C0756z) m3470r()).m3712o().iterator());
    }

    public void mo1128d() {
        m3469a(C0734c.END_OBJECT);
        m3471s();
        m3471s();
    }

    public boolean mo1129e() {
        C0734c f = mo1130f();
        return (f == C0734c.END_OBJECT || f == C0734c.END_ARRAY) ? false : true;
    }

    public C0734c mo1130f() {
        if (this.f1726c.isEmpty()) {
            return C0734c.END_DOCUMENT;
        }
        Object r = m3470r();
        if (r instanceof Iterator) {
            boolean z = this.f1726c.get(this.f1726c.size() - 2) instanceof C0756z;
            Iterator it = (Iterator) r;
            if (!it.hasNext()) {
                return z ? C0734c.END_OBJECT : C0734c.END_ARRAY;
            } else {
                if (z) {
                    return C0734c.NAME;
                }
                this.f1726c.add(it.next());
                return mo1130f();
            }
        } else if (r instanceof C0756z) {
            return C0734c.BEGIN_OBJECT;
        } else {
            if (r instanceof C0753t) {
                return C0734c.BEGIN_ARRAY;
            }
            if (r instanceof ab) {
                ab abVar = (ab) r;
                if (abVar.m3289q()) {
                    return C0734c.STRING;
                }
                if (abVar.m3287o()) {
                    return C0734c.BOOLEAN;
                }
                if (abVar.m3288p()) {
                    return C0734c.NUMBER;
                }
                throw new AssertionError();
            } else if (r instanceof C0755y) {
                return C0734c.NULL;
            } else {
                if (r == f1725b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object m3470r() {
        return this.f1726c.get(this.f1726c.size() - 1);
    }

    private Object m3471s() {
        return this.f1726c.remove(this.f1726c.size() - 1);
    }

    private void m3469a(C0734c c0734c) {
        if (mo1130f() != c0734c) {
            throw new IllegalStateException("Expected " + c0734c + " but was " + mo1130f());
        }
    }

    public String mo1131g() {
        m3469a(C0734c.NAME);
        Entry entry = (Entry) ((Iterator) m3470r()).next();
        this.f1726c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String mo1132h() {
        C0734c f = mo1130f();
        if (f == C0734c.STRING || f == C0734c.NUMBER) {
            return ((ab) m3471s()).mo1114b();
        }
        throw new IllegalStateException("Expected " + C0734c.STRING + " but was " + f);
    }

    public boolean mo1133i() {
        m3469a(C0734c.BOOLEAN);
        return ((ab) m3471s()).mo1118f();
    }

    public void mo1134j() {
        m3469a(C0734c.NULL);
        m3471s();
    }

    public double mo1135k() {
        C0734c f = mo1130f();
        if (f == C0734c.NUMBER || f == C0734c.STRING) {
            double c = ((ab) m3470r()).mo1115c();
            if (m3467p() || !(Double.isNaN(c) || Double.isInfinite(c))) {
                m3471s();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + C0734c.NUMBER + " but was " + f);
    }

    public long mo1136l() {
        C0734c f = mo1130f();
        if (f == C0734c.NUMBER || f == C0734c.STRING) {
            long d = ((ab) m3470r()).mo1116d();
            m3471s();
            return d;
        }
        throw new IllegalStateException("Expected " + C0734c.NUMBER + " but was " + f);
    }

    public int mo1137m() {
        C0734c f = mo1130f();
        if (f == C0734c.NUMBER || f == C0734c.STRING) {
            int e = ((ab) m3470r()).mo1117e();
            m3471s();
            return e;
        }
        throw new IllegalStateException("Expected " + C0734c.NUMBER + " but was " + f);
    }

    public void close() {
        this.f1726c.clear();
        this.f1726c.add(f1725b);
    }

    public void mo1138n() {
        if (mo1130f() == C0734c.NAME) {
            mo1131g();
        } else {
            m3471s();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void mo1139o() {
        m3469a(C0734c.NAME);
        Entry entry = (Entry) ((Iterator) m3470r()).next();
        this.f1726c.add(entry.getValue());
        this.f1726c.add(new ab((String) entry.getKey()));
    }
}
