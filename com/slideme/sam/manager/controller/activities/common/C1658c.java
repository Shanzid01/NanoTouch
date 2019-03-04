package com.slideme.sam.manager.controller.activities.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.controller.activities.SplashActivity;

/* compiled from: CommonActivity */
class C1658c extends BroadcastReceiver {
    final /* synthetic */ CommonActivity f2789a;

    C1658c(CommonActivity commonActivity) {
        this.f2789a = commonActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (!(this.f2789a instanceof SplashActivity)) {
            this.f2789a.finish();
        }
    }
}
