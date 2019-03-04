package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: VastVideoViewController */
class cc implements OnTouchListener {
    final /* synthetic */ VastVideoViewController f2494a;

    cc(VastVideoViewController vastVideoViewController) {
        this.f2494a = vastVideoViewController;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f2494a.m4451o()) {
            this.f2494a.m4421a(this.f2494a.f2368b.m4703g(), this.f2494a.f2368b.m4705h());
        }
        return true;
    }
}
