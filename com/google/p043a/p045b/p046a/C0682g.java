package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p044a.C0669b;
import com.google.p043a.p045b.C0709f;
import com.google.p043a.p048c.C0731a;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class C0682g implements am {
    private final C0709f f1707a;

    public C0682g(C0709f c0709f) {
        this.f1707a = c0709f;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        C0669b c0669b = (C0669b) c0731a.m3660a().getAnnotation(C0669b.class);
        if (c0669b == null) {
            return null;
        }
        return C0682g.m3426a(this.f1707a, c0743k, c0731a, c0669b);
    }

    static al<?> m3426a(C0709f c0709f, C0743k c0743k, C0731a<?> c0731a, C0669b c0669b) {
        Class a = c0669b.m3254a();
        if (al.class.isAssignableFrom(a)) {
            return (al) c0709f.m3616a(C0731a.m3659b(a)).mo1158a();
        }
        if (am.class.isAssignableFrom(a)) {
            return ((am) c0709f.m3616a(C0731a.m3659b(a)).mo1158a()).mo1123a(c0743k, c0731a);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }
}
