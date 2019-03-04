package p006b.p007a.p008a.p009a.p010a.p018g;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0201a;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0277d;
import p006b.p007a.p008a.p009a.p010a.p016e.C0278e;

/* compiled from: DefaultSettingsSpiCall */
class C0307l extends C0201a implements aa {
    public C0307l(C0337q c0337q, String str, String str2, C0274m c0274m) {
        this(c0337q, str, str2, c0274m, C0277d.GET);
    }

    C0307l(C0337q c0337q, String str, String str2, C0274m c0274m, C0277d c0277d) {
        super(c0337q, str, str2, c0274m, c0277d);
    }

    public JSONObject mo509a(C0319z c0319z) {
        C0278e c0278e = null;
        try {
            Map b = m2237b(c0319z);
            c0278e = m2235a(m1825a(b), c0319z);
            C0326f.m2298h().mo511a("Fabric", "Requesting settings from " + m1826a());
            C0326f.m2298h().mo511a("Fabric", "Settings query params were: " + b);
            JSONObject a = m2238a(c0278e);
            return a;
        } finally {
            if (c0278e != null) {
                C0326f.m2298h().mo511a("Fabric", "Settings request ID: " + c0278e.m2146b("X-REQUEST-ID"));
            }
        }
    }

    JSONObject m2238a(C0278e c0278e) {
        int b = c0278e.m2144b();
        C0326f.m2298h().mo511a("Fabric", "Settings result was: " + b);
        if (m2240a(b)) {
            return m2236a(c0278e.m2155e());
        }
        C0326f.m2298h().mo518e("Fabric", "Failed to retrieve settings from " + m1826a());
        return null;
    }

    boolean m2240a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    private JSONObject m2236a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            C0326f.m2298h().mo512a("Fabric", "Failed to parse settings JSON from " + m1826a(), e);
            C0326f.m2298h().mo511a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m2237b(C0319z c0319z) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c0319z.f995e);
        hashMap.put("display_version", c0319z.f994d);
        hashMap.put("source", Integer.toString(c0319z.f996f));
        if (c0319z.f997g != null) {
            hashMap.put("icon_hash", c0319z.f997g);
        }
        String str = c0319z.f993c;
        if (!C0214m.m1926c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private C0278e m2235a(C0278e c0278e, C0319z c0319z) {
        return c0278e.m2134a("X-CRASHLYTICS-API-KEY", c0319z.f991a).m2134a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m2134a("X-CRASHLYTICS-D", c0319z.f992b).m2134a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo529a()).m2134a("Accept", "application/json");
    }
}
