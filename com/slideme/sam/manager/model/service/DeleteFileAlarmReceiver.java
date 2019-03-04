package com.slideme.sam.manager.model.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1922m;

public class DeleteFileAlarmReceiver extends BroadcastReceiver {
    private static final String f3308a = BroadcastReceiver.class.getCanonicalName();

    public void onReceive(Context context, Intent intent) {
        C1922m.m5797b(f3308a, "Alarm Fired!");
        if (intent.getExtras() != null) {
            Application application = (Application) C1915f.m5770a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", Application.CREATOR);
            C1922m.m5797b(f3308a, "Application " + application.getName() + " apk deleted -> " + Boolean.toString(LaunchOrInstallService.m5562a(application.localFilePath)));
        }
    }
}
