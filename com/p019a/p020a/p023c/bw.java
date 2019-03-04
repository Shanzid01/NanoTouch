package com.p019a.p020a.p023c;

import com.facebook.AppEventsConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0213k;

/* compiled from: ReportUploader */
class bw {
    static final Map<String, String> f1295a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private static final FilenameFilter f1296b = new bx();
    private static final short[] f1297c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object f1298d = new Object();
    private final au f1299e;
    private Thread f1300f;

    public bw(au auVar) {
        if (auVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f1299e = auVar;
    }

    public synchronized void m2660a(float f) {
        if (this.f1300f == null) {
            this.f1300f = new Thread(new by(this, f), "Crashlytics Report Uploader");
            this.f1300f.start();
        }
    }

    boolean m2661a(bv bvVar) {
        boolean z = false;
        synchronized (this.f1298d) {
            try {
                boolean a = this.f1299e.mo550a(new at(new C0213k().m1889a(C0395h.m2769e().m2334B()), bvVar));
                C0326f.m2298h().mo515c("CrashlyticsCore", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + bvVar.mo560b());
                if (a) {
                    bvVar.mo559a();
                    z = true;
                }
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Error occurred sending report " + bvVar, e);
            }
        }
        return z;
    }

    List<bv> m2659a() {
        C0326f.m2298h().mo511a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f1298d) {
            File[] listFiles = C0395h.m2769e().m2800u().listFiles(f1296b);
        }
        List<bv> linkedList = new LinkedList();
        for (File file : listFiles) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Found crash report " + file.getPath());
            linkedList.add(new ca(file));
        }
        if (linkedList.isEmpty()) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
