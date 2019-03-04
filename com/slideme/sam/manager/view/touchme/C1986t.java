package com.slideme.sam.manager.view.touchme;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.concurrent.CountDownLatch;

/* compiled from: Masonry */
class C1986t implements AnimationListener {
    final /* synthetic */ C1985s f3846a;
    private final /* synthetic */ CountDownLatch f3847b;

    C1986t(C1985s c1985s, CountDownLatch countDownLatch) {
        this.f3846a = c1985s;
        this.f3847b = countDownLatch;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f3847b.countDown();
    }
}
