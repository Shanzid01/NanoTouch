package com.slideme.sam.manager.controller.fragment.p056a;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: ApplicationListFragment */
class C1721l implements OnScrollListener {
    final /* synthetic */ C1708i f2965a;

    C1721l(C1708i c1708i) {
        this.f2965a = c1708i;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 > i3 - 20 && this.f2965a.f2910g.m5693i().size() == i3 - 1 && !this.f2965a.f2910g.m5696l() && this.f2965a.f2907d.m5844a()) {
            this.f2965a.f2910g.m5685f();
        }
    }
}
