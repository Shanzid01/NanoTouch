package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdActivity;

@zzgi
public class zzhh {
    private final Object zznh = new Object();
    final String zzyL;
    long zzyZ = -1;
    long zzza = -1;
    int zzzb = -1;
    int zzzc = 0;
    int zzzd = 0;

    public zzhh(String str) {
        this.zzyL = str;
    }

    public static boolean zzp(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            zzhx.zzaa("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzhx.zzaa("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            zzhx.zzac("Fail to fetch AdActivity theme");
            zzhx.zzaa("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzb(zzax com_google_android_gms_internal_zzax, long j) {
        synchronized (this.zznh) {
            if (this.zzza == -1) {
                this.zzza = j;
                this.zzyZ = this.zzza;
            } else {
                this.zzyZ = j;
            }
            if (com_google_android_gms_internal_zzax.extras == null || com_google_android_gms_internal_zzax.extras.getInt("gw", 2) != 1) {
                this.zzzb++;
                return;
            }
        }
    }

    public Bundle zzc(Context context, String str) {
        Bundle bundle;
        synchronized (this.zznh) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzyL);
            bundle.putLong("basets", this.zzza);
            bundle.putLong("currts", this.zzyZ);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzzb);
            bundle.putInt("pclick", this.zzzc);
            bundle.putInt("pimp", this.zzzd);
            bundle.putBoolean("support_transparent_background", zzp(context));
        }
        return bundle;
    }

    public void zzdX() {
        synchronized (this.zznh) {
            this.zzzd++;
        }
    }

    public void zzdY() {
        synchronized (this.zznh) {
            this.zzzc++;
        }
    }

    public long zzeo() {
        return this.zzza;
    }
}
