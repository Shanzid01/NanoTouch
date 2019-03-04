package com.google.p043a.p045b;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: $Gson$Types */
final class C0707d implements Serializable, ParameterizedType {
    private static final long serialVersionUID = 0;
    private final Type f1843a;
    private final Type f1844b;
    private final Type[] f1845c;

    public C0707d(Type type, Type type2, Type... typeArr) {
        int i = 0;
        if (type2 instanceof Class) {
            boolean z;
            Class cls = (Class) type2;
            int i2 = (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) ? 1 : 0;
            if (type == null && i2 == 0) {
                z = false;
            } else {
                z = true;
            }
            C0704a.m3574a(z);
        }
        this.f1843a = type == null ? null : C0705b.m3607d(type);
        this.f1844b = C0705b.m3607d(type2);
        this.f1845c = (Type[]) typeArr.clone();
        while (i < this.f1845c.length) {
            C0704a.m3573a(this.f1845c[i]);
            C0705b.m3612i(this.f1845c[i]);
            this.f1845c[i] = C0705b.m3607d(this.f1845c[i]);
            i++;
        }
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.f1845c.clone();
    }

    public Type getRawType() {
        return this.f1844b;
    }

    public Type getOwnerType() {
        return this.f1843a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && C0705b.m3601a((Type) this, (ParameterizedType) obj);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f1845c) ^ this.f1844b.hashCode()) ^ C0705b.m3602b(this.f1843a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((this.f1845c.length + 1) * 30);
        stringBuilder.append(C0705b.m3609f(this.f1844b));
        if (this.f1845c.length == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append("<").append(C0705b.m3609f(this.f1845c[0]));
        for (int i = 1; i < this.f1845c.length; i++) {
            stringBuilder.append(", ").append(C0705b.m3609f(this.f1845c[i]));
        }
        return stringBuilder.append(">").toString();
    }
}
