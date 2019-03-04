package com.p026b.p027a.p034b;

import com.p026b.p027a.p034b.p035a.C0473a;
import com.p026b.p027a.p034b.p035a.C0474b;

/* compiled from: LoadAndDisplayImageTask */
class C0519p implements Runnable {
    final /* synthetic */ C0474b f1587a;
    final /* synthetic */ Throwable f1588b;
    final /* synthetic */ C0517n f1589c;

    C0519p(C0517n c0517n, C0474b c0474b, Throwable th) {
        this.f1589c = c0517n;
        this.f1587a = c0474b;
        this.f1588b = th;
    }

    public void run() {
        if (this.f1589c.f1573c.m3041c()) {
            this.f1589c.f1572b.setImageResource(this.f1589c.f1573c.m3047i());
        }
        this.f1589c.f1574d.mo932a(this.f1589c.f1571a, this.f1589c.f1572b, new C0473a(this.f1587a, this.f1588b));
    }
}
