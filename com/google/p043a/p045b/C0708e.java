package com.google.p043a.p045b;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: $Gson$Types */
final class C0708e implements Serializable, WildcardType {
    private static final long serialVersionUID = 0;
    private final Type f1846a;
    private final Type f1847b;

    public C0708e(Type[] typeArr, Type[] typeArr2) {
        boolean z;
        boolean z2 = true;
        C0704a.m3574a(typeArr2.length <= 1);
        if (typeArr.length == 1) {
            z = true;
        } else {
            z = false;
        }
        C0704a.m3574a(z);
        if (typeArr2.length == 1) {
            C0704a.m3573a(typeArr2[0]);
            C0705b.m3612i(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                z2 = false;
            }
            C0704a.m3574a(z2);
            this.f1847b = C0705b.m3607d(typeArr2[0]);
            this.f1846a = Object.class;
            return;
        }
        C0704a.m3573a(typeArr[0]);
        C0705b.m3612i(typeArr[0]);
        this.f1847b = null;
        this.f1846a = C0705b.m3607d(typeArr[0]);
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.f1846a};
    }

    public Type[] getLowerBounds() {
        if (this.f1847b == null) {
            return C0705b.f1841a;
        }
        return new Type[]{this.f1847b};
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && C0705b.m3601a((Type) this, (WildcardType) obj);
    }

    public int hashCode() {
        return (this.f1847b != null ? this.f1847b.hashCode() + 31 : 1) ^ (this.f1846a.hashCode() + 31);
    }

    public String toString() {
        if (this.f1847b != null) {
            return "? super " + C0705b.m3609f(this.f1847b);
        }
        if (this.f1846a == Object.class) {
            return "?";
        }
        return "? extends " + C0705b.m3609f(this.f1846a);
    }
}
