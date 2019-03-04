package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p045b.C0726w;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ObjectTypeAdapter */
public final class C0691n extends al<Object> {
    public static final am f1749a = new C0692o();
    private final C0743k f1750b;

    private C0691n(C0743k c0743k) {
        this.f1750b = c0743k;
    }

    public Object mo1122b(C0683a c0683a) {
        switch (C0693p.f1751a[c0683a.mo1130f().ordinal()]) {
            case 1:
                List arrayList = new ArrayList();
                c0683a.mo1124a();
                while (c0683a.mo1129e()) {
                    arrayList.add(mo1122b(c0683a));
                }
                c0683a.mo1125b();
                return arrayList;
            case 2:
                Object c0726w = new C0726w();
                c0683a.mo1126c();
                while (c0683a.mo1129e()) {
                    c0726w.put(c0683a.mo1131g(), mo1122b(c0683a));
                }
                c0683a.mo1128d();
                return c0726w;
            case 3:
                return c0683a.mo1132h();
            case 4:
                return Double.valueOf(c0683a.mo1135k());
            case 5:
                return Boolean.valueOf(c0683a.mo1133i());
            case 6:
                c0683a.mo1134j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void mo1121a(C0686d c0686d, Object obj) {
        if (obj == null) {
            c0686d.mo1152f();
            return;
        }
        al a = this.f1750b.m3672a(obj.getClass());
        if (a instanceof C0691n) {
            c0686d.mo1150d();
            c0686d.mo1151e();
            return;
        }
        a.mo1121a(c0686d, obj);
    }
}
