package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;

/* compiled from: TypeAdapters */
final class az implements am {
    final /* synthetic */ Class f1695a;
    final /* synthetic */ al f1696b;

    az(Class cls, al alVar) {
        this.f1695a = cls;
        this.f1696b = alVar;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        return this.f1695a.isAssignableFrom(c0731a.m3660a()) ? this.f1696b : null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.f1695a.getName() + ",adapter=" + this.f1696b + "]";
    }
}
