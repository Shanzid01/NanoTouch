package com.p019a.p020a.p021a;

/* compiled from: CustomEvent */
public class C0359q extends C0341d<C0359q> {
    private final String f1134a;

    public C0359q(String str) {
        if (str == null) {
            throw new NullPointerException("eventName must not be null");
        }
        this.f1134a = this.b.m2451a(str);
    }

    String m2485a() {
        return this.f1134a;
    }

    public String toString() {
        return "{eventName:\"" + this.f1134a + '\"' + ", customAttributes:" + this.c + "}";
    }
}
