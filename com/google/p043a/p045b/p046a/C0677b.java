package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p045b.C0705b;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: ArrayTypeAdapter */
final class C0677b implements am {
    C0677b() {
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Type b = c0731a.m3661b();
        if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
            return null;
        }
        b = C0705b.m3610g(b);
        return new C0676a(c0743k, c0743k.m3671a(C0731a.m3657a(b)), C0705b.m3608e(b));
    }
}
