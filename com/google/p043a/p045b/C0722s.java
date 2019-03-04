package com.google.p043a.p045b;

import com.google.p043a.C0730b;
import com.google.p043a.C0732c;
import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p044a.C0668a;
import com.google.p043a.p044a.C0671d;
import com.google.p043a.p044a.C0672e;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class C0722s implements am, Cloneable {
    public static final C0722s f1870a = new C0722s();
    private double f1871b = -1.0d;
    private int f1872c = 136;
    private boolean f1873d = true;
    private boolean f1874e;
    private List<C0730b> f1875f = Collections.emptyList();
    private List<C0730b> f1876g = Collections.emptyList();

    protected /* synthetic */ Object clone() {
        return m3636a();
    }

    protected C0722s m3636a() {
        try {
            return (C0722s) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        Class a = c0731a.m3660a();
        boolean a2 = m3637a(a, true);
        boolean a3 = m3637a(a, false);
        if (a2 || a3) {
            return new C0723t(this, a3, a2, c0743k, c0731a);
        }
        return null;
    }

    public boolean m3638a(Field field, boolean z) {
        if ((this.f1872c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f1871b != -1.0d && !m3630a((C0671d) field.getAnnotation(C0671d.class), (C0672e) field.getAnnotation(C0672e.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f1874e) {
            C0668a c0668a = (C0668a) field.getAnnotation(C0668a.class);
            if (c0668a == null || (z ? !c0668a.m3252a() : !c0668a.m3253b())) {
                return true;
            }
        }
        if (!this.f1873d && m3633b(field.getType())) {
            return true;
        }
        if (m3632a(field.getType())) {
            return true;
        }
        List<C0730b> list = z ? this.f1875f : this.f1876g;
        if (!list.isEmpty()) {
            C0732c c0732c = new C0732c(field);
            for (C0730b a : list) {
                if (a.m3655a(c0732c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean m3637a(Class<?> cls, boolean z) {
        if (this.f1871b != -1.0d && !m3630a((C0671d) cls.getAnnotation(C0671d.class), (C0672e) cls.getAnnotation(C0672e.class))) {
            return true;
        }
        if (!this.f1873d && m3633b(cls)) {
            return true;
        }
        if (m3632a((Class) cls)) {
            return true;
        }
        for (C0730b a : z ? this.f1875f : this.f1876g) {
            if (a.m3656a((Class) cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean m3632a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean m3633b(Class<?> cls) {
        return cls.isMemberClass() && !m3634c(cls);
    }

    private boolean m3634c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean m3630a(C0671d c0671d, C0672e c0672e) {
        return m3629a(c0671d) && m3631a(c0672e);
    }

    private boolean m3629a(C0671d c0671d) {
        if (c0671d == null || c0671d.m3256a() <= this.f1871b) {
            return true;
        }
        return false;
    }

    private boolean m3631a(C0672e c0672e) {
        if (c0672e == null || c0672e.m3257a() > this.f1871b) {
            return true;
        }
        return false;
    }
}
