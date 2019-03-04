package com.slideme.sam.manager.controller.activities.market.catalog;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class C1670e implements OnClickListener {
    final /* synthetic */ MainActivity f2825a;

    C1670e(MainActivity mainActivity) {
        this.f2825a = mainActivity;
    }

    public void onClick(View view) {
        Intent a = this.f2825a.f2813f.m5424a(this.f2825a);
        this.f2825a.f2814g.setClosedState(true);
        try {
            this.f2825a.startActivity(a);
        } catch (Exception e) {
        }
    }
}
