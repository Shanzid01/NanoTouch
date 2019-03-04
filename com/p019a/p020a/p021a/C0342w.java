package com.p019a.p020a.p021a;

import java.util.Map;

/* compiled from: PredefinedEvent */
public abstract class C0342w<T extends C0342w> extends C0341d<T> {
    final C0346c f1058d = new C0346c(this.b);

    abstract String mo533a();

    Map<String, Object> m2367c() {
        return this.f1058d.f1108b;
    }

    public String toString() {
        return "{type:\"" + mo533a() + '\"' + ", predefinedAttributes:" + this.f1058d + ", customAttributes:" + this.c + "}";
    }
}
