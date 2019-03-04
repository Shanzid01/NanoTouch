package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.PlusShare;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: Tracker */
public class bm {
    private static final DecimalFormat f2042a = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
    private final bp f2043b;
    private final bo f2044c;
    private volatile boolean f2045d;
    private volatile boolean f2046e;
    private long f2047f;
    private long f2048g;
    private boolean f2049h;

    bm() {
        this.f2045d = false;
        this.f2046e = false;
        this.f2047f = 120000;
        this.f2049h = true;
        this.f2043b = null;
        this.f2044c = null;
    }

    bm(String str, bp bpVar) {
        this.f2045d = false;
        this.f2046e = false;
        this.f2047f = 120000;
        this.f2049h = true;
        if (str == null) {
            throw new IllegalArgumentException("trackingId cannot be null");
        }
        this.f2043b = bpVar;
        this.f2044c = new bo();
        this.f2044c.m3906b("trackingId", str);
        this.f2044c.m3906b("sampleRate", "100");
        this.f2044c.m3903a("sessionControl", "start");
        this.f2044c.m3906b("useSecure", Boolean.toString(true));
    }

    private void m3891b() {
        if (this.f2045d) {
            throw new IllegalStateException("Tracker closed");
        }
    }

    public void mo1211a(boolean z) {
        m3891b();
        am.m3786a().m3787a(an.SET_START_SESSION);
        this.f2044c.m3903a("sessionControl", z ? "start" : null);
    }

    public void mo1209a(String str) {
        if (this.f2046e) {
            av.m3822i("Tracking already started, setAppName call ignored");
        } else if (TextUtils.isEmpty(str)) {
            av.m3822i("setting appName to empty value not allowed, call ignored");
        } else {
            am.m3786a().m3787a(an.SET_APP_NAME);
            this.f2044c.m3906b("appName", str);
        }
    }

    public void mo1213b(String str) {
        if (this.f2046e) {
            av.m3822i("Tracking already started, setAppVersion call ignored");
            return;
        }
        am.m3786a().m3787a(an.SET_APP_VERSION);
        this.f2044c.m3906b("appVersion", str);
    }

    public void mo1215c(String str) {
        m3891b();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("trackView requires a appScreen to be set");
        }
        am.m3786a().m3787a(an.TRACK_VIEW_WITH_APPSCREEN);
        this.f2044c.m3906b(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str);
        m3890a("appview", null);
    }

    public void mo1210a(String str, boolean z) {
        m3891b();
        am.m3786a().m3787a(an.TRACK_EXCEPTION_WITH_DESCRIPTION);
        am.m3786a().m3788a(true);
        m3890a("exception", mo1212b(str, z));
        am.m3786a().m3788a(false);
    }

    private void m3890a(String str, Map<String, String> map) {
        Map hashMap;
        this.f2046e = true;
        if (map == null) {
            hashMap = new HashMap();
        }
        hashMap.put("hitType", str);
        this.f2044c.m3904a(hashMap, Boolean.valueOf(true));
        if (m3897a()) {
            this.f2043b.mo1187a(this.f2044c.m3905b());
        } else {
            av.m3822i("Too many hits sent too quickly, throttling invoked.");
        }
        this.f2044c.m3902a();
    }

    public void mo1214b(boolean z) {
        am.m3786a().m3787a(an.SET_ANONYMIZE_IP);
        this.f2044c.m3906b("anonymizeIp", Boolean.toString(z));
    }

    public void mo1207a(double d) {
        am.m3786a().m3787a(an.SET_SAMPLE_RATE);
        this.f2044c.m3906b("sampleRate", Double.toString(d));
    }

    public void mo1208a(int i, String str) {
        if (i < 1) {
            av.m3821h("index must be > 0, ignoring setCustomDimension call for " + i + ", " + str);
        } else {
            this.f2044c.m3903a(bq.m3908a("customDimension", i), str);
        }
    }

    public Map<String, String> mo1212b(String str, boolean z) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("exDescription", str);
        hashMap.put("exFatal", Boolean.toString(z));
        am.m3786a().m3787a(an.CONSTRUCT_EXCEPTION);
        return hashMap;
    }

    @VisibleForTesting
    synchronized boolean m3897a() {
        boolean z = true;
        synchronized (this) {
            if (this.f2049h) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f2047f < 120000) {
                    long j = currentTimeMillis - this.f2048g;
                    if (j > 0) {
                        this.f2047f = Math.min(120000, j + this.f2047f);
                    }
                }
                this.f2048g = currentTimeMillis;
                if (this.f2047f >= 2000) {
                    this.f2047f -= 2000;
                } else {
                    av.m3822i("Excessive tracking detected.  Tracking call ignored.");
                    z = false;
                }
            }
        }
        return z;
    }
}
