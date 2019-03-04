package com.slideme.sam.manager.controller.fragment.p057b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WebBuyFragment */
class C1744i implements OnTouchListener {
    final /* synthetic */ C1742g f3097a;

    C1744i(C1742g c1742g) {
        this.f3097a = c1742g;
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
