package com.p019a.p020a.p022b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0201a;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0277d;
import p006b.p007a.p008a.p009a.p010a.p016e.C0278e;

/* compiled from: CheckForUpdatesRequest */
class C0375g extends C0201a {
    private final C0377i f1173b;

    public C0375g(C0337q c0337q, String str, String str2, C0274m c0274m, C0377i c0377i) {
        super(c0337q, str, str2, c0274m, C0277d.GET);
        this.f1173b = c0377i;
    }

    public C0376h m2541a(String str, String str2, C0374f c0374f) {
        C0278e a;
        Throwable e;
        Throwable th;
        C0376h c0376h = null;
        try {
            Map a2 = m2540a(c0374f);
            try {
                a = m2539a(m1825a(a2), str, str2);
                C0326f.m2298h().mo511a("Beta", "Checking for updates from " + m1826a());
                C0326f.m2298h().mo511a("Beta", "Checking for updates query params are: " + a2);
                if (a.m2150c()) {
                    C0326f.m2298h().mo511a("Beta", "Checking for updates was successful");
                    c0376h = this.f1173b.m2542a(new JSONObject(a.m2155e()));
                    if (a != null) {
                        C0326f.m2298h().mo511a("Fabric", "Checking for updates request ID: " + a.m2146b("X-REQUEST-ID"));
                    }
                } else {
                    C0326f.m2298h().mo518e("Beta", "Checking for updates failed. Response code: " + a.m2144b());
                    if (a != null) {
                        C0326f.m2298h().mo511a("Fabric", "Checking for updates request ID: " + a.m2146b("X-REQUEST-ID"));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("Beta", "Error while checking for updates from " + m1826a(), e);
                    if (a != null) {
                        C0326f.m2298h().mo511a("Fabric", "Checking for updates request ID: " + a.m2146b("X-REQUEST-ID"));
                    }
                    return c0376h;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        C0326f.m2298h().mo511a("Fabric", "Checking for updates request ID: " + a.m2146b("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            C0326f.m2298h().mo519e("Beta", "Error while checking for updates from " + m1826a(), e);
            if (a != null) {
                C0326f.m2298h().mo511a("Fabric", "Checking for updates request ID: " + a.m2146b("X-REQUEST-ID"));
            }
            return c0376h;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                C0326f.m2298h().mo511a("Fabric", "Checking for updates request ID: " + a.m2146b("X-REQUEST-ID"));
            }
            throw th;
        }
        return c0376h;
    }

    private C0278e m2539a(C0278e c0278e, String str, String str2) {
        return c0278e.m2134a("Accept", "application/json").m2134a("User-Agent", "Crashlytics Android SDK/" + this.a.mo529a()).m2134a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").m2134a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m2134a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo529a()).m2134a("X-CRASHLYTICS-API-KEY", str).m2134a("X-CRASHLYTICS-D", str2);
    }

    private Map<String, String> m2540a(C0374f c0374f) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c0374f.f1169a);
        hashMap.put("display_version", c0374f.f1170b);
        hashMap.put("instance", c0374f.f1171c);
        hashMap.put("source", "3");
        return hashMap;
    }
}
