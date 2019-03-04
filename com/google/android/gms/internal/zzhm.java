package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@zzgi
public final class zzhm {
    public static void zza(Context context, int i) {
        Editor edit = zzq(context).edit();
        edit.putInt("webview_cache_version", i);
        edit.commit();
    }

    public static void zza(Context context, boolean z) {
        Editor edit = zzq(context).edit();
        edit.putBoolean("use_https", z);
        edit.commit();
    }

    private static SharedPreferences zzq(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static boolean zzr(Context context) {
        return zzq(context).getBoolean("use_https", true);
    }

    public static int zzs(Context context) {
        return zzq(context).getInt("webview_cache_version", 0);
    }
}
