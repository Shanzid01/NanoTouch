package com.p019a.p020a.p021a;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0222v;
import p006b.p007a.p008a.p009a.p010a.p015d.C0268i;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p018g.C0295b;

/* compiled from: AnswersEventsHandler */
class C0348f implements C0268i {
    final ScheduledExecutorService f1112a;
    ah f1113b;
    private final C0337q f1114c;
    private final Context f1115d;
    private final C0354l f1116e;
    private final ao f1117f;
    private final C0274m f1118g;

    public C0348f(C0337q c0337q, Context context, C0354l c0354l, ao aoVar, C0274m c0274m) {
        this(c0337q, context, c0354l, aoVar, c0274m, C0222v.m1944b("Answers Events Handler"));
    }

    C0348f(C0337q c0337q, Context context, C0354l c0354l, ao aoVar, C0274m c0274m, ScheduledExecutorService scheduledExecutorService) {
        this.f1113b = new C0360r();
        this.f1114c = c0337q;
        this.f1115d = context;
        this.f1116e = c0354l;
        this.f1117f = aoVar;
        this.f1118g = c0274m;
        this.f1112a = scheduledExecutorService;
    }

    public void m2463a(ak akVar) {
        m2464a(akVar, false, false);
    }

    public void m2467b(ak akVar) {
        m2464a(akVar, false, true);
    }

    public void m2468c(ak akVar) {
        m2464a(akVar, true, false);
    }

    public void m2462a(C0295b c0295b, String str) {
        m2457b(new C0349g(this, c0295b, str));
    }

    public void m2461a() {
        m2457b(new C0350h(this));
    }

    public void mo540a(String str) {
        m2457b(new C0351i(this));
    }

    public void m2466b() {
        m2457b(new C0352j(this));
    }

    void m2464a(ak akVar, boolean z, boolean z2) {
        Runnable c0353k = new C0353k(this, akVar, z2);
        if (z) {
            m2455a(c0353k);
        } else {
            m2457b(c0353k);
        }
    }

    private void m2455a(Runnable runnable) {
        try {
            this.f1112a.submit(runnable).get();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to run events task", e);
        }
    }

    private void m2457b(Runnable runnable) {
        try {
            this.f1112a.submit(runnable);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to submit events task", e);
        }
    }
}
