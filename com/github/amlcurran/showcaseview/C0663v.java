package com.github.amlcurran.showcaseview;

import android.graphics.Point;
import com.github.amlcurran.showcaseview.p042a.C0639a;

/* compiled from: ShowcaseView */
class C0663v implements Runnable {
    final /* synthetic */ ShowcaseView f1656a;
    private final /* synthetic */ C0639a f1657b;
    private final /* synthetic */ boolean f1658c;

    C0663v(ShowcaseView showcaseView, C0639a c0639a, boolean z) {
        this.f1656a = showcaseView;
        this.f1657b = c0639a;
        this.f1658c = z;
    }

    public void run() {
        if (!this.f1656a.f1603g.m3239a()) {
            this.f1656a.m3173g();
            Point a = this.f1657b.mo1090a();
            if (a != null) {
                this.f1656a.f1614r = false;
                if (this.f1658c) {
                    this.f1656a.f1602f.mo1101a(this.f1656a, a);
                    return;
                } else {
                    this.f1656a.m3179a(a);
                    return;
                }
            }
            this.f1656a.f1614r = true;
            this.f1656a.invalidate();
        }
    }
}
