package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: VastVideoViewController */
class cf implements OnTouchListener {
    final /* synthetic */ VastVideoViewController f2497a;

    cf(VastVideoViewController vastVideoViewController) {
        this.f2497a = vastVideoViewController;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f2497a.m4290g().onFinish();
        }
        return true;
    }
}
