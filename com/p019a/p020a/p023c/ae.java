package com.p019a.p020a.p023c;

import com.p019a.p020a.p023c.p024a.p025a.C0383d;
import java.util.concurrent.Callable;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ae implements Callable<Boolean> {
    final /* synthetic */ C0413z f1220a;

    ae(C0413z c0413z) {
        this.f1220a = c0413z;
    }

    public /* synthetic */ Object call() {
        return m2553a();
    }

    public Boolean m2553a() {
        if (this.f1220a.f1386k.get()) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
            return Boolean.valueOf(false);
        }
        C0326f.m2298h().mo511a("CrashlyticsCore", "Finalizing previously open sessions.");
        C0383d t = this.f1220a.f1392q.m2799t();
        if (t != null) {
            this.f1220a.m2829a(t);
        }
        this.f1220a.m2843a(true);
        C0326f.m2298h().mo511a("CrashlyticsCore", "Closed all previously open sessions");
        return Boolean.valueOf(true);
    }
}
