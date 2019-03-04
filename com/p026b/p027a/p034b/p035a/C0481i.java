package com.p026b.p027a.p034b.p035a;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.p026b.p027a.p034b.C0510g;

/* compiled from: PauseOnScrollListener */
public class C0481i implements OnScrollListener {
    private C0510g f1430a;
    private final boolean f1431b;
    private final boolean f1432c;
    private final OnScrollListener f1433d;

    public C0481i(C0510g c0510g, boolean z, boolean z2, OnScrollListener onScrollListener) {
        this.f1430a = c0510g;
        this.f1431b = z;
        this.f1432c = z2;
        this.f1433d = onScrollListener;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
                this.f1430a.m3087d();
                break;
            case 1:
                if (this.f1431b) {
                    this.f1430a.m3086c();
                    break;
                }
                break;
            case 2:
                if (this.f1432c) {
                    this.f1430a.m3086c();
                    break;
                }
                break;
        }
        if (this.f1433d != null) {
            this.f1433d.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f1433d != null) {
            this.f1433d.onScroll(absListView, i, i2, i3);
        }
    }
}
