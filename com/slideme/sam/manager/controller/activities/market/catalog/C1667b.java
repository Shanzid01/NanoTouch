package com.slideme.sam.manager.controller.activities.market.catalog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: MainActivity */
class C1667b extends BroadcastReceiver {
    final /* synthetic */ MainActivity f2821a;

    C1667b(MainActivity mainActivity) {
        this.f2821a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.slideme.sam.manager.ACTION_DAILY_UPDATED".equals(intent.getAction())) {
            this.f2821a.m4973h();
            this.f2821a.m4974i();
        } else if ("com.slideme.sam.manager.ACTION_NOTIFICATION_BANNER_REFRESH".equals(intent.getAction())) {
            this.f2821a.m4974i();
        }
    }
}
