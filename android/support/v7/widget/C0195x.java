package android.support.v7.widget;

import android.view.View;
import java.util.List;

/* compiled from: LinearLayoutManager */
class C0195x {
    boolean f732a = true;
    int f733b;
    int f734c;
    int f735d;
    int f736e;
    int f737f;
    int f738g;
    int f739h = 0;
    boolean f740i = false;
    List<bg> f741j = null;

    C0195x() {
    }

    boolean m1813a(bd bdVar) {
        return this.f735d >= 0 && this.f735d < bdVar.m1654f();
    }

    View m1812a(ax axVar) {
        if (this.f741j != null) {
            return m1811a();
        }
        View c = axVar.m1611c(this.f735d);
        this.f735d += this.f736e;
        return c;
    }

    private View m1811a() {
        bg bgVar;
        int size = this.f741j.size();
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = 0;
        bg bgVar2 = null;
        while (i2 < size) {
            int i3;
            bg bgVar3;
            bgVar = (bg) this.f741j.get(i2);
            if (this.f740i || !bgVar.m1691q()) {
                int d = (bgVar.m1678d() - this.f735d) * this.f736e;
                if (d < 0) {
                    i3 = i;
                    bgVar3 = bgVar2;
                } else if (d >= i) {
                    i3 = i;
                    bgVar3 = bgVar2;
                } else if (d == 0) {
                    break;
                } else {
                    bgVar3 = bgVar;
                    i3 = d;
                }
            } else {
                i3 = i;
                bgVar3 = bgVar2;
            }
            i2++;
            bgVar2 = bgVar3;
            i = i3;
        }
        bgVar = bgVar2;
        if (bgVar == null) {
            return null;
        }
        this.f735d = bgVar.m1678d() + this.f736e;
        return bgVar.f636a;
    }
}
