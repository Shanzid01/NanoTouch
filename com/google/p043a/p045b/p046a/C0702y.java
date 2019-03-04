package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class C0702y<T> extends al<T> {
    private final C0743k f1770a;
    private final al<T> f1771b;
    private final Type f1772c;

    C0702y(C0743k c0743k, al<T> alVar, Type type) {
        this.f1770a = c0743k;
        this.f1771b = alVar;
        this.f1772c = type;
    }

    public T mo1122b(C0683a c0683a) {
        return this.f1771b.mo1122b(c0683a);
    }

    public void mo1121a(C0686d c0686d, T t) {
        al alVar = this.f1771b;
        Type a = m3565a(this.f1772c, (Object) t);
        if (a != this.f1772c) {
            alVar = this.f1770a.m3671a(C0731a.m3657a(a));
            if ((alVar instanceof C0697s) && !(this.f1771b instanceof C0697s)) {
                alVar = this.f1771b;
            }
        }
        alVar.mo1121a(c0686d, t);
    }

    private Type m3565a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
