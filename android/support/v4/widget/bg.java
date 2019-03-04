package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class bg extends Animation {
    final /* synthetic */ SwipeRefreshLayout f461a;

    bg(SwipeRefreshLayout swipeRefreshLayout) {
        this.f461a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f461a.m1002a(f);
    }
}
