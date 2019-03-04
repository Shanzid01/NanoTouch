package com.slideme.sam.manager.controller.fragment;

import android.view.View;
import android.widget.ScrollView;
import com.slideme.sam.manager.R;

/* compiled from: ApplicationDetailsFragment */
class C1764n implements Runnable {
    final /* synthetic */ C1763m f3141a;
    private final /* synthetic */ int f3142b;
    private final /* synthetic */ View f3143c;

    C1764n(C1763m c1763m, int i, View view) {
        this.f3141a = c1763m;
        this.f3142b = i;
        this.f3143c = view;
    }

    public void run() {
        if (this.f3141a.f3138a.m5192h()) {
            this.f3141a.f3138a.f3004p.smoothScrollTo(0, this.f3141a.f3138a.f3004p.getScrollY() + this.f3142b);
            return;
        }
        ScrollView scrollView = (ScrollView) this.f3143c.findViewById(R.id.rightPanel);
        scrollView.smoothScrollTo(0, scrollView.getScrollY() + this.f3142b);
    }
}
