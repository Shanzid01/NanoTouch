package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zzo {
    private static final Uri zzQo = Uri.parse("http://plus.google.com/");
    private static final Uri zzQp = zzQo.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent zzbj(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    private static Uri zzbk(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }

    public static Intent zzbl(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(zzbk(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(524288);
        return intent;
    }

    public static Intent zzjl() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
