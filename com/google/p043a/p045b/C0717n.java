package com.google.p043a.p045b;

import com.google.p043a.C0754x;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* compiled from: ConstructorConstructor */
class C0717n implements ae<T> {
    final /* synthetic */ Type f1864a;
    final /* synthetic */ C0709f f1865b;

    C0717n(C0709f c0709f, Type type) {
        this.f1865b = c0709f;
        this.f1864a = type;
    }

    public T mo1158a() {
        if (this.f1864a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.f1864a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
            throw new C0754x("Invalid EnumSet type: " + this.f1864a.toString());
        }
        throw new C0754x("Invalid EnumSet type: " + this.f1864a.toString());
    }
}
