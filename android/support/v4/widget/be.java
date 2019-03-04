package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: SwipeRefreshLayout */
class be implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f459a;

    be(SwipeRefreshLayout swipeRefreshLayout) {
        this.f459a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f459a.f382o) {
            this.f459a.m1017b(null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
