package com.p019a.p020a.p023c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.places.Place;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p023c.p024a.C0387a;
import com.p019a.p020a.p023c.p024a.p025a.C0383d;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0218q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0219r;
import p006b.p007a.p008a.p009a.p010a.p012b.C0222v;
import p006b.p007a.p008a.p009a.p010a.p013c.C0245n;
import p006b.p007a.p008a.p009a.p010a.p013c.C0248y;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0275b;
import p006b.p007a.p008a.p009a.p010a.p016e.C0287o;
import p006b.p007a.p008a.p009a.p010a.p017f.C0291b;
import p006b.p007a.p008a.p009a.p010a.p017f.C0292c;
import p006b.p007a.p008a.p009a.p010a.p017f.C0293d;
import p006b.p007a.p008a.p009a.p010a.p018g.C0310o;
import p006b.p007a.p008a.p009a.p010a.p018g.C0311p;
import p006b.p007a.p008a.p009a.p010a.p018g.C0312q;
import p006b.p007a.p008a.p009a.p010a.p018g.C0317w;

@C0245n(a = {C0387a.class})
/* compiled from: CrashlyticsCore */
public class C0395h extends C0337q<Void> {
    private final long f1333a;
    private final ConcurrentHashMap<String, String> f1334b;
    private File f1335c;
    private File f1336d;
    private C0410w f1337j;
    private C0413z f1338k;
    private String f1339l;
    private String f1340m;
    private String f1341n;
    private String f1342o;
    private String f1343p;
    private String f1344q;
    private String f1345r;
    private String f1346s;
    private float f1347t;
    private boolean f1348u;
    private final bs f1349v;
    private C0274m f1350w;
    private C0407t f1351x;
    private C0387a f1352y;

    protected /* synthetic */ Object mo532f() {
        return m2783c();
    }

    public C0395h() {
        this(TextTrackStyle.DEFAULT_FONT_SCALE, null, null, false);
    }

    C0395h(float f, C0410w c0410w, bs bsVar, boolean z) {
        this(f, c0410w, bsVar, z, C0222v.m1941a("Crashlytics Exception Handler"));
    }

    C0395h(float f, C0410w c0410w, bs bsVar, boolean z, ExecutorService executorService) {
        this.f1339l = null;
        this.f1340m = null;
        this.f1341n = null;
        this.f1334b = new ConcurrentHashMap();
        this.f1333a = System.currentTimeMillis();
        this.f1347t = f;
        this.f1337j = c0410w;
        this.f1349v = bsVar;
        this.f1348u = z;
        this.f1351x = new C0407t(executorService);
    }

    protected boolean a_() {
        return m2780a(super.m2334B());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m2780a(android.content.Context r9) {
        /*
        r8 = this;
        r7 = 0;
        r0 = r8.f1348u;
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        r0 = r7;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = new b.a.a.a.a.b.k;
        r0.<init>();
        r0 = r0.m1889a(r9);
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        r0 = r7;
        goto L_0x0006;
    L_0x0014:
        r1 = p006b.p007a.p008a.p009a.C0326f.m2298h();
        r2 = "CrashlyticsCore";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Initializing Crashlytics ";
        r3 = r3.append(r4);
        r4 = r8.mo529a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.mo515c(r2, r3);
        r1 = new java.io.File;
        r2 = r8.m2800u();
        r3 = "initialization_marker";
        r1.<init>(r2, r3);
        r8.f1336d = r1;
        r8.m2763a(r9, r0);	 Catch:{ x -> 0x00a7, Exception -> 0x00b1 }
        r5 = new com.a.a.c.bz;	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r0 = r8.m2334B();	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r1 = r8.f1342o;	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r2 = r8.m2787h();	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r5.<init>(r0, r1, r2);	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r0 = p006b.p007a.p008a.p009a.C0326f.m2298h();	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r1 = "CrashlyticsCore";
        r2 = "Installing exception handler...";
        r0.mo511a(r1, r2);	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r0 = new com.a.a.c.z;	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r2 = r8.f1337j;	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r3 = r8.f1351x;	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r4 = r8.m2333A();	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r6 = r8;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r8.f1338k = r0;	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r1 = r8.m2798s();	 Catch:{ Exception -> 0x0099, x -> 0x00a7 }
        r0 = r8.f1338k;	 Catch:{ Exception -> 0x00c0, x -> 0x00a7 }
        r0.m2877b();	 Catch:{ Exception -> 0x00c0, x -> 0x00a7 }
        r0 = r8.f1338k;	 Catch:{ Exception -> 0x00c0, x -> 0x00a7 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ Exception -> 0x00c0, x -> 0x00a7 }
        r0 = p006b.p007a.p008a.p009a.C0326f.m2298h();	 Catch:{ Exception -> 0x00c0, x -> 0x00a7 }
        r2 = "CrashlyticsCore";
        r3 = "Successfully installed exception handler.";
        r0.mo511a(r2, r3);	 Catch:{ Exception -> 0x00c0, x -> 0x00a7 }
    L_0x008b:
        if (r1 == 0) goto L_0x00ae;
    L_0x008d:
        r0 = p006b.p007a.p008a.p009a.p010a.p012b.C0214m.m1937n(r9);	 Catch:{ x -> 0x00a7, Exception -> 0x00b1 }
        if (r0 == 0) goto L_0x00ae;
    L_0x0093:
        r8.m2758G();	 Catch:{ x -> 0x00a7, Exception -> 0x00b1 }
        r0 = r7;
        goto L_0x0006;
    L_0x0099:
        r0 = move-exception;
        r1 = r7;
    L_0x009b:
        r2 = p006b.p007a.p008a.p009a.C0326f.m2298h();	 Catch:{ x -> 0x00a7, Exception -> 0x00b1 }
        r3 = "CrashlyticsCore";
        r4 = "There was a problem installing the exception handler.";
        r2.mo519e(r3, r4, r0);	 Catch:{ x -> 0x00a7, Exception -> 0x00b1 }
        goto L_0x008b;
    L_0x00a7:
        r0 = move-exception;
        r1 = new b.a.a.a.a.c.z;
        r1.<init>(r0);
        throw r1;
    L_0x00ae:
        r0 = 1;
        goto L_0x0006;
    L_0x00b1:
        r0 = move-exception;
        r1 = p006b.p007a.p008a.p009a.C0326f.m2298h();
        r2 = "CrashlyticsCore";
        r3 = "Crashlytics was not started due to an exception during initialization";
        r1.mo519e(r2, r3, r0);
        r0 = r7;
        goto L_0x0006;
    L_0x00c0:
        r0 = move-exception;
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.h.a(android.content.Context):boolean");
    }

    private void m2763a(Context context, String str) {
        C0287o c0412y = this.f1349v != null ? new C0412y(this.f1349v) : null;
        this.f1350w = new C0275b(C0326f.m2298h());
        this.f1350w.mo494a(c0412y);
        try {
            this.f1343p = context.getPackageName();
            this.f1344q = m2333A().m1965h();
            C0326f.m2298h().mo511a("CrashlyticsCore", "Installer package name is: " + this.f1344q);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f1343p, 0);
            this.f1345r = Integer.toString(packageInfo.versionCode);
            this.f1346s = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            this.f1342o = C0214m.m1936m(context);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Error setting up app properties", e);
        }
        m2333A().m1972o();
        m2773a(this.f1342o, m2767b(context)).m2548a(str, this.f1343p);
    }

    protected Void m2783c() {
        m2796q();
        this.f1338k.m2882g();
        Object obj = 1;
        try {
            C0317w b = C0312q.m2242a().m2246b();
            if (b == null) {
                C0326f.m2298h().mo516d("CrashlyticsCore", "Received null settings, skipping initialization!");
                m2797r();
                return null;
            }
            if (b.f984d.f957c) {
                obj = null;
                this.f1338k.m2878c();
                au a = m2774a(b);
                if (a != null) {
                    new bw(a).m2660a(this.f1347t);
                } else {
                    C0326f.m2298h().mo516d("CrashlyticsCore", "Unable to create a call to upload reports.");
                }
            }
            if (obj != null) {
                try {
                    C0326f.m2298h().mo511a("CrashlyticsCore", "Crash reporting disabled.");
                } catch (Throwable e) {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e);
                } finally {
                    m2797r();
                }
            }
            m2797r();
            return null;
        } catch (Throwable e2) {
            Throwable th = e2;
            Object obj2 = obj;
            C0326f.m2298h().mo519e("CrashlyticsCore", "Error dealing with settings", th);
            obj = obj2;
        }
    }

    public String mo531b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String mo529a() {
        return "2.3.5.79";
    }

    public static C0395h m2769e() {
        return (C0395h) C0326f.m2290a(C0395h.class);
    }

    public void m2778a(Throwable th) {
        if (this.f1348u || !C0395h.m2771f("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            C0326f.m2298h().mo510a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.f1338k.m2873a(Thread.currentThread(), th);
        }
    }

    public void m2776a(String str) {
        m2762a(3, "CrashlyticsCore", str);
    }

    private void m2762a(int i, String str, String str2) {
        if (!this.f1348u && C0395h.m2771f("prior to logging messages.")) {
            this.f1338k.m2871a(System.currentTimeMillis() - this.f1333a, C0395h.m2766b(i, str, str2));
        }
    }

    public void m2782b(String str) {
        if (!this.f1348u) {
            this.f1339l = C0395h.m2772g(str);
            this.f1338k.m2872a(this.f1339l, this.f1341n, this.f1340m);
        }
    }

    public void m2784c(String str) {
        if (!this.f1348u) {
            this.f1341n = C0395h.m2772g(str);
            this.f1338k.m2872a(this.f1339l, this.f1341n, this.f1340m);
        }
    }

    public void m2777a(String str, String str2) {
        if (!this.f1348u) {
            if (str != null) {
                String g = C0395h.m2772g(str);
                if (this.f1334b.size() < 64 || this.f1334b.containsKey(g)) {
                    this.f1334b.put(g, str2 == null ? "" : C0395h.m2772g(str2));
                    this.f1338k.m2874a(this.f1334b);
                    return;
                }
                C0326f.m2298h().mo511a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
            } else if (m2334B() == null || !C0214m.m1932i(m2334B())) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
            } else {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
        }
    }

    private void m2758G() {
        Callable c0396i = new C0396i(this);
        for (C0248y a : m2338F()) {
            c0396i.m2036a(a);
        }
        Future submit = m2335C().m2310f().submit(c0396i);
        C0326f.m2298h().mo511a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    static void m2768d(String str) {
        C0345b c0345b = (C0345b) C0326f.m2290a(C0345b.class);
        if (c0345b != null) {
            c0345b.m2430a(new C0219r(str));
        }
    }

    static void m2770e(String str) {
        C0345b c0345b = (C0345b) C0326f.m2290a(C0345b.class);
        if (c0345b != null) {
            c0345b.m2429a(new C0218q(str));
        }
    }

    Map<String, String> m2786g() {
        return Collections.unmodifiableMap(this.f1334b);
    }

    C0388a m2773a(String str, boolean z) {
        return new C0388a(str, z);
    }

    String m2787h() {
        return this.f1343p;
    }

    String m2788i() {
        return this.f1344q;
    }

    String m2789j() {
        return this.f1346s;
    }

    String m2790k() {
        return this.f1345r;
    }

    String m2791l() {
        return C0214m.m1921b(m2334B(), "com.crashlytics.ApiEndpoint");
    }

    C0413z m2792m() {
        return this.f1338k;
    }

    String m2793n() {
        return m2333A().m1958a() ? this.f1339l : null;
    }

    String m2794o() {
        return m2333A().m1958a() ? this.f1340m : null;
    }

    String m2795p() {
        return m2333A().m1958a() ? this.f1341n : null;
    }

    void m2796q() {
        this.f1351x.m2817a(new C0397j(this));
    }

    void m2797r() {
        this.f1351x.m2819b(new C0398k(this));
    }

    boolean m2798s() {
        return ((Boolean) this.f1351x.m2817a(new C0399l(this))).booleanValue();
    }

    C0383d m2799t() {
        if (this.f1352y != null) {
            return this.f1352y.m2547a();
        }
        return null;
    }

    File m2800u() {
        if (this.f1335c == null) {
            this.f1335c = new C0291b(this).mo499a();
        }
        return this.f1335c;
    }

    boolean m2801v() {
        return ((Boolean) C0312q.m2242a().m2245a(new C0400m(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean m2802w() {
        return new C0293d(this).mo500a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void m2779a(boolean z) {
        C0292c c0293d = new C0293d(this);
        c0293d.mo501a(c0293d.mo502b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean m2803x() {
        return ((Boolean) C0312q.m2242a().m2245a(new C0401n(this), Boolean.valueOf(true))).booleanValue();
    }

    au m2774a(C0317w c0317w) {
        if (c0317w != null) {
            return new av(this, m2791l(), c0317w.f981a.f942d, this.f1350w);
        }
        return null;
    }

    private boolean m2764a(Activity activity, C0310o c0310o) {
        aw awVar = new aw(activity, c0310o);
        C0406s c0406s = new C0406s();
        activity.runOnUiThread(new C0402o(this, activity, c0406s, awVar, c0310o));
        C0326f.m2298h().mo511a("CrashlyticsCore", "Waiting for user opt-in.");
        c0406s.m2816b();
        return c0406s.m2815a();
    }

    C0311p m2804y() {
        C0317w b = C0312q.m2242a().m2246b();
        return b == null ? null : b.f982b;
    }

    private boolean m2767b(Context context) {
        return C0214m.m1916a(context, "com.crashlytics.RequireBuildId", true);
    }

    private static String m2766b(int i, String str, String str2) {
        return C0214m.m1920b(i) + "/" + str + " " + str2;
    }

    private static boolean m2771f(String str) {
        C0395h e = C0395h.m2769e();
        if (e != null && e.f1338k != null) {
            return true;
        }
        C0326f.m2298h().mo519e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static String m2772g(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.length() > Place.TYPE_SUBLOCALITY_LEVEL_2) {
            return str.substring(0, Place.TYPE_SUBLOCALITY_LEVEL_2);
        }
        return str;
    }

    private int m2759a(float f, int i) {
        return (int) (((float) i) * f);
    }
}
