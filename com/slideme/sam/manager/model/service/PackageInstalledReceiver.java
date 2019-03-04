package com.slideme.sam.manager.model.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.cache.helper.InstallReferrerCache;
import com.slideme.sam.manager.model.data.cache.helper.data.InstallReferrerCacheObject;
import com.slideme.sam.manager.util.C1922m;

public class PackageInstalledReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            String replace = intent.getDataString().replace("package:", "");
            if (SAM.f2623p == null) {
                SAM.f2623p = new InstallReferrerCache(context);
            }
            InstallReferrerCacheObject item = SAM.f2623p.getItem(replace);
            if (item != null) {
                Intent intent2 = new Intent();
                intent2.setAction("com.android.vending.INSTALL_REFERRER");
                intent2.putExtra("referrer", item.referrer);
                intent2.setPackage(item.packageName);
                intent2.setFlags(32);
                context.sendBroadcast(intent2);
                C1922m.m5797b("AdProxy", "Sended pending install referrer broadcast for app: " + item.packageName);
                SAM.f2623p.update(new InstallReferrerCacheObject(item.packageName, "", InstallReferrerCacheObject.STATE_DONE));
                if (VERSION.SDK_INT >= 11 || context.getPackageManager().getInstallerPackageName(intent.getData().getEncodedSchemeSpecificPart()) != null) {
                    context.getPackageManager().setInstallerPackageName(intent.getData().getEncodedSchemeSpecificPart(), context.getPackageName());
                }
            }
            C1922m.m5797b(PackageInstalledReceiver.class.getName(), "Received action " + intent.getAction() + " for " + replace);
        } catch (Exception e) {
            C1922m.m5790a(e);
        }
    }
}
