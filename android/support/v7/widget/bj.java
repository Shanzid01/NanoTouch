package android.support.v7.widget;

import android.view.View;

/* compiled from: ScrollbarHelper */
class bj {
    static int m1702a(bd bdVar, ac acVar, View view, View view2, at atVar, boolean z, boolean z2) {
        if (atVar.getChildCount() == 0 || bdVar.m1654f() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (bdVar.m1654f() - Math.max(atVar.getPosition(view), atVar.getPosition(view2))) - 1) : Math.max(0, Math.min(atVar.getPosition(view), atVar.getPosition(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(acVar.mo418b(view2) - acVar.mo416a(view))) / ((float) (Math.abs(atVar.getPosition(view) - atVar.getPosition(view2)) + 1)))) + ((float) (acVar.mo419c() - acVar.mo416a(view))));
    }

    static int m1701a(bd bdVar, ac acVar, View view, View view2, at atVar, boolean z) {
        if (atVar.getChildCount() == 0 || bdVar.m1654f() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(atVar.getPosition(view) - atVar.getPosition(view2)) + 1;
        }
        return Math.min(acVar.mo424f(), acVar.mo418b(view2) - acVar.mo416a(view));
    }

    static int m1703b(bd bdVar, ac acVar, View view, View view2, at atVar, boolean z) {
        if (atVar.getChildCount() == 0 || bdVar.m1654f() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return bdVar.m1654f();
        }
        return (int) ((((float) (acVar.mo418b(view2) - acVar.mo416a(view))) / ((float) (Math.abs(atVar.getPosition(view) - atVar.getPosition(view2)) + 1))) * ((float) bdVar.m1654f()));
    }
}
