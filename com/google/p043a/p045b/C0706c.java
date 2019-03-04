package com.google.p043a.p045b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: $Gson$Types */
final class C0706c implements Serializable, GenericArrayType {
    private static final long serialVersionUID = 0;
    private final Type f1842a;

    public C0706c(Type type) {
        this.f1842a = C0705b.m3607d(type);
    }

    public Type getGenericComponentType() {
        return this.f1842a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && C0705b.m3601a((Type) this, (GenericArrayType) obj);
    }

    public int hashCode() {
        return this.f1842a.hashCode();
    }

    public String toString() {
        return C0705b.m3609f(this.f1842a) + "[]";
    }
}
