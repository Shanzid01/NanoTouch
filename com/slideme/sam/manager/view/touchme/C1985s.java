package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import java.util.concurrent.CountDownLatch;

/* compiled from: Masonry */
class C1985s implements Runnable {
    final /* synthetic */ C1984r f3842a;
    private final /* synthetic */ View f3843b;
    private final /* synthetic */ C1987u f3844c;
    private final /* synthetic */ CountDownLatch f3845d;

    C1985s(C1984r c1984r, View view, C1987u c1987u, CountDownLatch countDownLatch) {
        this.f3842a = c1984r;
        this.f3843b = view;
        this.f3844c = c1987u;
        this.f3845d = countDownLatch;
    }

    public void run() {
        int left = this.f3843b.getLeft();
        int top = this.f3843b.getTop();
        int i = this.f3844c.f3849b;
        int i2 = this.f3844c.f3848a;
        this.f3843b.layout(i, i2, this.f3843b.getMeasuredWidth() + i, this.f3843b.getMeasuredHeight() + i2);
        Animation translateAnimation = new TranslateAnimation((float) (left - i), 0.0f, (float) (top - i2), 0.0f);
        translateAnimation.setDuration((long) this.f3842a.f3841a.f3709f);
        translateAnimation.setAnimationListener(new C1986t(this, this.f3845d));
        this.f3843b.startAnimation(translateAnimation);
    }
}
