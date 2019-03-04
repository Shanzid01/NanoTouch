package com.google.p043a.p045b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor */
class C0715l implements ae<T> {
    final /* synthetic */ Constructor f1861a;
    final /* synthetic */ C0709f f1862b;

    C0715l(C0709f c0709f, Constructor constructor) {
        this.f1862b = c0709f;
        this.f1861a = constructor;
    }

    public T mo1158a() {
        try {
            return this.f1861a.newInstance(null);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to invoke " + this.f1861a + " with no args", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to invoke " + this.f1861a + " with no args", e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
