package android.support.v7.widget;

import android.view.View;

/* compiled from: LayoutState */
class C0191t {
    int f718a;
    int f719b;
    int f720c;
    int f721d;
    int f722e = 0;

    C0191t() {
    }

    boolean m1805a(bd bdVar) {
        return this.f719b >= 0 && this.f719b < bdVar.m1654f();
    }

    View m1804a(ax axVar) {
        View c = axVar.m1611c(this.f719b);
        this.f719b += this.f720c;
        return c;
    }
}
