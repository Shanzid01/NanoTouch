package com.p019a.p020a.p023c;

import java.util.List;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0205l;

/* compiled from: ReportUploader */
class by extends C0205l {
    final /* synthetic */ bw f1301a;
    private final float f1302b;

    by(bw bwVar, float f) {
        this.f1301a = bwVar;
        this.f1302b = f;
    }

    public void mo467a() {
        try {
            m2662b();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
        }
        this.f1301a.f1300f = null;
    }

    private void m2662b() {
        C0326f.m2298h().mo511a("CrashlyticsCore", "Starting report processing in " + this.f1302b + " second(s)...");
        if (this.f1302b > 0.0f) {
            try {
                Thread.sleep((long) (this.f1302b * 1000.0f));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        C0395h e2 = C0395h.m2769e();
        C0413z m = e2.m2792m();
        List<bv> a = this.f1301a.m2659a();
        if (!m.m2876a()) {
            if (a.isEmpty() || e2.m2803x()) {
                List list = a;
                int i = 0;
                while (!r0.isEmpty() && !C0395h.m2769e().m2792m().m2876a()) {
                    C0326f.m2298h().mo511a("CrashlyticsCore", "Attempting to send " + r0.size() + " report(s)");
                    for (bv a2 : r0) {
                        this.f1301a.m2661a(a2);
                    }
                    List a3 = this.f1301a.m2659a();
                    if (a3.isEmpty()) {
                        list = a3;
                    } else {
                        int i2 = i + 1;
                        long j = (long) bw.f1297c[Math.min(i, bw.f1297c.length - 1)];
                        C0326f.m2298h().mo511a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                            list = a3;
                        } catch (InterruptedException e3) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
                return;
            }
            C0326f.m2298h().mo511a("CrashlyticsCore", "User declined to send. Removing " + a.size() + " Report(s).");
            for (bv a22 : a) {
                a22.mo559a();
            }
        }
    }
}
