package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;

public class zzem {
    public void zza(Context context, zzeo com_google_android_gms_internal_zzeo) {
        zza(context, com_google_android_gms_internal_zzeo, true);
    }

    public void zza(Context context, zzeo com_google_android_gms_internal_zzeo, boolean z) {
        if (com_google_android_gms_internal_zzeo.zzuw == 4 && com_google_android_gms_internal_zzeo.zzup == null) {
            if (com_google_android_gms_internal_zzeo.zzuo != null) {
                com_google_android_gms_internal_zzeo.zzuo.onAdClicked();
            }
            zzab.zzaJ().zza(context, com_google_android_gms_internal_zzeo.zzun, com_google_android_gms_internal_zzeo.zzuv);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", com_google_android_gms_internal_zzeo.zzlP.zzzK);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        zzeo.zza(intent, com_google_android_gms_internal_zzeo);
        if (!zzme.zzkk()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }
}
