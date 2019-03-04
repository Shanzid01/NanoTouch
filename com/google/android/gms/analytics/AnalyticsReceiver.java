package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public final class AnalyticsReceiver extends BroadcastReceiver {
    static WakeLock zzAY;
    static Object zzmz = new Object();

    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, AnalyticsService.class);
        synchronized (zzmz) {
            context.startService(intent2);
            try {
                zzAY = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "Analytics WakeLock");
                zzAY.acquire(1000);
            } catch (SecurityException e) {
                zzae.zzac("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
    }
}
