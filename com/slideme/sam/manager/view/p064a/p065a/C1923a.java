package com.slideme.sam.manager.view.p064a.p065a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.p026b.p027a.p034b.p035a.C0476d;

/* compiled from: AdapterViewFactory */
public abstract class C1923a<T> {
    public abstract View mo4320a();

    public abstract View mo4321a(int i, T t, View view, ViewGroup viewGroup);

    public abstract View mo4322a(int i, T t, View view, ViewGroup viewGroup, C0476d c0476d);

    public static void m5802a(View view, float f) {
        ViewHelper.setPivotX(view, (float) (view.getWidth() / 2));
        ViewHelper.setPivotY(view, (float) (view.getHeight() / 3));
        AnimatorSet animatorSet = new AnimatorSet();
        Animator duration = ObjectAnimator.ofFloat((Object) view, "translationY", 100.0f, 0.0f).setDuration((long) view.getResources().getInteger(17694721));
        duration.setInterpolator(new DecelerateInterpolator());
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = duration;
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "alpha", 0.25f, f).setDuration((long) view.getResources().getInteger(17694721));
        animatorSet.playTogether(animatorArr);
        animatorSet.start();
    }
}
