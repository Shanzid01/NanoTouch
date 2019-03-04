package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatICS */
final class dc extends AnimatorListenerAdapter {
    final /* synthetic */ df f253a;
    final /* synthetic */ View f254b;

    dc(df dfVar, View view) {
        this.f253a = dfVar;
        this.f254b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f253a.mo317c(this.f254b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f253a.mo316b(this.f254b);
    }

    public void onAnimationStart(Animator animator) {
        this.f253a.mo315a(this.f254b);
    }
}
