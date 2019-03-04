package com.google.p043a.p045b;

import com.google.p043a.C0752s;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: ConstructorConstructor */
public final class C0709f {
    private final Map<Type, C0752s<?>> f1848a;

    public C0709f(Map<Type, C0752s<?>> map) {
        this.f1848a = map;
    }

    public <T> ae<T> m3616a(C0731a<T> c0731a) {
        Type b = c0731a.m3661b();
        Class a = c0731a.m3660a();
        C0752s c0752s = (C0752s) this.f1848a.get(b);
        if (c0752s != null) {
            return new C0710g(this, c0752s, b);
        }
        c0752s = (C0752s) this.f1848a.get(a);
        if (c0752s != null) {
            return new C0714k(this, c0752s, b);
        }
        ae<T> a2 = m3613a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = m3614a(b, a);
        return a2 == null ? m3615b(b, a) : a2;
    }

    private <T> ae<T> m3613a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C0715l(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> ae<T> m3614a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new C0716m(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new C0717n(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new C0718o(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C0719p(this);
            }
            return new C0720q(this);
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C0721r(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C0731a.m3657a(((ParameterizedType) type).getActualTypeArguments()[0]).m3660a())) {
                return new C0712i(this);
            }
            return new C0711h(this);
        }
    }

    private <T> ae<T> m3615b(Type type, Class<? super T> cls) {
        return new C0713j(this, cls, type);
    }

    public String toString() {
        return this.f1848a.toString();
    }
}
