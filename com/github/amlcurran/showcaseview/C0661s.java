package com.github.amlcurran.showcaseview;

import android.graphics.Rect;
import android.util.Log;

/* compiled from: ShowcaseAreaCalculator */
class C0661s {
    private final Rect f1654a = new Rect();

    C0661s() {
    }

    public boolean m3243a(float f, float f2, C0643t c0643t) {
        int i = (int) f;
        int i2 = (int) f2;
        int a = c0643t.mo1091a();
        int b = c0643t.mo1096b();
        if (this.f1654a.left == i - (a / 2) && this.f1654a.top == i2 - (b / 2)) {
            return false;
        }
        Log.d("ShowcaseView", "Recalculated");
        this.f1654a.left = i - (a / 2);
        this.f1654a.top = i2 - (b / 2);
        this.f1654a.right = i + (a / 2);
        this.f1654a.bottom = i2 + (b / 2);
        return true;
    }

    public Rect m3242a() {
        return this.f1654a;
    }
}
