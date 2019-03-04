package com.p019a.p020a.p023c;

import java.io.File;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p018g.C0312q;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ah implements Runnable {
    final /* synthetic */ File f1224a;
    final /* synthetic */ C0413z f1225b;

    ah(C0413z c0413z, File file) {
        this.f1225b = c0413z;
        this.f1224a = file;
    }

    public void run() {
        if (C0214m.m1937n(this.f1225b.f1392q.m2334B())) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            au a = this.f1225b.f1392q.m2774a(C0312q.m2242a().m2246b());
            if (a != null) {
                new bw(a).m2661a(new ca(this.f1224a, C0413z.f1381f));
            }
        }
    }
}
