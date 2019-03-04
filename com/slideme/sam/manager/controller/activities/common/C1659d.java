package com.slideme.sam.manager.controller.activities.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: CommonActivity */
class C1659d extends BroadcastReceiver {
    final /* synthetic */ CommonActivity f2790a;

    C1659d(CommonActivity commonActivity) {
        this.f2790a = commonActivity;
    }

    public void onReceive(Context context, Intent intent) {
        this.f2790a.startActivity(this.f2790a.getIntent());
        this.f2790a.finish();
    }
}
