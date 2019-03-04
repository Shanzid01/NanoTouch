package com.mopub.common.p050b;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Reflection */
public class C1488k {
    private final Object f2150a;
    private final String f2151b;
    private Class<?> f2152c;
    private List<Class<?>> f2153d = new ArrayList();
    private List<Object> f2154e = new ArrayList();
    private boolean f2155f;
    private boolean f2156g;

    public C1488k(Object obj, String str) {
        this.f2150a = obj;
        this.f2151b = str;
        this.f2152c = obj != null ? obj.getClass() : null;
    }

    public <T> C1488k m4083a(Class<T> cls, T t) {
        this.f2153d.add(cls);
        this.f2154e.add(t);
        return this;
    }

    public C1488k m4082a(Class<?> cls) {
        this.f2156g = true;
        this.f2152c = cls;
        return this;
    }

    public Object m4084a() {
        Method a = C1487j.m4080a(this.f2152c, this.f2151b, (Class[]) this.f2153d.toArray(new Class[this.f2153d.size()]));
        if (this.f2155f) {
            a.setAccessible(true);
        }
        Object[] toArray = this.f2154e.toArray();
        if (this.f2156g) {
            return a.invoke(null, toArray);
        }
        return a.invoke(this.f2150a, toArray);
    }
}
