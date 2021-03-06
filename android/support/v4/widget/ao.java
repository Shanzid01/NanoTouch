package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: ScrollerCompatGingerbread */
class ao {
    public static Object m1131a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean m1134a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m1135b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m1136c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m1137d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m1132a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m1133a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m1138e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m1139f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m1140g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
