package com.p019a.p020a.p021a;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0213k;
import p006b.p007a.p008a.p009a.p010a.p015d.C0262b;
import p006b.p007a.p008a.p009a.p010a.p015d.C0269l;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p018g.C0295b;

/* compiled from: EnabledSessionAnalyticsManagerStrategy */
class C0361s extends C0262b<ai> implements ah<ai> {
    final am f1135a;
    C0344t f1136b = new C0362u();
    C0269l f1137c;
    C0213k f1138d = new C0213k();
    boolean f1139e = true;
    boolean f1140f = true;
    private final C0337q f1141l;
    private final C0274m f1142m;

    public C0361s(C0337q c0337q, Context context, ScheduledExecutorService scheduledExecutorService, ae aeVar, C0274m c0274m, am amVar) {
        super(context, scheduledExecutorService, aeVar);
        this.f1141l = c0337q;
        this.f1142m = c0274m;
        this.f1135a = amVar;
    }

    public C0269l mo478a() {
        return this.f1137c;
    }

    public void mo545a(C0295b c0295b, String str) {
        this.f1137c = C0357o.m2479a(new af(this.f1141l, str, c0295b.f917a, this.f1142m, this.f1138d.m1889a(this.g)));
        ((ae) this.h).m2383a(c0295b);
        this.f1139e = c0295b.f922f;
        C0326f.m2298h().mo511a("Answers", "Custom event tracking " + (this.f1139e ? "enabled" : "disabled"));
        this.f1140f = c0295b.f923g;
        C0326f.m2298h().mo511a("Answers", "Predefined event tracking " + (this.f1140f ? "enabled" : "disabled"));
        if (c0295b.f924h > 1) {
            C0326f.m2298h().mo511a("Answers", "Event sampling enabled");
            this.f1136b = new ab(c0295b.f924h);
        }
        m2057a(c0295b.f918b);
    }

    public void mo546a(ak akVar) {
        ai a = akVar.m2403a(this.f1135a);
        if (!this.f1139e && al.CUSTOM.equals(a.f1069c)) {
            C0326f.m2298h().mo511a("Answers", "Custom events tracking disabled - skipping event: " + a);
        } else if (!this.f1140f && al.PREDEFINED.equals(a.f1069c)) {
            C0326f.m2298h().mo511a("Answers", "Predefined events tracking disabled - skipping event: " + a);
        } else if (this.f1136b.mo534a(a)) {
            C0326f.m2298h().mo511a("Answers", "Skipping filtered event: " + a);
        } else {
            m2059a((Object) a);
        }
    }
}
