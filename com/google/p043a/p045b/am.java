package com.google.p043a.p045b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
final class am extends ak {
    final /* synthetic */ Method f1838a;
    final /* synthetic */ int f1839b;

    am(Method method, int i) {
        this.f1838a = method;
        this.f1839b = i;
    }

    public <T> T mo1157a(Class<T> cls) {
        return this.f1838a.invoke(null, new Object[]{cls, Integer.valueOf(this.f1839b)});
    }
}
