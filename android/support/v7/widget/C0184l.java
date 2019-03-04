package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.view.cr;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: DefaultItemAnimator */
class C0184l extends C0182r {
    final /* synthetic */ bg f690a;
    final /* synthetic */ cr f691b;
    final /* synthetic */ C0178g f692c;

    C0184l(C0178g c0178g, bg bgVar, cr crVar) {
        this.f692c = c0178g;
        this.f690a = bgVar;
        this.f691b = crVar;
        super();
    }

    public void mo315a(View view) {
        this.f692c.m1565i(this.f690a);
    }

    public void mo317c(View view) {
        ay.m578c(view, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public void mo316b(View view) {
        this.f691b.m815a(null);
        this.f692c.m1559f(this.f690a);
        this.f692c.f677h.remove(this.f690a);
        this.f692c.m1771j();
    }
}
