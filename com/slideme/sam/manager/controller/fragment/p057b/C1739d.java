package com.slideme.sam.manager.controller.fragment.p057b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: AdProxyWebViewFragment */
class C1739d implements OnTouchListener {
    final /* synthetic */ C1736a f3087a;

    C1739d(C1736a c1736a) {
        this.f3087a = c1736a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
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
