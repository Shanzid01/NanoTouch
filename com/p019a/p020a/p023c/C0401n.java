package com.p019a.p020a.p023c;

import android.app.Activity;
import p006b.p007a.p008a.p009a.p010a.p018g.C0315t;
import p006b.p007a.p008a.p009a.p010a.p018g.C0317w;

/* compiled from: CrashlyticsCore */
class C0401n implements C0315t<Boolean> {
    final /* synthetic */ C0395h f1358a;

    C0401n(C0395h c0395h) {
        this.f1358a = c0395h;
    }

    public /* synthetic */ Object mo564b(C0317w c0317w) {
        return m2812a(c0317w);
    }

    public Boolean m2812a(C0317w c0317w) {
        boolean z = true;
        Activity b = this.f1358a.m2335C().m2305b();
        if (!(b == null || b.isFinishing() || !this.f1358a.m2801v())) {
            z = this.f1358a.m2764a(b, c0317w.f983c);
        }
        return Boolean.valueOf(z);
    }
}
