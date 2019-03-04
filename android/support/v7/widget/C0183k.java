package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.view.cr;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: DefaultItemAnimator */
class C0183k extends C0182r {
    final /* synthetic */ bg f687a;
    final /* synthetic */ cr f688b;
    final /* synthetic */ C0178g f689c;

    C0183k(C0178g c0178g, bg bgVar, cr crVar) {
        this.f689c = c0178g;
        this.f687a = bgVar;
        this.f688b = crVar;
        super();
    }

    public void mo315a(View view) {
        this.f689c.m1561g(this.f687a);
    }

    public void mo316b(View view) {
        this.f688b.m815a(null);
        ay.m578c(view, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f689c.m1554d(this.f687a);
        this.f689c.f679j.remove(this.f687a);
        this.f689c.m1771j();
    }
}
