package com.slideme.sam.manager.controller.p055b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import com.google.android.gms.drive.DriveFile;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.SamUpdateActivity;
import com.slideme.sam.manager.controller.activities.market.catalog.UpdatesListActivity;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.market.userinfo.MyAppsActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.p061a.C1818f;
import com.slideme.sam.manager.model.service.ApplicationDownloadService;
import com.slideme.sam.manager.model.service.LaunchOrInstallService;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.view.C1950a;
import java.util.List;

/* compiled from: NotificationFactory */
public abstract class C1704f {
    @SuppressLint({"InlinedApi"})
    public static Notification m5070a(Context context) {
        Builder builder = new Builder(context);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setContentTitle(new StringBuilder(String.valueOf(context.getResources().getString(R.string.title_application))).append(": ").append(context.getResources().getQuantityString(R.plurals.updates_available, 1, new Object[]{Integer.valueOf(1)})).toString());
        builder.setContentText(context.getString(R.string.touch_to_update));
        builder.setAutoCancel(true);
        new Intent(context, SamUpdateActivity.class).setFlags(1350598656);
        builder.setContentIntent(PendingIntent.getActivity(context, 4, C1818f.m5456a(context), 0));
        return builder.build();
    }

    public static Notification m5076b(Context context) {
        Builder builder = new Builder(context);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setContentTitle(new StringBuilder(String.valueOf(context.getResources().getString(R.string.title_application))).append(": ").append(context.getResources().getQuantityString(R.plurals.updates_available, 1, new Object[]{Integer.valueOf(1)})).toString());
        builder.setContentText(context.getString(R.string.touch_to_update));
        builder.setAutoCancel(true);
        builder.setContentIntent(PendingIntent.getActivity(context, 4, C1818f.m5459b(context), 0));
        return builder.build();
    }

    @SuppressLint({"InlinedApi"})
    public static Notification m5075a(Context context, List<Application> list) {
        int i;
        int size = list.size();
        CharSequence quantityString = context.getResources().getQuantityString(R.plurals.updates_available_count, size, new Object[]{Integer.valueOf(size)});
        String[] strArr = new String[size];
        for (i = 0; i < size; i++) {
            strArr[i] = ((Application) list.get(i)).bundleId;
        }
        Builder builder = new Builder(context);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setContentTitle(context.getResources().getQuantityString(R.plurals.updates_available, size, new Object[]{Integer.valueOf(size)}));
        builder.setContentText(quantityString);
        builder.setNumber(size);
        builder.setPriority(-1);
        Style bigTextStyle = new BigTextStyle();
        bigTextStyle.setBigContentTitle(context.getResources().getQuantityString(R.plurals.updated_apps_plural, size, new Object[]{Integer.valueOf(size)}));
        CharSequence stringBuilder = new StringBuilder();
        for (i = 0; i < size; i++) {
            stringBuilder.append(((Application) list.get(i)).getName());
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        bigTextStyle.bigText(stringBuilder);
        builder.setStyle(bigTextStyle);
        builder.setAutoCancel(true);
        Intent intent = new Intent(context, UpdatesListActivity.class);
        intent.setFlags(268468224);
        builder.setContentIntent(PendingIntent.getActivity(context, 3, intent, 0));
        return builder.build();
    }

    public static Notification m5071a(Context context, int i) {
        Builder builder = new Builder(context);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setContentTitle(context.getResources().getQuantityString(R.plurals.webbuy_notification_title, i, new Object[]{Integer.valueOf(i)}));
        builder.setContentText(context.getString(R.string.webbuy_notification_message));
        builder.setAutoCancel(true);
        builder.setContentIntent(PendingIntent.getActivity(context, 5, new Intent(context, MyAppsActivity.class), 0));
        return builder.build();
    }

    public static Notification m5074a(Context context, Application application, boolean z, int i, int i2) {
        Builder builder = new Builder(context);
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setWhen(0);
        builder.setOngoing(false);
        builder.setProgress(i2, i, z);
        if (z) {
            builder.setContentText(context.getString(R.string.download_waiting));
        } else {
            builder.setContentText(new StringBuilder(String.valueOf(C1950a.m5858a((long) i))).append("/").append(C1950a.m5858a((long) i2)).toString());
        }
        builder.setContentTitle(application.getName());
        builder.setAutoCancel(false);
        builder.setPriority(0);
        Intent intent = new Intent(context, ApplicationDetailsActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", application.bundleId);
        intent.putExtra("com.slideme.sam.manager.EXTRA_TOKEN", application.token);
        builder.setContentIntent(PendingIntent.getActivity(context, Integer.valueOf(application.nodeId).intValue(), intent, 0));
        return builder.build();
    }

    public static Notification m5072a(Context context, Application application) {
        Builder builder = new Builder(context);
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setAutoCancel(true);
        builder.setOngoing(false);
        builder.setContentTitle(application.getName());
        builder.setContentText(context.getString(R.string.download_finished_notif));
        builder.setPriority(-1);
        Intent intent = new Intent(context, LaunchOrInstallService.class);
        C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        builder.setContentIntent(PendingIntent.getService(context, Integer.valueOf(application.nodeId).intValue(), intent, 0));
        return builder.build();
    }

    public static Notification m5073a(Context context, Application application, boolean z) {
        Builder builder = new Builder(context);
        builder.setSmallIcon(R.drawable.ic_notification_update);
        builder.setAutoCancel(true);
        builder.setOngoing(false);
        builder.setContentTitle(application.getName());
        builder.setContentText(context.getString(z ? R.string.install_success_notif : R.string.install_failure_notif));
        builder.setPriority(-1);
        Intent intent = new Intent(context, LaunchOrInstallService.class);
        C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        builder.setContentIntent(PendingIntent.getService(context, Integer.valueOf(application.nodeId).intValue(), intent, 0));
        return builder.build();
    }

    public static Notification m5077b(Context context, Application application, boolean z) {
        Builder builder = new Builder(context);
        builder.setSmallIcon(17301543);
        builder.setAutoCancel(false);
        builder.setOngoing(false);
        builder.setContentTitle(application.getName());
        if (z || application.limitedStorageError) {
            builder.setContentText(context.getString(R.string.download_failed_no_space));
        } else {
            builder.setContentText(context.getString(R.string.download_error_notif));
        }
        builder.setPriority(0);
        Intent intent = new Intent(context, ApplicationDownloadService.class);
        C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
        builder.setContentIntent(PendingIntent.getService(context, Integer.valueOf(application.nodeId).intValue(), intent, 0));
        return builder.build();
    }
}
