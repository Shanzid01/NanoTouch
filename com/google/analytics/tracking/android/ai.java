package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: GAThread */
class ai implements Runnable {
    final /* synthetic */ Map f1985a;
    final /* synthetic */ long f1986b;
    final /* synthetic */ ah f1987c;

    ai(ah ahVar, Map map, long j) {
        this.f1987c = ahVar;
        this.f1985a = map;
        this.f1986b = j;
    }

    public void run() {
        this.f1985a.put("clientId", this.f1987c.f1982h);
        if (!this.f1987c.f1978d && !this.f1987c.m3770d(this.f1985a)) {
            if (!TextUtils.isEmpty(this.f1987c.f1981g)) {
                this.f1985a.put("campaign", this.f1987c.f1981g);
                this.f1987c.f1981g = null;
            }
            this.f1987c.m3774e(this.f1985a);
            this.f1987c.m3776f(this.f1985a);
            this.f1987c.m3767c(this.f1985a);
            this.f1987c.f1983j.mo1222a(at.m3810a(this.f1987c.f1980f, this.f1985a), this.f1986b, this.f1987c.m3762b(this.f1985a), this.f1987c.f1979e);
        }
    }
}
