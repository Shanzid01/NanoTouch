package com.p019a.p020a.p023c;

import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ac implements Callable<Void> {
    final /* synthetic */ Map f1217a;
    final /* synthetic */ C0413z f1218b;

    ac(C0413z c0413z, Map map) {
        this.f1218b = c0413z;
        this.f1217a = map;
    }

    public /* synthetic */ Object call() {
        return m2551a();
    }

    public Void m2551a() {
        new bc(this.f1218b.f1385j).m2606a(this.f1218b.m2865j(), this.f1217a);
        return null;
    }
}
