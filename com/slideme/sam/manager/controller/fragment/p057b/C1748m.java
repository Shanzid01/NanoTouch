package com.slideme.sam.manager.controller.fragment.p057b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WebViewFragment */
class C1748m implements OnTouchListener {
    final /* synthetic */ C1746k f3103a;

    C1748m(C1746k c1746k) {
        this.f3103a = c1746k;
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
