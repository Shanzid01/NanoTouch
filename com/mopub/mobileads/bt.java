package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MraidView */
class bt implements OnTouchListener {
    final /* synthetic */ MraidView f2467a;

    bt(MraidView mraidView) {
        this.f2467a = mraidView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f2467a.f2360h.m4467a(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        return false;
    }
}
