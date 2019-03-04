package com.p019a.p020a;

import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p022b.C0373e;
import com.p019a.p020a.p023c.C0395h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.C0338r;

/* compiled from: Crashlytics */
public class C0367a extends C0337q<Void> implements C0338r {
    public final C0345b f1147a;
    public final C0373e f1148b;
    public final C0395h f1149c;
    public final Collection<? extends C0337q> f1150d;

    protected /* synthetic */ Object mo532f() {
        return m2513d();
    }

    public C0367a() {
        this(new C0345b(), new C0373e(), new C0395h());
    }

    C0367a(C0345b c0345b, C0373e c0373e, C0395h c0395h) {
        this.f1147a = c0345b;
        this.f1148b = c0373e;
        this.f1149c = c0395h;
        this.f1150d = Collections.unmodifiableCollection(Arrays.asList(new C0337q[]{c0345b, c0373e, c0395h}));
    }

    public String mo529a() {
        return "2.5.2.79";
    }

    public String mo531b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends C0337q> mo547c() {
        return this.f1150d;
    }

    protected Void m2513d() {
        return null;
    }

    public static C0367a m2509e() {
        return (C0367a) C0326f.m2290a(C0367a.class);
    }
}
