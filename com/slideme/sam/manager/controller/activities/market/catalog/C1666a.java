package com.slideme.sam.manager.controller.activities.market.catalog;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: CategoryDisplayActivity */
class C1666a implements OnFocusChangeListener {
    final /* synthetic */ CategoryDisplayActivity f2820a;

    C1666a(CategoryDisplayActivity categoryDisplayActivity) {
        this.f2820a = categoryDisplayActivity;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f2820a.f2800a.setSelectedChild(this.f2820a.f2800a.m6040a(view), true);
        }
    }
}
