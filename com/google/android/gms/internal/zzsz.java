package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.Container;

class zzsz {
    private final Context mContext;
    private final zzta zzmB;

    class zza implements com.google.android.gms.internal.zzre.zza {
        private final Tracker zzBL;

        zza(Tracker tracker) {
            this.zzBL = tracker;
        }

        public void zza(zzrh com_google_android_gms_internal_zzrh) {
            this.zzBL.setScreenName(com_google_android_gms_internal_zzrh.zzre());
            ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
            screenViewBuilder.set("&a", String.valueOf(com_google_android_gms_internal_zzrh.zzaF()));
            this.zzBL.send(screenViewBuilder.build());
        }

        public void zza(zzrh com_google_android_gms_internal_zzrh, Activity activity) {
        }
    }

    public zzsz(Context context, Container container, zzta com_google_android_gms_internal_zzta) {
        this.mContext = context;
        this.zzmB = zza(container, com_google_android_gms_internal_zzta);
        zzrw();
    }

    static zzta zza(Container container, zzta com_google_android_gms_internal_zzta) {
        if (container == null || container.isDefault()) {
            return com_google_android_gms_internal_zzta;
        }
        com.google.android.gms.internal.zzta.zza com_google_android_gms_internal_zzta_zza = new com.google.android.gms.internal.zzta.zza(com_google_android_gms_internal_zzta.zzrx());
        com_google_android_gms_internal_zzta_zza.zzcA(container.getString("trackingId")).zzab(container.getBoolean("trackScreenViews")).zzac(container.getBoolean("collectAdIdentifiers"));
        return com_google_android_gms_internal_zzta_zza.zzrA();
    }

    private void zzrw() {
        if (this.zzmB.zzry() && !TextUtils.isEmpty(this.zzmB.zzgL())) {
            Tracker zzcz = zzcz(this.zzmB.zzgL());
            zzcz.enableAdvertisingIdCollection(this.zzmB.zzrz());
            zzb(new zza(zzcz));
        }
    }

    void zzb(com.google.android.gms.internal.zzre.zza com_google_android_gms_internal_zzre_zza) {
        zzx.zzl(com_google_android_gms_internal_zzre_zza);
        zzre zzag = zzre.zzag(this.mContext);
        zzag.zzZ(true);
        zzag.zza(com_google_android_gms_internal_zzre_zza);
    }

    Tracker zzcz(String str) {
        return GoogleAnalytics.getInstance(this.mContext).newTracker(str);
    }

    public zzta zzrv() {
        return this.zzmB;
    }
}
