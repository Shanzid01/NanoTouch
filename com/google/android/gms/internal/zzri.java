package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.p004b.C0059a;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

public final class zzri implements ActivityLifecycleCallbacks {
    private final zzre zzasy;
    private final Map<Activity, zzrh> zzasz = new C0059a();

    public zzri(zzre com_google_android_gms_internal_zzre) {
        zzx.zzl(com_google_android_gms_internal_zzre);
        this.zzasy = com_google_android_gms_internal_zzre;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.android.gms.measurement.screen_view");
            if (bundle2 != null) {
                int i = bundle2.getInt("id");
                if (i <= 0) {
                    Log.w("com.google.android.gms.measurement.internal.ActivityLifecycleTracker", "Invalid screenId in saved activity state");
                    return;
                }
                zzrh zza = zza(activity, i);
                zza.setScreenName(bundle2.getString("name"));
                zza.zzgr(bundle2.getInt("referrer_id"));
                zza.zzcv(bundle2.getString("referrer_name"));
                zza.zzaa(bundle2.getBoolean("interstitial"));
                zza.zzrh();
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.zzasz.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (bundle != null) {
            zzrh com_google_android_gms_internal_zzrh = (zzrh) this.zzasz.get(activity);
            if (com_google_android_gms_internal_zzrh != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("id", com_google_android_gms_internal_zzrh.zzaF());
                bundle2.putString("name", com_google_android_gms_internal_zzrh.zzre());
                bundle2.putInt("referrer_id", com_google_android_gms_internal_zzrh.zzrf());
                bundle2.putString("referrer_name", com_google_android_gms_internal_zzrh.zzrg());
                bundle2.putBoolean("interstitial", com_google_android_gms_internal_zzrh.zzri());
                bundle.putBundle("com.google.android.gms.measurement.screen_view", bundle2);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        this.zzasy.zzb(zza(activity, 0), activity);
    }

    public void onActivityStopped(Activity activity) {
    }

    zzrh zza(Activity activity, int i) {
        zzx.zzl(activity);
        zzrh com_google_android_gms_internal_zzrh = (zzrh) this.zzasz.get(activity);
        if (com_google_android_gms_internal_zzrh == null) {
            com_google_android_gms_internal_zzrh = i == 0 ? new zzrh(true) : new zzrh(true, i);
            com_google_android_gms_internal_zzrh.setScreenName(activity.getClass().getCanonicalName());
            this.zzasz.put(activity, com_google_android_gms_internal_zzrh);
        }
        return com_google_android_gms_internal_zzrh;
    }
}
