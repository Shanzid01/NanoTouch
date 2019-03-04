package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class bh extends Animation {
    final /* synthetic */ SwipeRefreshLayout f462a;

    bh(SwipeRefreshLayout swipeRefreshLayout) {
        this.f462a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f462a.setAnimationProgress(this.f462a.f387u + ((-this.f462a.f387u) * f));
        this.f462a.m1002a(f);
    }
}
