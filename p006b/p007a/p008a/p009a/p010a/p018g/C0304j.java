package p006b.p007a.p008a.p009a.p010a.p018g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0202s;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p017f.C0292c;
import p006b.p007a.p008a.p009a.p010a.p017f.C0293d;

/* compiled from: DefaultSettingsController */
class C0304j implements C0303v {
    private final C0319z f948a;
    private final C0305y f949b;
    private final C0202s f950c;
    private final C0300g f951d;
    private final aa f952e;
    private final C0337q f953f;
    private final C0292c f954g = new C0293d(this.f953f);

    public C0304j(C0337q c0337q, C0319z c0319z, C0202s c0202s, C0305y c0305y, C0300g c0300g, aa aaVar) {
        this.f953f = c0337q;
        this.f948a = c0319z;
        this.f950c = c0202s;
        this.f949b = c0305y;
        this.f951d = c0300g;
        this.f952e = aaVar;
    }

    public C0317w mo506a() {
        return mo507a(C0316u.USE_CACHE);
    }

    public C0317w mo507a(C0316u c0316u) {
        Throwable th;
        C0317w c0317w;
        Throwable th2;
        C0317w c0317w2 = null;
        try {
            if (!(C0326f.m2299i() || m2224d())) {
                c0317w2 = m2218b(c0316u);
            }
            if (c0317w2 == null) {
                try {
                    JSONObject a = this.f952e.mo509a(this.f948a);
                    if (a != null) {
                        c0317w2 = this.f949b.mo508a(this.f950c, a);
                        this.f951d.mo505a(c0317w2.f987g, a);
                        m2217a(a, "Loaded settings: ");
                        m2221a(m2222b());
                    }
                } catch (Throwable e) {
                    th = e;
                    c0317w = c0317w2;
                    th2 = th;
                    C0326f.m2298h().mo519e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c0317w;
                }
            }
            c0317w = c0317w2;
            if (c0317w == null) {
                try {
                    c0317w = m2218b(C0316u.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    C0326f.m2298h().mo519e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c0317w;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            c0317w = null;
            th2 = th;
            C0326f.m2298h().mo519e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return c0317w;
        }
        return c0317w;
    }

    private C0317w m2218b(C0316u c0316u) {
        Throwable th;
        C0317w c0317w = null;
        try {
            if (C0316u.SKIP_CACHE_LOOKUP.equals(c0316u)) {
                return null;
            }
            JSONObject a = this.f951d.mo504a();
            if (a != null) {
                C0317w a2 = this.f949b.mo508a(this.f950c, a);
                if (a2 != null) {
                    m2217a(a, "Loaded cached settings: ");
                    long a3 = this.f950c.mo466a();
                    if (C0316u.IGNORE_CACHE_EXPIRATION.equals(c0316u) || !a2.m2251a(a3)) {
                        try {
                            C0326f.m2298h().mo511a("Fabric", "Returning cached settings.");
                            return a2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            c0317w = a2;
                            th = th2;
                            C0326f.m2298h().mo519e("Fabric", "Failed to get cached settings", th);
                            return c0317w;
                        }
                    }
                    C0326f.m2298h().mo511a("Fabric", "Cached settings have expired.");
                    return null;
                }
                C0326f.m2298h().mo519e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            C0326f.m2298h().mo511a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            C0326f.m2298h().mo519e("Fabric", "Failed to get cached settings", th);
            return c0317w;
        }
    }

    private void m2217a(JSONObject jSONObject, String str) {
        C0326f.m2298h().mo511a("Fabric", str + jSONObject.toString());
    }

    String m2222b() {
        return C0214m.m1907a(C0214m.m1936m(this.f953f.m2334B()));
    }

    String m2223c() {
        return this.f954g.mo500a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean m2221a(String str) {
        Editor b = this.f954g.mo502b();
        b.putString("existing_instance_identifier", str);
        return this.f954g.mo501a(b);
    }

    boolean m2224d() {
        return !m2223c().equals(m2222b());
    }
}
