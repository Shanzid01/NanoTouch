package com.slideme.sam.manager.controller.activities.market.catalog;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.model.p061a.C1818f;

/* compiled from: MainActivity */
class C1671f implements OnClickListener {
    final /* synthetic */ MainActivity f2826a;

    C1671f(MainActivity mainActivity) {
        this.f2826a = mainActivity;
    }

    public void onClick(View view) {
        this.f2826a.startActivity(C1818f.m5456a(this.f2826a.getApplicationContext()));
    }
}
