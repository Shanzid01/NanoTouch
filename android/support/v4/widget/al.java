package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ScrollerCompat */
class al implements ak {
    al() {
    }

    public Object mo339a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public boolean mo342a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public int mo343b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int mo344c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public float mo345d(Object obj) {
        return 0.0f;
    }

    public boolean mo346e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void mo340a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void mo341a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void mo347f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int mo348g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int mo349h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
