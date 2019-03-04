package com.slideme.sam.manager.controller.fragment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: ReviewListFragment */
class bb implements OnScrollListener {
    boolean f3107a = false;
    final /* synthetic */ ay f3108b;

    bb(ay ayVar) {
        this.f3108b = ayVar;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 1) {
            this.f3107a = true;
        } else {
            this.f3107a = false;
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f3107a && i3 == i + i2 && !this.f3108b.f3071e.m5739e() && this.f3108b.m5270a()) {
            this.f3108b.f3071e.m5732a();
        }
    }
}
