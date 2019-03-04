package com.slideme.sam.manager.view.p064a;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.Category;

/* compiled from: CategoryExpandableListAdapter */
class C1936g implements OnClickListener {
    final /* synthetic */ C1934e f3550a;
    private final /* synthetic */ Category f3551b;

    C1936g(C1934e c1934e, Category category) {
        this.f3550a = c1934e;
        this.f3551b = category;
    }

    public void onClick(View view) {
        C1698a.m5063a(this.f3551b, view.getContext());
    }
}
