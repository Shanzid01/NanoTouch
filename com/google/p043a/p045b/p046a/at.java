package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;

/* compiled from: TypeAdapters */
final class at implements am {
    at() {
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Class a = c0731a.m3660a();
        if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
            return null;
        }
        if (!a.isEnum()) {
            a = a.getSuperclass();
        }
        return new bh(a);
    }
}
