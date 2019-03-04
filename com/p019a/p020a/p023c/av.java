package com.p019a.p020a.p023c;

import java.util.Map.Entry;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0201a;
import p006b.p007a.p008a.p009a.p010a.p012b.ai;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0277d;
import p006b.p007a.p008a.p009a.p010a.p016e.C0278e;

/* compiled from: DefaultCreateReportSpiCall */
class av extends C0201a implements au {
    public av(C0337q c0337q, String str, String str2, C0274m c0274m) {
        super(c0337q, str, str2, c0274m, C0277d.POST);
    }

    public boolean mo550a(at atVar) {
        C0278e b = m2560b(m2559a(m1827b(), atVar), atVar);
        C0326f.m2298h().mo511a("CrashlyticsCore", "Sending report to: " + m1826a());
        int b2 = b.m2144b();
        C0326f.m2298h().mo511a("CrashlyticsCore", "Create report request ID: " + b.m2146b("X-REQUEST-ID"));
        C0326f.m2298h().mo511a("CrashlyticsCore", "Result was: " + b2);
        return ai.m1860a(b2) == 0;
    }

    private C0278e m2559a(C0278e c0278e, at atVar) {
        C0278e a = c0278e.m2134a("X-CRASHLYTICS-API-KEY", atVar.f1241a).m2134a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m2134a("X-CRASHLYTICS-API-CLIENT-VERSION", C0395h.m2769e().mo529a());
        C0278e c0278e2 = a;
        for (Entry a2 : atVar.f1242b.mo563e().entrySet()) {
            c0278e2 = c0278e2.m2140a(a2);
        }
        return c0278e2;
    }

    private C0278e m2560b(C0278e c0278e, at atVar) {
        bv bvVar = atVar.f1242b;
        return c0278e.m2137a("report[file]", bvVar.mo560b(), "application/octet-stream", bvVar.mo562d()).m2154e("report[identifier]", bvVar.mo561c());
    }
}
