package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;

/* compiled from: TypeAdapters */
final class aw implements am {
    final /* synthetic */ Class f1689a;
    final /* synthetic */ Class f1690b;
    final /* synthetic */ al f1691c;

    aw(Class cls, Class cls2, al alVar) {
        this.f1689a = cls;
        this.f1690b = cls2;
        this.f1691c = alVar;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Class a = c0731a.m3660a();
        return (a == this.f1689a || a == this.f1690b) ? this.f1691c : null;
    }

    public String toString() {
        return "Factory[type=" + this.f1690b.getName() + "+" + this.f1689a.getName() + ",adapter=" + this.f1691c + "]";
    }
}
