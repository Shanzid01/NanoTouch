package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;

/* compiled from: TypeAdapters */
final class ay implements am {
    final /* synthetic */ Class f1692a;
    final /* synthetic */ Class f1693b;
    final /* synthetic */ al f1694c;

    ay(Class cls, Class cls2, al alVar) {
        this.f1692a = cls;
        this.f1693b = cls2;
        this.f1694c = alVar;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Class a = c0731a.m3660a();
        return (a == this.f1692a || a == this.f1693b) ? this.f1694c : null;
    }

    public String toString() {
        return "Factory[type=" + this.f1692a.getName() + "+" + this.f1693b.getName() + ",adapter=" + this.f1694c + "]";
    }
}
