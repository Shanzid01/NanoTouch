package com.p019a.p020a.p023c;

import java.util.Date;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class an implements Callable<Void> {
    final /* synthetic */ Date f1228a;
    final /* synthetic */ Thread f1229b;
    final /* synthetic */ Throwable f1230c;
    final /* synthetic */ C0413z f1231d;

    an(C0413z c0413z, Date date, Thread thread, Throwable th) {
        this.f1231d = c0413z;
        this.f1228a = date;
        this.f1229b = thread;
        this.f1230c = th;
    }

    public /* synthetic */ Object call() {
        return m2556a();
    }

    public Void m2556a() {
        this.f1231d.m2842a(this.f1228a, this.f1229b, this.f1230c);
        return null;
    }
}
