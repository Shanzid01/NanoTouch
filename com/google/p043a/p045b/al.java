package com.google.p043a.p045b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
final class al extends ak {
    final /* synthetic */ Method f1836a;
    final /* synthetic */ Object f1837b;

    al(Method method, Object obj) {
        this.f1836a = method;
        this.f1837b = obj;
    }

    public <T> T mo1157a(Class<T> cls) {
        return this.f1836a.invoke(this.f1837b, new Object[]{cls});
    }
}
