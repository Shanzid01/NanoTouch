package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/* compiled from: ClosableTextPanel */
class C1970c implements OnClickListener {
    final /* synthetic */ ClosableTextPanel f3824a;

    C1970c(ClosableTextPanel closableTextPanel) {
        this.f3824a = closableTextPanel;
    }

    public void onClick(View view) {
        Animator duration = ObjectAnimator.ofFloat(this.f3824a, "alpha", 0.0f).setDuration((long) this.f3824a.getResources().getInteger(17694721));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration);
        animatorSet.addListener(new C1971d(this));
        animatorSet.start();
        this.f3824a.f3658a = true;
        if (this.f3824a.f3661d == C1972e.CLOSABLE_PANEL) {
            this.f3824a.setShowNextTime(false);
        }
    }
}
