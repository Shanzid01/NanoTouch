package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ArrayTypeAdapter */
public final class C0676a<E> extends al<Object> {
    public static final am f1680a = new C0677b();
    private final Class<E> f1681b;
    private final al<E> f1682c;

    public C0676a(C0743k c0743k, al<E> alVar, Class<E> cls) {
        this.f1682c = new C0702y(c0743k, alVar, cls);
        this.f1681b = cls;
    }

    public Object mo1122b(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        List arrayList = new ArrayList();
        c0683a.mo1124a();
        while (c0683a.mo1129e()) {
            arrayList.add(this.f1682c.mo1122b(c0683a));
        }
        c0683a.mo1125b();
        Object newInstance = Array.newInstance(this.f1681b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public void mo1121a(C0686d c0686d, Object obj) {
        if (obj == null) {
            c0686d.mo1152f();
            return;
        }
        c0686d.mo1146b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f1682c.mo1121a(c0686d, Array.get(obj, i));
        }
        c0686d.mo1148c();
    }
}
