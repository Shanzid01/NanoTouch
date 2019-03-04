package com.slideme.sam.manager.view.touchme;

import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;

/* compiled from: FeaturedLayout */
class C1981o extends SimpleOnGestureListener {
    final /* synthetic */ FeaturedLayout f3836a;

    private C1981o(FeaturedLayout featuredLayout) {
        this.f3836a = featuredLayout;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f3836a.scrollBy((int) f, 0);
        this.f3836a.m5966c();
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.f3836a.getContext().startActivity(new Intent(this.f3836a.getContext(), ApplicationDetailsActivity.class));
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
        this.f3836a.f3693h = true;
        this.f3836a.invalidate();
    }
}
