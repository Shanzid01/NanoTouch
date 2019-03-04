package com.p026b.p027a.p034b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.p026b.p027a.p041c.C0524d;

/* compiled from: ProcessAndDisplayImageTask */
class C0520q implements Runnable {
    private final C0514k f1590a;
    private final Bitmap f1591b;
    private final C0516m f1592c;
    private final Handler f1593d;

    public C0520q(C0514k c0514k, Bitmap bitmap, C0516m c0516m, Handler handler) {
        this.f1590a = c0514k;
        this.f1591b = bitmap;
        this.f1592c = c0516m;
        this.f1593d = handler;
    }

    public void run() {
        if (this.f1590a.f1553a.f1523t) {
            C0524d.m3153b("PostProcess image before displaying [%s]", this.f1592c.f1565b);
        }
        Bitmap a = this.f1592c.f1568e.m3056r().m3059a(this.f1591b);
        if (a != this.f1591b) {
            this.f1591b.recycle();
        }
        this.f1593d.post(new C0497c(a, this.f1592c, this.f1590a));
    }
}
