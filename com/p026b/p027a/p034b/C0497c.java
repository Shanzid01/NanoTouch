package com.p026b.p027a.p034b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.p026b.p027a.p034b.p038c.C0493a;
import com.p026b.p027a.p041c.C0524d;

/* compiled from: DisplayBitmapTask */
final class C0497c implements Runnable {
    private final Bitmap f1454a;
    private final String f1455b;
    private final ImageView f1456c;
    private final String f1457d;
    private final C0493a f1458e;
    private final C0476d f1459f;
    private final C0514k f1460g;
    private boolean f1461h;

    public C0497c(Bitmap bitmap, C0516m c0516m, C0514k c0514k) {
        this.f1454a = bitmap;
        this.f1455b = c0516m.f1564a;
        this.f1456c = c0516m.f1566c;
        this.f1457d = c0516m.f1565b;
        this.f1458e = c0516m.f1568e.m3057s();
        this.f1459f = c0516m.f1569f;
        this.f1460g = c0514k;
    }

    public void run() {
        if (m3011a()) {
            if (this.f1461h) {
                C0524d.m3153b("ImageView is reused for another image. Task is cancelled. [%s]", this.f1457d);
            }
            this.f1459f.mo933b(this.f1455b, this.f1456c);
            return;
        }
        if (this.f1461h) {
            C0524d.m3153b("Display image in ImageView [%s]", this.f1457d);
        }
        this.f1459f.mo931a(this.f1455b, this.f1456c, this.f1458e.mo935a(this.f1454a, this.f1456c));
        this.f1460g.m3124b(this.f1456c);
    }

    private boolean m3011a() {
        return !this.f1457d.equals(this.f1460g.m3117a(this.f1456c));
    }

    void m3012a(boolean z) {
        this.f1461h = z;
    }
}
