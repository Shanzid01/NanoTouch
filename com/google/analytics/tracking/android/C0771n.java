package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: EasyTracker */
public class C0771n {
    private static C0771n f2059a;
    private boolean f2060b = false;
    private String f2061c;
    private String f2062d;
    private String f2063e;
    private int f2064f = 1800;
    private boolean f2065g;
    private Double f2066h;
    private boolean f2067i;
    private boolean f2068j;
    private UncaughtExceptionHandler f2069k;
    private boolean f2070l = false;
    private int f2071m = 0;
    private long f2072n;
    private long f2073o;
    private Context f2074p;
    private final Map<String, String> f2075q = new HashMap();
    private bm f2076r = null;
    private bc f2077s;
    private ao f2078t;
    private bi f2079u;
    private C0762l f2080v = new C0772o(this);
    private Timer f2081w;
    private TimerTask f2082x;
    private boolean f2083y = false;

    private C0771n() {
    }

    public static C0771n m3938a() {
        if (f2059a == null) {
            f2059a = new C0771n();
        }
        return f2059a;
    }

    public static bm m3940b() {
        if (C0771n.m3938a().f2074p != null) {
            return C0771n.m3938a().f2076r;
        }
        throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
    }

    boolean m3948c() {
        return this.f2072n == 0 || (this.f2072n > 0 && this.f2080v.mo1198a() > this.f2073o + this.f2072n);
    }

    private void m3942d() {
        boolean z = true;
        this.f2061c = this.f2077s.mo1192a("ga_trackingId");
        if (TextUtils.isEmpty(this.f2061c)) {
            this.f2061c = this.f2077s.mo1192a("ga_api_key");
            if (TextUtils.isEmpty(this.f2061c)) {
                av.m3816c("EasyTracker requested, but missing required ga_trackingId");
                this.f2076r = new C0773p(this);
                return;
            }
        }
        this.f2060b = true;
        this.f2062d = this.f2077s.mo1192a("ga_appName");
        this.f2063e = this.f2077s.mo1192a("ga_appVersion");
        this.f2065g = this.f2077s.mo1194c("ga_debug");
        this.f2066h = this.f2077s.mo1193b("ga_sampleFrequency");
        if (this.f2066h == null) {
            this.f2066h = new Double((double) this.f2077s.mo1191a("ga_sampleRate", 100));
        }
        this.f2064f = this.f2077s.mo1191a("ga_dispatchPeriod", 1800);
        this.f2072n = (long) (this.f2077s.mo1191a("ga_sessionTimeout", 30) * 1000);
        if (!(this.f2077s.mo1194c("ga_autoActivityTracking") || this.f2077s.mo1194c("ga_auto_activity_tracking"))) {
            z = false;
        }
        this.f2070l = z;
        this.f2067i = this.f2077s.mo1194c("ga_anonymizeIp");
        this.f2068j = this.f2077s.mo1194c("ga_reportUncaughtExceptions");
        this.f2076r = this.f2078t.m3795a(this.f2061c);
        if (!TextUtils.isEmpty(this.f2062d)) {
            av.m3817d("setting appName to " + this.f2062d);
            this.f2076r.mo1209a(this.f2062d);
        }
        if (this.f2063e != null) {
            this.f2076r.mo1213b(this.f2063e);
        }
        this.f2076r.mo1214b(this.f2067i);
        this.f2076r.mo1207a(this.f2066h.doubleValue());
        this.f2078t.m3797a(this.f2065g);
        this.f2079u.mo1216a(this.f2064f);
        if (this.f2068j) {
            UncaughtExceptionHandler uncaughtExceptionHandler = this.f2069k;
            if (uncaughtExceptionHandler == null) {
                uncaughtExceptionHandler = new C0775s(this.f2076r, this.f2079u, Thread.getDefaultUncaughtExceptionHandler());
            }
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public void m3945a(Context context) {
        if (context == null) {
            av.m3816c("Context cannot be null");
            return;
        }
        m3946a(context, new bd(context.getApplicationContext()), ao.m3792a(context.getApplicationContext()), C0778v.m3961a());
    }

    @VisibleForTesting
    void m3946a(Context context, bc bcVar, ao aoVar, bi biVar) {
        if (context == null) {
            av.m3816c("Context cannot be null");
        }
        if (this.f2074p == null) {
            this.f2074p = context.getApplicationContext();
            this.f2078t = aoVar;
            this.f2079u = biVar;
            this.f2077s = bcVar;
            m3942d();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3944a(android.app.Activity r3) {
        /*
        r2 = this;
        r1 = 1;
        r2.m3945a(r3);
        r0 = r2.f2060b;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r2.m3943e();
        r0 = r2.f2083y;
        if (r0 != 0) goto L_0x0023;
    L_0x0010:
        r0 = r2.f2071m;
        if (r0 != 0) goto L_0x0023;
    L_0x0014:
        r0 = r2.m3948c();
        if (r0 == 0) goto L_0x0023;
    L_0x001a:
        r0 = r2.f2076r;
        r0.mo1211a(r1);
        r0 = r2.f2070l;
        if (r0 != 0) goto L_0x0023;
    L_0x0023:
        r2.f2083y = r1;
        r0 = r2.f2071m;
        r0 = r0 + 1;
        r2.f2071m = r0;
        r0 = r2.f2070l;
        if (r0 == 0) goto L_0x0008;
    L_0x002f:
        r0 = r2.f2076r;
        r1 = r2.m3941c(r3);
        r0.mo1215c(r1);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.n.a(android.app.Activity):void");
    }

    public void m3947b(Activity activity) {
        m3945a((Context) activity);
        if (this.f2060b) {
            this.f2071m--;
            this.f2071m = Math.max(0, this.f2071m);
            this.f2073o = this.f2080v.mo1198a();
            if (this.f2071m == 0) {
                m3943e();
                this.f2082x = new C0774q();
                this.f2081w = new Timer("waitForActivityStart");
                this.f2081w.schedule(this.f2082x, 1000);
            }
        }
    }

    private synchronized void m3943e() {
        if (this.f2081w != null) {
            this.f2081w.cancel();
            this.f2081w = null;
        }
    }

    private String m3941c(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        if (this.f2075q.containsKey(canonicalName)) {
            return (String) this.f2075q.get(canonicalName);
        }
        String a = this.f2077s.mo1192a(canonicalName);
        if (a == null) {
            a = canonicalName;
        }
        this.f2075q.put(canonicalName, a);
        return a;
    }
}
