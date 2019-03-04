package com.google.android.gms.internal;

import android.util.Log;

@zzgi
public final class zzhx {
    public static boolean zzA(int i) {
        return (i >= 5 || Log.isLoggable("Ads", i)) && i != 2;
    }

    public static void zzY(String str) {
        if (zzA(3)) {
            Log.d("Ads", str);
        }
    }

    public static void zzZ(String str) {
        if (zzA(6)) {
            Log.e("Ads", str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzA(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void zzaa(String str) {
        if (zzA(4)) {
            Log.i("Ads", str);
        }
    }

    public static void zzab(String str) {
        if (zzA(2)) {
            Log.v("Ads", str);
        }
    }

    public static void zzac(String str) {
        if (zzA(5)) {
            Log.w("Ads", str);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzA(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (zzA(4)) {
            Log.i("Ads", str, th);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (zzA(5)) {
            Log.w("Ads", str, th);
        }
    }
}
