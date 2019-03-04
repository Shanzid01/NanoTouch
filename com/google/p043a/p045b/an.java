package com.google.p043a.p045b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
final class an extends ak {
    final /* synthetic */ Method f1840a;

    an(Method method) {
        this.f1840a = method;
    }

    public <T> T mo1157a(Class<T> cls) {
        return this.f1840a.invoke(null, new Object[]{cls, Object.class});
    }
}
