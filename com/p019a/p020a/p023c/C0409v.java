package com.p019a.p020a.p023c;

import java.util.concurrent.Callable;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class C0409v implements Callable<T> {
    final /* synthetic */ Callable f1373a;
    final /* synthetic */ C0407t f1374b;

    C0409v(C0407t c0407t, Callable callable) {
        this.f1374b = c0407t;
        this.f1373a = callable;
    }

    public T call() {
        try {
            return this.f1373a.call();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }
}
