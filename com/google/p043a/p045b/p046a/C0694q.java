package com.google.p043a.p045b.p046a;

import com.google.p043a.C0736j;
import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p044a.C0669b;
import com.google.p043a.p044a.C0670c;
import com.google.p043a.p045b.C0705b;
import com.google.p043a.p045b.C0709f;
import com.google.p043a.p045b.C0722s;
import com.google.p043a.p045b.af;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class C0694q implements am {
    private final C0709f f1752a;
    private final C0736j f1753b;
    private final C0722s f1754c;

    public C0694q(C0709f c0709f, C0736j c0736j, C0722s c0722s) {
        this.f1752a = c0709f;
        this.f1753b = c0736j;
        this.f1754c = c0722s;
    }

    public boolean m3546a(Field field, boolean z) {
        return C0694q.m3544a(field, z, this.f1754c);
    }

    static boolean m3544a(Field field, boolean z, C0722s c0722s) {
        return (c0722s.m3637a(field.getType(), z) || c0722s.m3638a(field, z)) ? false : true;
    }

    private String m3542a(Field field) {
        return C0694q.m3541a(this.f1753b, field);
    }

    static String m3541a(C0736j c0736j, Field field) {
        C0670c c0670c = (C0670c) field.getAnnotation(C0670c.class);
        return c0670c == null ? c0736j.translateName(field) : c0670c.m3255a();
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Class a = c0731a.m3660a();
        if (Object.class.isAssignableFrom(a)) {
            return new C0697s(this.f1752a.m3616a((C0731a) c0731a), m3543a(c0743k, (C0731a) c0731a, a));
        }
        return null;
    }

    private C0695t m3540a(C0743k c0743k, Field field, String str, C0731a<?> c0731a, boolean z, boolean z2) {
        return new C0696r(this, str, z, z2, c0743k, field, c0731a, af.m3581a(c0731a.m3660a()));
    }

    private al<?> m3539a(C0743k c0743k, Field field, C0731a<?> c0731a) {
        C0669b c0669b = (C0669b) field.getAnnotation(C0669b.class);
        if (c0669b != null) {
            al<?> a = C0682g.m3426a(this.f1752a, c0743k, c0731a, c0669b);
            if (a != null) {
                return a;
            }
        }
        return c0743k.m3671a((C0731a) c0731a);
    }

    private Map<String, C0695t> m3543a(C0743k c0743k, C0731a<?> c0731a, Class<?> cls) {
        Map<String, C0695t> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = c0731a.m3661b();
        Class a;
        while (a != Object.class) {
            for (Field field : a.getDeclaredFields()) {
                boolean a2 = m3546a(field, true);
                boolean a3 = m3546a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    C0695t a4 = m3540a(c0743k, field, m3542a(field), C0731a.m3657a(C0705b.m3598a(c0731a.m3661b(), a, field.getGenericType())), a2, a3);
                    a4 = (C0695t) linkedHashMap.put(a4.f1755g, a4);
                    if (a4 != null) {
                        throw new IllegalArgumentException(b + " declares multiple JSON fields named " + a4.f1755g);
                    }
                }
            }
            c0731a = C0731a.m3657a(C0705b.m3598a(c0731a.m3661b(), a, a.getGenericSuperclass()));
            a = c0731a.m3660a();
        }
        return linkedHashMap;
    }
}
