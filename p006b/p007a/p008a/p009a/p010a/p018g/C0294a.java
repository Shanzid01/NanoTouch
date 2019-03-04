package p006b.p007a.p008a.p009a.p010a.p018g;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.C0339s;
import p006b.p007a.p008a.p009a.p010a.p012b.C0201a;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.ai;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0277d;
import p006b.p007a.p008a.p009a.p010a.p016e.C0278e;

/* compiled from: AbstractAppSpiCall */
abstract class C0294a extends C0201a {
    public C0294a(C0337q c0337q, String str, String str2, C0274m c0274m, C0277d c0277d) {
        super(c0337q, str, str2, c0274m, c0277d);
    }

    public boolean mo503a(C0297d c0297d) {
        C0278e b = m2204b(m2203a(m1827b(), c0297d), c0297d);
        C0326f.m2298h().mo511a("Fabric", "Sending app info to " + m1826a());
        if (c0297d.f937j != null) {
            C0326f.m2298h().mo511a("Fabric", "App icon hash is " + c0297d.f937j.f959a);
            C0326f.m2298h().mo511a("Fabric", "App icon size is " + c0297d.f937j.f961c + "x" + c0297d.f937j.f962d);
        }
        int b2 = b.m2144b();
        C0326f.m2298h().mo511a("Fabric", ("POST".equals(b.m2168p()) ? "Create" : "Update") + " app request ID: " + b.m2146b("X-REQUEST-ID"));
        C0326f.m2298h().mo511a("Fabric", "Result was " + b2);
        if (ai.m1860a(b2) == 0) {
            return true;
        }
        return false;
    }

    private C0278e m2203a(C0278e c0278e, C0297d c0297d) {
        return c0278e.m2134a("X-CRASHLYTICS-API-KEY", c0297d.f928a).m2134a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m2134a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo529a());
    }

    private C0278e m2204b(C0278e c0278e, C0297d c0297d) {
        C0278e e = c0278e.m2154e("app[identifier]", c0297d.f929b).m2154e("app[name]", c0297d.f933f).m2154e("app[display_version]", c0297d.f930c).m2154e("app[build_version]", c0297d.f931d).m2133a("app[source]", Integer.valueOf(c0297d.f934g)).m2154e("app[minimum_sdk_version]", c0297d.f935h).m2154e("app[built_sdk_version]", c0297d.f936i);
        if (!C0214m.m1926c(c0297d.f932e)) {
            e.m2154e("app[instance_identifier]", c0297d.f932e);
        }
        if (c0297d.f937j != null) {
            Closeable closeable = null;
            try {
                closeable = this.a.m2334B().getResources().openRawResource(c0297d.f937j.f960b);
                e.m2154e("app[icon][hash]", c0297d.f937j.f959a).m2138a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) closeable).m2133a("app[icon][width]", Integer.valueOf(c0297d.f937j.f961c)).m2133a("app[icon][height]", Integer.valueOf(c0297d.f937j.f962d));
            } catch (Throwable e2) {
                C0326f.m2298h().mo519e("Fabric", "Failed to find app icon with resource ID: " + c0297d.f937j.f960b, e2);
            } finally {
                String str = "Failed to close app icon InputStream.";
                C0214m.m1913a(closeable, str);
            }
        }
        if (c0297d.f938k != null) {
            for (C0339s c0339s : c0297d.f938k) {
                e.m2154e(m2205a(c0339s), c0339s.m2350b());
                e.m2154e(m2207b(c0339s), c0339s.m2351c());
            }
        }
        return e;
    }

    String m2205a(C0339s c0339s) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{c0339s.m2349a()});
    }

    String m2207b(C0339s c0339s) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{c0339s.m2349a()});
    }
}
