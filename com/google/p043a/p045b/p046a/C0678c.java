package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p045b.C0705b;
import com.google.p043a.p045b.C0709f;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
public final class C0678c implements am {
    private final C0709f f1700a;

    public C0678c(C0709f c0709f) {
        this.f1700a = c0709f;
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Type b = c0731a.m3661b();
        Class a = c0731a.m3660a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = C0705b.m3596a(b, a);
        return new C0679d(c0743k, a2, c0743k.m3671a(C0731a.m3657a(a2)), this.f1700a.m3616a((C0731a) c0731a));
    }
}
