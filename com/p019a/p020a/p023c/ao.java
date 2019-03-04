package com.p019a.p020a.p023c;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ao implements Callable<Void> {
    final /* synthetic */ long f1232a;
    final /* synthetic */ String f1233b;
    final /* synthetic */ C0413z f1234c;

    ao(C0413z c0413z, long j, String str) {
        this.f1234c = c0413z;
        this.f1232a = j;
        this.f1233b = str;
    }

    public /* synthetic */ Object call() {
        return m2557a();
    }

    public Void m2557a() {
        if (!this.f1234c.f1386k.get()) {
            this.f1234c.f1393r.m2583a(this.f1232a, this.f1233b);
        }
        return null;
    }
}
