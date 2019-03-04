package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

/* compiled from: LinearLayoutManager */
class C0192u extends C0174z {
    final /* synthetic */ LinearLayoutManager f723a;

    C0192u(LinearLayoutManager linearLayoutManager, Context context) {
        this.f723a = linearLayoutManager;
        super(context);
    }

    public PointF computeScrollVectorForPosition(int i) {
        return this.f723a.m1330a(i);
    }
}
