package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.p045b.ae;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
final class C0679d<E> extends al<Collection<E>> {
    private final al<E> f1701a;
    private final ae<? extends Collection<E>> f1702b;

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3415a(c0683a);
    }

    public C0679d(C0743k c0743k, Type type, al<E> alVar, ae<? extends Collection<E>> aeVar) {
        this.f1701a = new C0702y(c0743k, alVar, type);
        this.f1702b = aeVar;
    }

    public Collection<E> m3415a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        Collection<E> collection = (Collection) this.f1702b.mo1158a();
        c0683a.mo1124a();
        while (c0683a.mo1129e()) {
            collection.add(this.f1701a.mo1122b(c0683a));
        }
        c0683a.mo1125b();
        return collection;
    }

    public void m3417a(C0686d c0686d, Collection<E> collection) {
        if (collection == null) {
            c0686d.mo1152f();
            return;
        }
        c0686d.mo1146b();
        for (E a : collection) {
            this.f1701a.mo1121a(c0686d, a);
        }
        c0686d.mo1148c();
    }
}
