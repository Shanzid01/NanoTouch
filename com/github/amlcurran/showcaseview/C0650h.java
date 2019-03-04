package com.github.amlcurran.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/* compiled from: NewShowcaseDrawer */
class C0650h extends ab {
    private final float f1649d;
    private final float f1650e;

    public C0650h(Resources resources) {
        super(resources);
        this.f1649d = resources.getDimension(C0655m.showcase_radius_outer);
        this.f1650e = resources.getDimension(C0655m.showcase_radius_inner);
    }

    public void mo1092a(int i) {
        this.a.setColor(i);
    }

    public void mo1094a(Bitmap bitmap, float f, float f2, float f3) {
        Canvas canvas = new Canvas(bitmap);
        this.a.setAlpha(153);
        canvas.drawCircle(f, f2, this.f1649d, this.a);
        this.a.setAlpha(0);
        canvas.drawCircle(f, f2, this.f1650e, this.a);
    }

    public int mo1091a() {
        return (int) (this.f1649d * 2.0f);
    }

    public int mo1096b() {
        return (int) (this.f1649d * 2.0f);
    }

    public float mo1098c() {
        return this.f1650e;
    }

    public void mo1097b(int i) {
        this.c = i;
    }
}
