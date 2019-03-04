package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.internal.zzbm.zza;

@zzgi
public class zzz extends zza implements zzre.zza, zztb.zza {
    private static zzz zzmA;
    private static final Object zzmz = new Object();
    private final Context mContext;
    zzta zzmB;
    String zzmC;
    String zzmD;
    private boolean zzmE = false;

    zzz(Context context) {
        this.mContext = context;
    }

    public static zzz zzj(Context context) {
        zzz com_google_android_gms_internal_zzz;
        synchronized (zzmz) {
            if (zzmA == null) {
                zzmA = new zzz(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzz = zzmA;
        }
        return com_google_android_gms_internal_zzz;
    }

    public String getClientId() {
        return GoogleAnalytics.getInstance(this.mContext).getClientId();
    }

    public boolean isInitialized() {
        boolean z;
        synchronized (zzmz) {
            z = this.zzmE;
        }
        return z;
    }

    public void zza(zzrh com_google_android_gms_internal_zzrh) {
    }

    public void zza(zzrh com_google_android_gms_internal_zzrh, Activity activity) {
        if (com_google_android_gms_internal_zzrh != null && activity != null) {
            if (activity instanceof AdActivity) {
                int zzk = zzab.zzaM().zzk(activity);
                if (zzk == 1) {
                    com_google_android_gms_internal_zzrh.zzaa(true);
                    com_google_android_gms_internal_zzrh.setScreenName("Interstitial Ad");
                } else if (zzk == 2 || zzk == 3) {
                    com_google_android_gms_internal_zzrh.setScreenName("Expanded Ad");
                } else {
                    com_google_android_gms_internal_zzrh.setScreenName(null);
                }
            } else if (activity instanceof InAppPurchaseActivity) {
                com_google_android_gms_internal_zzrh.setScreenName(null);
            }
        }
    }

    public void zza(String str, String str2) {
        synchronized (zzmz) {
            if (this.mContext == null) {
                zzhx.zzac("Fail to initialize MobileAdsSettingManager because context is null.");
            } else if (TextUtils.isEmpty(str)) {
                zzhx.zzac("Fail to initialize MobileAdsSettingManager because ApplicationCode is empty.");
            } else if (this.zzmE) {
                zzhx.zzaa("MobileAdsSettingManager has been initialized.");
            } else {
                this.zzmE = true;
                this.zzmC = str;
                this.zzmD = str2;
                zztb zzah = zztb.zzah(this.mContext);
                zzta.zza com_google_android_gms_internal_zzta_zza = new zzta.zza(this.zzmC);
                if (!TextUtils.isEmpty(this.zzmD)) {
                    com_google_android_gms_internal_zzta_zza.zzcA(this.zzmD);
                }
                zzah.zza(com_google_android_gms_internal_zzta_zza.zzrA());
                zzah.zza((zztb.zza) this);
                zzre.zzag(this.mContext).zza(this);
                zzah.start();
            }
        }
    }

    public void zzaE() {
        this.zzmB = zztb.zzah(this.mContext).zzrB();
    }

    public int zzaF() {
        zzrh zzqW = zzre.zzag(this.mContext).zzqW();
        return zzqW != null ? zzqW.zzaF() : 0;
    }
}
