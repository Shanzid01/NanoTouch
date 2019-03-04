package com.p019a.p020a.p023c;

import java.util.Date;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ap implements Runnable {
    final /* synthetic */ Date f1235a;
    final /* synthetic */ Thread f1236b;
    final /* synthetic */ Throwable f1237c;
    final /* synthetic */ C0413z f1238d;

    ap(C0413z c0413z, Date date, Thread thread, Throwable th) {
        this.f1238d = c0413z;
        this.f1235a = date;
        this.f1236b = thread;
        this.f1237c = th;
    }

    public void run() {
        if (!this.f1238d.f1386k.get()) {
            this.f1238d.m2855c(this.f1235a, this.f1236b, this.f1237c);
        }
    }
}
