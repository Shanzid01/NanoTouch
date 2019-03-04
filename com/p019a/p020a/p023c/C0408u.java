package com.p019a.p020a.p023c;

import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class C0408u implements Runnable {
    final /* synthetic */ Runnable f1371a;
    final /* synthetic */ C0407t f1372b;

    C0408u(C0407t c0407t, Runnable runnable) {
        this.f1372b = c0407t;
        this.f1371a = runnable;
    }

    public void run() {
        try {
            this.f1371a.run();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to execute task.", e);
        }
    }
}
