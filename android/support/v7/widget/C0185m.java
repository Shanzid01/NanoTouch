package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.view.cr;
import android.view.View;

/* compiled from: DefaultItemAnimator */
class C0185m extends C0182r {
    final /* synthetic */ bg f693a;
    final /* synthetic */ int f694b;
    final /* synthetic */ int f695c;
    final /* synthetic */ cr f696d;
    final /* synthetic */ C0178g f697e;

    C0185m(C0178g c0178g, bg bgVar, int i, int i2, cr crVar) {
        this.f697e = c0178g;
        this.f693a = bgVar;
        this.f694b = i;
        this.f695c = i2;
        this.f696d = crVar;
        super();
    }

    public void mo315a(View view) {
        this.f697e.m1562h(this.f693a);
    }

    public void mo317c(View view) {
        if (this.f694b != 0) {
            ay.m566a(view, 0.0f);
        }
        if (this.f695c != 0) {
            ay.m575b(view, 0.0f);
        }
    }

    public void mo316b(View view) {
        this.f696d.m815a(null);
        this.f697e.m1557e(this.f693a);
        this.f697e.f678i.remove(this.f693a);
        this.f697e.m1771j();
    }
}
