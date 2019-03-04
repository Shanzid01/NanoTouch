package com.github.amlcurran.showcaseview;

import android.graphics.Point;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.cast.TextTrackStyle;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/* compiled from: AnimatorAnimationFactory */
class C0646d implements C0642a {
    private final AccelerateDecelerateInterpolator f1644a = new AccelerateDecelerateInterpolator();

    public void mo1100a(View view, long j, C0645c c0645c) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
        ofFloat.setDuration(j).addListener(new C0647e(this, c0645c));
        ofFloat.start();
    }

    public void mo1099a(View view, long j, C0644b c0644b) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f);
        ofFloat.setDuration(j).addListener(new C0648f(this, c0644b));
        ofFloat.start();
    }

    public void mo1101a(ShowcaseView showcaseView, Point point) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt((Object) showcaseView, "showcaseX", point.x);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt((Object) showcaseView, "showcaseY", point.y);
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.setInterpolator(this.f1644a);
        animatorSet.start();
    }
}
