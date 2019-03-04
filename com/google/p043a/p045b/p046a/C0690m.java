package com.google.p043a.p045b.p046a;

import com.google.p043a.C0675w;
import com.google.p043a.C0743k;
import com.google.p043a.ab;
import com.google.p043a.al;
import com.google.p043a.p045b.C0724u;
import com.google.p043a.p045b.ae;
import com.google.p043a.p045b.ag;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MapTypeAdapterFactory */
final class C0690m<K, V> extends al<Map<K, V>> {
    final /* synthetic */ C0689l f1745a;
    private final al<K> f1746b;
    private final al<V> f1747c;
    private final ae<? extends Map<K, V>> f1748d;

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3531a(c0683a);
    }

    public C0690m(C0689l c0689l, C0743k c0743k, Type type, al<K> alVar, Type type2, al<V> alVar2, ae<? extends Map<K, V>> aeVar) {
        this.f1745a = c0689l;
        this.f1746b = new C0702y(c0743k, alVar, type);
        this.f1747c = new C0702y(c0743k, alVar2, type2);
        this.f1748d = aeVar;
    }

    public Map<K, V> m3531a(C0683a c0683a) {
        C0734c f = c0683a.mo1130f();
        if (f == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        Map<K, V> map = (Map) this.f1748d.mo1158a();
        Object b;
        if (f == C0734c.BEGIN_ARRAY) {
            c0683a.mo1124a();
            while (c0683a.mo1129e()) {
                c0683a.mo1124a();
                b = this.f1746b.mo1122b(c0683a);
                if (map.put(b, this.f1747c.mo1122b(c0683a)) != null) {
                    throw new com.google.p043a.ae("duplicate key: " + b);
                }
                c0683a.mo1125b();
            }
            c0683a.mo1125b();
            return map;
        }
        c0683a.mo1126c();
        while (c0683a.mo1129e()) {
            C0724u.f1883a.mo1159a(c0683a);
            b = this.f1746b.mo1122b(c0683a);
            if (map.put(b, this.f1747c.mo1122b(c0683a)) != null) {
                throw new com.google.p043a.ae("duplicate key: " + b);
            }
        }
        c0683a.mo1128d();
        return map;
    }

    public void m3533a(C0686d c0686d, Map<K, V> map) {
        int i = 0;
        if (map == null) {
            c0686d.mo1152f();
        } else if (this.f1745a.f1744b) {
            List arrayList = new ArrayList(map.size());
            List arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            for (Entry entry : map.entrySet()) {
                int i3;
                C0675w a = this.f1746b.m3290a(entry.getKey());
                arrayList.add(a);
                arrayList2.add(entry.getValue());
                if (a.m3269g() || a.m3270h()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2 = i3 | i2;
            }
            if (i2 != 0) {
                c0686d.mo1146b();
                while (i < arrayList.size()) {
                    c0686d.mo1146b();
                    ag.m3584a((C0675w) arrayList.get(i), c0686d);
                    this.f1747c.mo1121a(c0686d, arrayList2.get(i));
                    c0686d.mo1148c();
                    i++;
                }
                c0686d.mo1148c();
                return;
            }
            c0686d.mo1150d();
            while (i < arrayList.size()) {
                c0686d.mo1143a(m3530a((C0675w) arrayList.get(i)));
                this.f1747c.mo1121a(c0686d, arrayList2.get(i));
                i++;
            }
            c0686d.mo1151e();
        } else {
            c0686d.mo1150d();
            for (Entry entry2 : map.entrySet()) {
                c0686d.mo1143a(String.valueOf(entry2.getKey()));
                this.f1747c.mo1121a(c0686d, entry2.getValue());
            }
            c0686d.mo1151e();
        }
    }

    private String m3530a(C0675w c0675w) {
        if (c0675w.m3271i()) {
            ab m = c0675w.m3275m();
            if (m.m3288p()) {
                return String.valueOf(m.mo1113a());
            }
            if (m.m3287o()) {
                return Boolean.toString(m.mo1118f());
            }
            if (m.m3289q()) {
                return m.mo1114b();
            }
            throw new AssertionError();
        } else if (c0675w.m3272j()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }
}
