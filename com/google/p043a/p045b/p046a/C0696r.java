package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p048c.C0731a;
import java.lang.reflect.Field;

/* compiled from: ReflectiveTypeAdapterFactory */
class C0696r extends C0695t {
    final al<?> f1758a = this.f1763f.m3539a(this.f1759b, this.f1760c, this.f1761d);
    final /* synthetic */ C0743k f1759b;
    final /* synthetic */ Field f1760c;
    final /* synthetic */ C0731a f1761d;
    final /* synthetic */ boolean f1762e;
    final /* synthetic */ C0694q f1763f;

    C0696r(C0694q c0694q, String str, boolean z, boolean z2, C0743k c0743k, Field field, C0731a c0731a, boolean z3) {
        this.f1763f = c0694q;
        this.f1759b = c0743k;
        this.f1760c = field;
        this.f1761d = c0731a;
        this.f1762e = z3;
        super(str, z, z2);
    }

    void mo1155a(C0686d c0686d, Object obj) {
        new C0702y(this.f1759b, this.f1758a, this.f1761d.m3661b()).mo1121a(c0686d, this.f1760c.get(obj));
    }

    void mo1154a(C0683a c0683a, Object obj) {
        Object b = this.f1758a.mo1122b(c0683a);
        if (b != null || !this.f1762e) {
            this.f1760c.set(obj, b);
        }
    }

    public boolean mo1156a(Object obj) {
        if (this.h && this.f1760c.get(obj) != obj) {
            return true;
        }
        return false;
    }
}
