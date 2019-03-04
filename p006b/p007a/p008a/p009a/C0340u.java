package p006b.p007a.p008a.p009a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.AppEventsConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p006b.p007a.p008a.p009a.p010a.p012b.C0213k;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0220t;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0275b;
import p006b.p007a.p008a.p009a.p010a.p018g.C0297d;
import p006b.p007a.p008a.p009a.p010a.p018g.C0298e;
import p006b.p007a.p008a.p009a.p010a.p018g.C0301h;
import p006b.p007a.p008a.p009a.p010a.p018g.C0309n;
import p006b.p007a.p008a.p009a.p010a.p018g.C0312q;
import p006b.p007a.p008a.p009a.p010a.p018g.C0317w;
import p006b.p007a.p008a.p009a.p010a.p018g.ab;

/* compiled from: Onboarding */
class C0340u extends C0337q<Boolean> {
    private final C0274m f1045a = new C0275b();
    private PackageManager f1046b;
    private String f1047c;
    private PackageInfo f1048d;
    private String f1049j;
    private String f1050k;
    private String f1051l;
    private String f1052m;
    private String f1053n;
    private final Future<Map<String, C0339s>> f1054o;
    private final Collection<C0337q> f1055p;

    protected /* synthetic */ Object mo532f() {
        return m2361c();
    }

    public C0340u(Future<Map<String, C0339s>> future, Collection<C0337q> collection) {
        this.f1054o = future;
        this.f1055p = collection;
    }

    public String mo529a() {
        return "1.3.6.79";
    }

    protected boolean a_() {
        try {
            this.f1051l = m2333A().m1965h();
            this.f1046b = m2334B().getPackageManager();
            this.f1047c = m2334B().getPackageName();
            this.f1048d = this.f1046b.getPackageInfo(this.f1047c, 0);
            this.f1049j = Integer.toString(this.f1048d.versionCode);
            this.f1050k = this.f1048d.versionName == null ? "0.0" : this.f1048d.versionName;
            this.f1052m = this.f1046b.getApplicationLabel(m2334B().getApplicationInfo()).toString();
            this.f1053n = Integer.toString(m2334B().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean m2361c() {
        boolean a;
        String k = C0214m.m1934k(m2334B());
        C0317w g = m2357g();
        if (g != null) {
            try {
                Map map;
                if (this.f1054o != null) {
                    map = (Map) this.f1054o.get();
                } else {
                    map = new HashMap();
                }
                a = m2354a(k, g.f981a, m2359a(map, this.f1055p).values());
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private C0317w m2357g() {
        try {
            C0312q.m2242a().m2244a(this, this.i, this.f1045a, this.f1049j, this.f1050k, m2362e()).m2247c();
            return C0312q.m2242a().m2246b();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, C0339s> m2359a(Map<String, C0339s> map, Collection<C0337q> collection) {
        for (C0337q c0337q : collection) {
            if (!map.containsKey(c0337q.mo531b())) {
                map.put(c0337q.mo531b(), new C0339s(c0337q.mo531b(), c0337q.mo529a(), "binary"));
            }
        }
        return map;
    }

    public String mo531b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m2354a(String str, C0298e c0298e, Collection<C0339s> collection) {
        if ("new".equals(c0298e.f940b)) {
            if (m2355b(str, c0298e, collection)) {
                return C0312q.m2242a().m2248d();
            }
            C0326f.m2298h().mo519e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(c0298e.f940b)) {
            return C0312q.m2242a().m2248d();
        } else {
            if (!c0298e.f943e) {
                return true;
            }
            C0326f.m2298h().mo511a("Fabric", "Server says an update is required - forcing a full App update.");
            m2356c(str, c0298e, collection);
            return true;
        }
    }

    private boolean m2355b(String str, C0298e c0298e, Collection<C0339s> collection) {
        return new C0301h(this, m2362e(), c0298e.f941c, this.f1045a).mo503a(m2352a(C0309n.m2241a(m2334B(), str), (Collection) collection));
    }

    private boolean m2356c(String str, C0298e c0298e, Collection<C0339s> collection) {
        return m2353a(c0298e, C0309n.m2241a(m2334B(), str), (Collection) collection);
    }

    private boolean m2353a(C0298e c0298e, C0309n c0309n, Collection<C0339s> collection) {
        return new ab(this, m2362e(), c0298e.f941c, this.f1045a).mo503a(m2352a(c0309n, (Collection) collection));
    }

    private C0297d m2352a(C0309n c0309n, Collection<C0339s> collection) {
        return new C0297d(new C0213k().m1889a(m2334B()), m2333A().m1960c(), this.f1050k, this.f1049j, C0214m.m1907a(C0214m.m1936m(r0)), this.f1052m, C0220t.determineFrom(this.f1051l).getId(), this.f1053n, AppEventsConstants.EVENT_PARAM_VALUE_NO, c0309n, collection);
    }

    String m2362e() {
        return C0214m.m1921b(m2334B(), "com.crashlytics.ApiEndpoint");
    }
}
