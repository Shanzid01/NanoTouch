package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p044a.C0670c;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypeAdapters */
final class bh<T extends Enum<T>> extends al<T> {
    private final Map<String, T> f1698a = new HashMap();
    private final Map<T, String> f1699b = new HashMap();

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3410a(c0683a);
    }

    public bh(Class<T> cls) {
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                Object a;
                String name = enumR.name();
                C0670c c0670c = (C0670c) cls.getField(name).getAnnotation(C0670c.class);
                if (c0670c != null) {
                    a = c0670c.m3255a();
                } else {
                    String str = name;
                }
                this.f1698a.put(a, enumR);
                this.f1699b.put(enumR, a);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    public T m3410a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return (Enum) this.f1698a.get(c0683a.mo1132h());
        }
        c0683a.mo1134j();
        return null;
    }

    public void m3411a(C0686d c0686d, T t) {
        c0686d.mo1147b(t == null ? null : (String) this.f1699b.get(t));
    }
}
