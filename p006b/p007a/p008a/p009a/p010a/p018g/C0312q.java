package p006b.p007a.p008a.p009a.p010a.p018g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0213k;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0220t;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p012b.aj;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;

/* compiled from: Settings */
public class C0312q {
    private final AtomicReference<C0317w> f976a;
    private final CountDownLatch f977b;
    private C0303v f978c;
    private boolean f979d;

    public static C0312q m2242a() {
        return C0314s.f980a;
    }

    private C0312q() {
        this.f976a = new AtomicReference();
        this.f977b = new CountDownLatch(1);
        this.f979d = false;
    }

    public synchronized C0312q m2244a(C0337q c0337q, C0226z c0226z, C0274m c0274m, String str, String str2, String str3) {
        C0312q c0312q;
        if (this.f979d) {
            c0312q = this;
        } else {
            if (this.f978c == null) {
                Context B = c0337q.m2334B();
                String c = c0226z.m1960c();
                String a = new C0213k().m1889a(B);
                String h = c0226z.m1965h();
                aj ajVar = new aj();
                C0306k c0306k = new C0306k();
                C0302i c0302i = new C0302i(c0337q);
                String k = C0214m.m1934k(B);
                String str4 = str3;
                C0307l c0307l = new C0307l(c0337q, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), c0274m);
                h = str2;
                String str5 = str;
                this.f978c = new C0304j(c0337q, new C0319z(a, c0226z.m1957a(a, c), C0214m.m1907a(C0214m.m1936m(B)), h, str5, C0220t.determineFrom(h).getId(), k), ajVar, c0306k, c0302i, c0307l);
            }
            this.f979d = true;
            c0312q = this;
        }
        return c0312q;
    }

    public <T> T m2245a(C0315t<T> c0315t, T t) {
        C0317w c0317w = (C0317w) this.f976a.get();
        return c0317w == null ? t : c0315t.mo564b(c0317w);
    }

    public C0317w m2246b() {
        try {
            this.f977b.await();
            return (C0317w) this.f976a.get();
        } catch (InterruptedException e) {
            C0326f.m2298h().mo518e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean m2247c() {
        C0317w a;
        a = this.f978c.mo506a();
        m2243a(a);
        return a != null;
    }

    public synchronized boolean m2248d() {
        C0317w a;
        a = this.f978c.mo507a(C0316u.SKIP_CACHE_LOOKUP);
        m2243a(a);
        if (a == null) {
            C0326f.m2298h().mo519e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m2243a(C0317w c0317w) {
        this.f976a.set(c0317w);
        this.f977b.countDown();
    }
}
