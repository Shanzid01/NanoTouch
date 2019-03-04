package com.slideme.sam.manager.model.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.util.C1922m;

public class CheckPendingInstallNotificationsAlarmReceiver extends BroadcastReceiver {
    private static final String f3307a = BroadcastReceiver.class.getCanonicalName();

    public void onReceive(Context context, Intent intent) {
        C1922m.m5797b(f3307a, "Alarm Fired! checkForPendingIntallNotifications");
        C1922m.m5799c(context);
    }
}
