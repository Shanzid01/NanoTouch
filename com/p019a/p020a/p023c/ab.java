package com.p019a.p020a.p023c;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ab implements Callable<Void> {
    final /* synthetic */ String f1213a;
    final /* synthetic */ String f1214b;
    final /* synthetic */ String f1215c;
    final /* synthetic */ C0413z f1216d;

    ab(C0413z c0413z, String str, String str2, String str3) {
        this.f1216d = c0413z;
        this.f1213a = str;
        this.f1214b = str2;
        this.f1215c = str3;
    }

    public /* synthetic */ Object call() {
        return m2550a();
    }

    public Void m2550a() {
        new bc(this.f1216d.f1385j).m2605a(this.f1216d.m2865j(), new cb(this.f1213a, this.f1214b, this.f1215c));
        return null;
    }
}
