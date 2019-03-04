package com.p019a.p020a.p021a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import java.io.File;
import p006b.p007a.p008a.p009a.C0320a;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0218q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0219r;
import p006b.p007a.p008a.p009a.p010a.p016e.C0275b;
import p006b.p007a.p008a.p009a.p010a.p017f.C0291b;
import p006b.p007a.p008a.p009a.p010a.p017f.C0293d;
import p006b.p007a.p008a.p009a.p010a.p018g.C0312q;
import p006b.p007a.p008a.p009a.p010a.p018g.C0317w;

/* compiled from: Answers */
public class C0345b extends C0337q<Boolean> {
    C0356n f1101a;
    ag f1102b;
    C0320a f1103c;
    private String f1104d;
    private String f1105j;
    private long f1106k;

    protected /* synthetic */ Object mo532f() {
        return m2444e();
    }

    public static C0345b m2427c() {
        return (C0345b) C0326f.m2290a(C0345b.class);
    }

    public void m2437a(C0359q c0359q) {
        if (c0359q == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2390a(c0359q);
        }
    }

    public void m2439a(C0364x c0364x) {
        if (c0364x == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) c0364x);
        }
    }

    public void m2438a(C0363v c0363v) {
        if (c0363v == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) c0363v);
        }
    }

    public void m2433a(ap apVar) {
        if (apVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) apVar);
        }
    }

    public void m2434a(aq aqVar) {
        if (aqVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) aqVar);
        }
    }

    public void m2431a(C0343a c0343a) {
        if (c0343a == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) c0343a);
        }
    }

    public void m2435a(ar arVar) {
        if (arVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) arVar);
        }
    }

    public void m2440a(C0366z c0366z) {
        if (c0366z == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) c0366z);
        }
    }

    public void m2436a(C0358p c0358p) {
        if (c0358p == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) c0358p);
        }
    }

    public void m2432a(ad adVar) {
        if (adVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f1102b != null) {
            this.f1102b.m2391a((C0342w) adVar);
        }
    }

    public void m2430a(C0219r c0219r) {
        if (this.f1102b != null) {
            this.f1102b.m2394b(c0219r.m1939a());
        }
    }

    public void m2429a(C0218q c0218q) {
        if (this.f1102b != null) {
            this.f1102b.m2392a(c0218q.m1939a());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean a_() {
        try {
            Context B = m2334B();
            this.f1101a = new C0356n(new C0293d(B, "settings"));
            this.f1103c = new C0320a(B);
            PackageInfo packageInfo = B.getPackageManager().getPackageInfo(B.getPackageName(), 0);
            this.f1104d = Integer.toString(packageInfo.versionCode);
            this.f1105j = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                this.f1106k = packageInfo.firstInstallTime;
            } else {
                this.f1106k = new File(B.getPackageManager().getApplicationInfo(B.getPackageName(), 0).sourceDir).lastModified();
            }
            m2426a(B);
            return true;
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean m2444e() {
        try {
            C0317w b = C0312q.m2242a().m2246b();
            if (b == null) {
                C0326f.m2298h().mo518e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f984d.f958d) {
                C0326f.m2298h().mo511a("Answers", "Analytics collection enabled");
                this.f1102b.m2389a(b.f985e, m2446g());
                return Boolean.valueOf(true);
            } else {
                C0326f.m2298h().mo511a("Answers", "Analytics collection disabled");
                this.f1103c.m2252a();
                this.f1102b.m2393b();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String mo531b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String mo529a() {
        return "1.3.2.79";
    }

    private void m2426a(Context context) {
        try {
            ao aoVar = new ao(context, m2333A(), this.f1104d, this.f1105j);
            C0348f c0348f = new C0348f(this, context, new C0354l(context, new C0291b(this)), aoVar, new C0275b(C0326f.m2298h()));
            c0348f.m2466b();
            this.f1102b = new ag(c0348f);
            this.f1103c.m2253a(new C0355m(this.f1102b));
            if (m2441a(this.f1106k)) {
                C0326f.m2298h().mo511a("Answers", "New app install detected");
                this.f1102b.m2387a();
                this.f1101a.m2477a();
            }
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to initialize", e);
        }
    }

    String m2446g() {
        return C0214m.m1921b(m2334B(), "com.crashlytics.ApiEndpoint");
    }

    boolean m2441a(long j) {
        return !this.f1101a.m2478b() && m2443b(j);
    }

    boolean m2443b(long j) {
        return System.currentTimeMillis() - j < 3600000;
    }
}
