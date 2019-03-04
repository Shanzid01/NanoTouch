package com.p019a.p020a.p023c;

import java.util.concurrent.CountDownLatch;

/* compiled from: CrashlyticsCore */
class C0406s {
    final /* synthetic */ C0395h f1367a;
    private boolean f1368b;
    private final CountDownLatch f1369c;

    private C0406s(C0395h c0395h) {
        this.f1367a = c0395h;
        this.f1368b = false;
        this.f1369c = new CountDownLatch(1);
    }

    void m2814a(boolean z) {
        this.f1368b = z;
        this.f1369c.countDown();
    }

    boolean m2815a() {
        return this.f1368b;
    }

    void m2816b() {
        try {
            this.f1369c.await();
        } catch (InterruptedException e) {
        }
    }
}
