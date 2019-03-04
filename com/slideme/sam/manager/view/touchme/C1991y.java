package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/* compiled from: NotificationPanel */
class C1991y implements OnClickListener {
    final /* synthetic */ NotificationPanel f3854a;

    C1991y(NotificationPanel notificationPanel) {
        this.f3854a = notificationPanel;
    }

    public void onClick(View view) {
        Animator duration = ObjectAnimator.ofFloat(this.f3854a, "alpha", 0.0f).setDuration((long) this.f3854a.getResources().getInteger(17694721));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration);
        animatorSet.addListener(new C1992z(this));
        animatorSet.start();
        this.f3854a.f3719a = true;
    }
}
