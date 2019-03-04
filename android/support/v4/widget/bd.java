package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class bd extends Animation {
    final /* synthetic */ int f456a;
    final /* synthetic */ int f457b;
    final /* synthetic */ SwipeRefreshLayout f458c;

    bd(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f458c = swipeRefreshLayout;
        this.f456a = i;
        this.f457b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f458c.f388v.setAlpha((int) (((float) this.f456a) + (((float) (this.f457b - this.f456a)) * f)));
    }
}
