package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;

/* compiled from: TypeAdapters */
final class av implements am {
    final /* synthetic */ Class f1687a;
    final /* synthetic */ al f1688b;

    av(Class cls, al alVar) {
        this.f1687a = cls;
        this.f1688b = alVar;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        return c0731a.m3660a() == this.f1687a ? this.f1688b : null;
    }

    public String toString() {
        return "Factory[type=" + this.f1687a.getName() + ",adapter=" + this.f1688b + "]";
    }
}
