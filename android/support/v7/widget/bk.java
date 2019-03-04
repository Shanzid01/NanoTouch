package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

/* compiled from: StaggeredGridLayoutManager */
class bk extends C0174z {
    final /* synthetic */ StaggeredGridLayoutManager f650a;

    bk(StaggeredGridLayoutManager staggeredGridLayoutManager, Context context) {
        this.f650a = staggeredGridLayoutManager;
        super(context);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int a = this.f650a.m1412h(i);
        if (a == 0) {
            return null;
        }
        if (this.f650a.f554i == 0) {
            return new PointF((float) a, 0.0f);
        }
        return new PointF(0.0f, (float) a);
    }
}
