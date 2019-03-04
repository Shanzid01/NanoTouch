package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
final class de extends AnimatorListenerAdapter {
    final /* synthetic */ df f255a;
    final /* synthetic */ View f256b;

    de(df dfVar, View view) {
        this.f255a = dfVar;
        this.f256b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f255a.mo317c(this.f256b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f255a.mo316b(this.f256b);
    }

    public void onAnimationStart(Animator animator) {
        this.f255a.mo315a(this.f256b);
    }
}
