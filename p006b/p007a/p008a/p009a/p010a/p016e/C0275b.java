package p006b.p007a.p008a.p009a.p010a.p016e;

import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p006b.p007a.p008a.p009a.C0324t;
import p006b.p007a.p008a.p009a.C0325e;

/* compiled from: DefaultHttpRequestFactory */
public class C0275b implements C0274m {
    private final C0324t f880a;
    private C0287o f881b;
    private SSLSocketFactory f882c;
    private boolean f883d;

    public C0275b() {
        this(new C0325e());
    }

    public C0275b(C0324t c0324t) {
        this.f880a = c0324t;
    }

    public void mo494a(C0287o c0287o) {
        if (this.f881b != c0287o) {
            this.f881b = c0287o;
            m2109a();
        }
    }

    private synchronized void m2109a() {
        this.f883d = false;
        this.f882c = null;
    }

    public C0278e mo493a(C0277d c0277d, String str, Map<String, String> map) {
        C0278e a;
        switch (C0276c.f884a[c0277d.ordinal()]) {
            case 1:
                a = C0278e.m2116a((CharSequence) str, (Map) map, true);
                break;
            case 2:
                a = C0278e.m2121b((CharSequence) str, (Map) map, true);
                break;
            case 3:
                a = C0278e.m2124d((CharSequence) str);
                break;
            case 4:
                a = C0278e.m2125e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m2110a(str) && this.f881b != null) {
            SSLSocketFactory b = m2111b();
            if (b != null) {
                ((HttpsURLConnection) a.m2143a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    private boolean m2110a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory m2111b() {
        if (this.f882c == null && !this.f883d) {
            this.f882c = m2112c();
        }
        return this.f882c;
    }

    private synchronized SSLSocketFactory m2112c() {
        SSLSocketFactory a;
        this.f883d = true;
        try {
            a = C0286n.m2180a(this.f881b);
            this.f880a.mo511a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f880a.mo519e("Fabric", "Exception while validating pinned certs", e);
            a = null;
        }
        return a;
    }
}
