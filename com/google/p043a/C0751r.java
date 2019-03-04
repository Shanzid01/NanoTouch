package com.google.p043a;

import com.google.p043a.p045b.C0704a;
import com.google.p043a.p045b.C0722s;
import com.google.p043a.p045b.p046a.C0703z;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder */
public final class C0751r {
    private C0722s f1916a = C0722s.f1870a;
    private af f1917b = af.DEFAULT;
    private C0736j f1918c = C0737d.IDENTITY;
    private final Map<Type, C0752s<?>> f1919d = new HashMap();
    private final List<am> f1920e = new ArrayList();
    private final List<am> f1921f = new ArrayList();
    private boolean f1922g;
    private String f1923h;
    private int f1924i = 2;
    private int f1925j = 2;
    private boolean f1926k;
    private boolean f1927l;
    private boolean f1928m = true;
    private boolean f1929n;
    private boolean f1930o;

    public C0751r m3701a(String str) {
        this.f1923h = str;
        return this;
    }

    public C0751r m3702a(Type type, Object obj) {
        boolean z = (obj instanceof ad) || (obj instanceof C0673v) || (obj instanceof C0752s) || (obj instanceof al);
        C0704a.m3574a(z);
        if (obj instanceof C0752s) {
            this.f1919d.put(type, (C0752s) obj);
        }
        if ((obj instanceof ad) || (obj instanceof C0673v)) {
            this.f1920e.add(ai.m3295b(C0731a.m3657a(type), obj));
        }
        if (obj instanceof al) {
            this.f1920e.add(C0703z.m3568a(C0731a.m3657a(type), (al) obj));
        }
        return this;
    }

    public C0743k m3700a() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f1920e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f1921f);
        m3699a(this.f1923h, this.f1924i, this.f1925j, arrayList);
        return new C0743k(this.f1916a, this.f1918c, this.f1919d, this.f1922g, this.f1926k, this.f1930o, this.f1928m, this.f1929n, this.f1927l, this.f1917b, arrayList);
    }

    private void m3699a(String str, int i, int i2, List<am> list) {
        Object c0674a;
        if (str != null && !"".equals(str.trim())) {
            c0674a = new C0674a(str);
        } else if (i != 2 && i2 != 2) {
            c0674a = new C0674a(i, i2);
        } else {
            return;
        }
        list.add(ai.m3294a(C0731a.m3659b(Date.class), c0674a));
        list.add(ai.m3294a(C0731a.m3659b(Timestamp.class), c0674a));
        list.add(ai.m3294a(C0731a.m3659b(java.sql.Date.class), c0674a));
    }
}
