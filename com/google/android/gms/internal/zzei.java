package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@zzgi
public class zzei {
    public boolean zza(Context context, zzek com_google_android_gms_internal_zzek, zzes com_google_android_gms_internal_zzes) {
        if (com_google_android_gms_internal_zzek == null) {
            zzhx.zzac("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzek.zztR)) {
            zzhx.zzac("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzek.mimeType)) {
            intent.setData(Uri.parse(com_google_android_gms_internal_zzek.zztR));
        } else {
            intent.setDataAndType(Uri.parse(com_google_android_gms_internal_zzek.zztR), com_google_android_gms_internal_zzek.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzek.packageName)) {
            intent.setPackage(com_google_android_gms_internal_zzek.packageName);
        }
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzek.zztS)) {
            String[] split = com_google_android_gms_internal_zzek.zztS.split("/", 2);
            if (split.length < 2) {
                zzhx.zzac("Could not parse component name from open GMSG: " + com_google_android_gms_internal_zzek.zztS);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        Object obj = com_google_android_gms_internal_zzek.zztT;
        if (!TextUtils.isEmpty(obj)) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(obj);
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse intent flags.");
                parseInt = 0;
            }
            intent.addFlags(parseInt);
        }
        try {
            zzhx.zzab("Launching an intent: " + intent.toURI());
            context.startActivity(intent);
            if (com_google_android_gms_internal_zzes != null) {
                com_google_android_gms_internal_zzes.zzae();
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            zzhx.zzac(e2.getMessage());
            return false;
        }
    }
}
