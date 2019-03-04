package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class bf extends Animation {
    final /* synthetic */ SwipeRefreshLayout f460a;

    bf(SwipeRefreshLayout swipeRefreshLayout) {
        this.f460a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        int i;
        if (this.f460a.f365F) {
            i = (int) this.f460a.f361B;
        } else {
            i = (int) (this.f460a.f361B - ((float) Math.abs(this.f460a.f370b)));
        }
        this.f460a.setTargetOffsetTopAndBottom((((int) (((float) (i - this.f460a.f369a)) * f)) + this.f460a.f369a) - this.f460a.f385s.getTop(), false);
    }
}
