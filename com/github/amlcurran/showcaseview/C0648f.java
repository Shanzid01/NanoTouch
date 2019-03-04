package com.github.amlcurran.showcaseview;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

/* compiled from: AnimatorAnimationFactory */
class C0648f implements AnimatorListener {
    final /* synthetic */ C0646d f1647a;
    private final /* synthetic */ C0644b f1648b;

    C0648f(C0646d c0646d, C0644b c0644b) {
        this.f1647a = c0646d;
        this.f1648b = c0644b;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f1648b.mo1109a();
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }
}
