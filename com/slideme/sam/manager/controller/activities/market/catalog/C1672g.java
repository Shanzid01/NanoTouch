package com.slideme.sam.manager.controller.activities.market.catalog;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.model.p061a.C1818f;

/* compiled from: MainActivity */
class C1672g implements OnClickListener {
    final /* synthetic */ MainActivity f2827a;

    C1672g(MainActivity mainActivity) {
        this.f2827a = mainActivity;
    }

    public void onClick(View view) {
        this.f2827a.startActivity(C1818f.m5459b(this.f2827a.getApplicationContext()));
    }
}
