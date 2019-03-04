package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.view.cr;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: DefaultItemAnimator */
class C0186n extends C0182r {
    final /* synthetic */ C0188p f698a;
    final /* synthetic */ cr f699b;
    final /* synthetic */ C0178g f700c;

    C0186n(C0178g c0178g, C0188p c0188p, cr crVar) {
        this.f700c = c0178g;
        this.f698a = c0188p;
        this.f699b = crVar;
        super();
    }

    public void mo315a(View view) {
        this.f700c.m1547b(this.f698a.f705a, true);
    }

    public void mo316b(View view) {
        this.f699b.m815a(null);
        ay.m578c(view, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
        ay.m566a(view, 0.0f);
        ay.m575b(view, 0.0f);
        this.f700c.m1543a(this.f698a.f705a, true);
        this.f700c.f680k.remove(this.f698a.f705a);
        this.f700c.m1771j();
    }
}
