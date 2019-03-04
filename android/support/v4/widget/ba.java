package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: SwipeRefreshLayout */
class ba implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f453a;

    ba(SwipeRefreshLayout swipeRefreshLayout) {
        this.f453a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f453a.f373f) {
            this.f453a.f388v.setAlpha(255);
            this.f453a.f388v.start();
            if (this.f453a.f362C && this.f453a.f372e != null) {
                this.f453a.f372e.m1178a();
            }
        } else {
            this.f453a.f388v.stop();
            this.f453a.f385s.setVisibility(8);
            this.f453a.setColorViewAlpha(255);
            if (this.f453a.f382o) {
                this.f453a.setAnimationProgress(0.0f);
            } else {
                this.f453a.setTargetOffsetTopAndBottom(this.f453a.f370b - this.f453a.f377j, true);
            }
        }
        this.f453a.f377j = this.f453a.f385s.getTop();
    }
}
