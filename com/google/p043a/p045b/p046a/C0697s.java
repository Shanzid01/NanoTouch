package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p045b.ae;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class C0697s<T> extends al<T> {
    private final ae<T> f1764a;
    private final Map<String, C0695t> f1765b;

    private C0697s(ae<T> aeVar, Map<String, C0695t> map) {
        this.f1764a = aeVar;
        this.f1765b = map;
    }

    public T mo1122b(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        T a = this.f1764a.mo1158a();
        try {
            c0683a.mo1126c();
            while (c0683a.mo1129e()) {
                C0695t c0695t = (C0695t) this.f1765b.get(c0683a.mo1131g());
                if (c0695t == null || !c0695t.f1757i) {
                    c0683a.mo1138n();
                } else {
                    c0695t.mo1154a(c0683a, (Object) a);
                }
            }
            c0683a.mo1128d();
            return a;
        } catch (Throwable e) {
            throw new com.google.p043a.ae(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public void mo1121a(C0686d c0686d, T t) {
        if (t == null) {
            c0686d.mo1152f();
            return;
        }
        c0686d.mo1150d();
        try {
            for (C0695t c0695t : this.f1765b.values()) {
                if (c0695t.mo1156a(t)) {
                    c0686d.mo1143a(c0695t.f1755g);
                    c0695t.mo1155a(c0686d, (Object) t);
                }
            }
            c0686d.mo1151e();
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        }
    }
}
