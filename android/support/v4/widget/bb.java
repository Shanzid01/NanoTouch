package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class bb extends Animation {
    final /* synthetic */ SwipeRefreshLayout f454a;

    bb(SwipeRefreshLayout swipeRefreshLayout) {
        this.f454a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f454a.setAnimationProgress(f);
    }
}
