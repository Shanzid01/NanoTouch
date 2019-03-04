package com.p026b.p027a.p034b;

/* compiled from: ImageLoaderEngine */
class C0515l implements Runnable {
    final /* synthetic */ C0517n f1562a;
    final /* synthetic */ C0514k f1563b;

    C0515l(C0514k c0514k, C0517n c0517n) {
        this.f1563b = c0514k;
        this.f1562a = c0517n;
    }

    public void run() {
        boolean exists = this.f1563b.f1553a.f1519p.mo914a(this.f1562a.m3143a()).exists();
        this.f1563b.m3115g();
        if (exists) {
            this.f1563b.f1555c.execute(this.f1562a);
        } else {
            this.f1563b.f1554b.execute(this.f1562a);
        }
    }
}
