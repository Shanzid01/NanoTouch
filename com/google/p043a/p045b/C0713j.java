package com.google.p043a.p045b;

import java.lang.reflect.Type;

/* compiled from: ConstructorConstructor */
class C0713j implements ae<T> {
    final /* synthetic */ Class f1854a;
    final /* synthetic */ Type f1855b;
    final /* synthetic */ C0709f f1856c;
    private final ak f1857d = ak.m3585a();

    C0713j(C0709f c0709f, Class cls, Type type) {
        this.f1856c = c0709f;
        this.f1854a = cls;
        this.f1855b = type;
    }

    public T mo1158a() {
        try {
            return this.f1857d.mo1157a(this.f1854a);
        } catch (Throwable e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.f1855b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
