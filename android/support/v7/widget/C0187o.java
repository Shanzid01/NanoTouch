package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.view.cr;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: DefaultItemAnimator */
class C0187o extends C0182r {
    final /* synthetic */ C0188p f701a;
    final /* synthetic */ cr f702b;
    final /* synthetic */ View f703c;
    final /* synthetic */ C0178g f704d;

    C0187o(C0178g c0178g, C0188p c0188p, cr crVar, View view) {
        this.f704d = c0178g;
        this.f701a = c0188p;
        this.f702b = crVar;
        this.f703c = view;
        super();
    }

    public void mo315a(View view) {
        this.f704d.m1547b(this.f701a.f706b, false);
    }

    public void mo316b(View view) {
        this.f702b.m815a(null);
        ay.m578c(this.f703c, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
        ay.m566a(this.f703c, 0.0f);
        ay.m575b(this.f703c, 0.0f);
        this.f704d.m1543a(this.f701a.f706b, false);
        this.f704d.f680k.remove(this.f701a.f706b);
        this.f704d.m1771j();
    }
}
