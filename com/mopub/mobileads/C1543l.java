package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: BaseHtmlWebView */
class C1543l implements OnTouchListener {
    final /* synthetic */ BaseHtmlWebView f2515a;
    private final /* synthetic */ boolean f2516b;

    C1543l(BaseHtmlWebView baseHtmlWebView, boolean z) {
        this.f2515a = baseHtmlWebView;
        this.f2516b = z;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f2515a.f2281b.m4467a(motionEvent);
        return motionEvent.getAction() == 2 && !this.f2516b;
    }
}
