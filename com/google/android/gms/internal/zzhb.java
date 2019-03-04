package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

@zzgi
public final class zzhb {
    public final int zzwx;
    public final int zzwy;
    public final float zzwz;
    public final int zzxY;
    public final boolean zzxZ;
    public final boolean zzya;
    public final String zzyb;
    public final String zzyc;
    public final boolean zzyd;
    public final boolean zzye;
    public final boolean zzyf;
    public final String zzyg;
    public final String zzyh;
    public final int zzyi;
    public final int zzyj;
    public final int zzyk;
    public final int zzyl;
    public final int zzym;
    public final int zzyn;
    public final double zzyo;
    public final boolean zzyp;
    public final boolean zzyq;
    public final int zzyr;

    public zzhb(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.zzxY = audioManager.getMode();
        this.zzxZ = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzya = zza(packageManager, "http://www.google.com") != null;
        this.zzyb = telephonyManager.getNetworkOperator();
        this.zzyc = locale.getCountry();
        this.zzyd = zzbe.zzbD().zzeB();
        this.zzye = audioManager.isMusicActive();
        this.zzyf = audioManager.isSpeakerphoneOn();
        this.zzyg = locale.getLanguage();
        this.zzyh = zza(packageManager);
        this.zzyi = audioManager.getStreamVolume(3);
        this.zzyj = zza(context, connectivityManager, packageManager);
        this.zzyk = telephonyManager.getNetworkType();
        this.zzyl = telephonyManager.getPhoneType();
        this.zzym = audioManager.getRingerMode();
        this.zzyn = audioManager.getStreamVolume(2);
        this.zzwz = displayMetrics.density;
        this.zzwx = displayMetrics.widthPixels;
        this.zzwy = displayMetrics.heightPixels;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzyo = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (!(intExtra == 2 || intExtra == 5)) {
                z = false;
            }
            this.zzyp = z;
        } else {
            this.zzyo = -1.0d;
            this.zzyp = false;
        }
        if (VERSION.SDK_INT >= 16) {
            this.zzyq = connectivityManager.isActiveNetworkMetered();
            if (connectivityManager.getActiveNetworkInfo() != null) {
                this.zzyr = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
                return;
            } else {
                this.zzyr = -1;
                return;
            }
        }
        this.zzyq = false;
        this.zzyr = -1;
    }

    private static int zza(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!zzab.zzaM().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : -1;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String zza(PackageManager packageManager) {
        String str = null;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza != null) {
            ActivityInfo activityInfo = zza.activityInfo;
            if (activityInfo != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                    if (packageInfo != null) {
                        str = packageInfo.versionCode + "." + activityInfo.packageName;
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return str;
    }
}
