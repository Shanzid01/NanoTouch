package com.google.p043a.p048c;

import com.google.p043a.p045b.C0704a;
import com.google.p043a.p045b.C0705b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken */
public class C0731a<T> {
    final Class<? super T> f1896a;
    final Type f1897b;
    final int f1898c;

    protected C0731a() {
        this.f1897b = C0731a.m3658a(getClass());
        this.f1896a = C0705b.m3608e(this.f1897b);
        this.f1898c = this.f1897b.hashCode();
    }

    C0731a(Type type) {
        this.f1897b = C0705b.m3607d((Type) C0704a.m3573a((Object) type));
        this.f1896a = C0705b.m3608e(this.f1897b);
        this.f1898c = this.f1897b.hashCode();
    }

    static Type m3658a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C0705b.m3607d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> m3660a() {
        return this.f1896a;
    }

    public final Type m3661b() {
        return this.f1897b;
    }

    public final int hashCode() {
        return this.f1898c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0731a) && C0705b.m3601a(this.f1897b, ((C0731a) obj).f1897b);
    }

    public final String toString() {
        return C0705b.m3609f(this.f1897b);
    }

    public static C0731a<?> m3657a(Type type) {
        return new C0731a(type);
    }

    public static <T> C0731a<T> m3659b(Class<T> cls) {
        return new C0731a(cls);
    }
}
