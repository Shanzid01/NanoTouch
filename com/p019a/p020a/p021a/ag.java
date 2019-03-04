package com.p019a.p020a.p021a;

import android.app.Activity;
import android.os.Looper;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p018g.C0295b;

/* compiled from: SessionAnalyticsManager */
class ag {
    final C0348f f1066a;

    public ag(C0348f c0348f) {
        this.f1066a = c0348f;
    }

    public void m2390a(C0359q c0359q) {
        C0326f.m2298h().mo511a("Answers", "Logged custom event: " + c0359q);
        this.f1066a.m2463a(ai.m2399a(c0359q));
    }

    public void m2391a(C0342w c0342w) {
        C0326f.m2298h().mo511a("Answers", "Logged predefined event: " + c0342w);
        this.f1066a.m2463a(ai.m2400a(c0342w));
    }

    public void m2392a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        C0326f.m2298h().mo511a("Answers", "Logged crash");
        this.f1066a.m2468c(ai.m2402b(str));
    }

    public void m2394b(String str) {
        C0326f.m2298h().mo511a("Answers", "Logged error");
        this.f1066a.m2463a(ai.m2401a(str));
    }

    public void m2387a() {
        C0326f.m2298h().mo511a("Answers", "Logged install");
        this.f1066a.m2467b(ai.m2397a());
    }

    public void m2388a(Activity activity, al alVar) {
        C0326f.m2298h().mo511a("Answers", "Logged lifecycle event: " + alVar.name());
        this.f1066a.m2463a(ai.m2398a(alVar, activity));
    }

    public void m2389a(C0295b c0295b, String str) {
        this.f1066a.m2462a(c0295b, str);
    }

    public void m2393b() {
        this.f1066a.m2461a();
    }
}
