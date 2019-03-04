package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.zze;

@zzgi
public class zzch implements CustomRenderedAd {
    private final zzci zzrj;

    public zzch(zzci com_google_android_gms_internal_zzci) {
        this.zzrj = com_google_android_gms_internal_zzci;
    }

    public String getBaseUrl() {
        try {
            return this.zzrj.zzcv();
        } catch (Throwable e) {
            zzhx.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzrj.getContent();
        } catch (Throwable e) {
            zzhx.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzrj.zza(view != null ? zze.zzn(view) : null);
        } catch (Throwable e) {
            zzhx.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzrj.recordClick();
        } catch (Throwable e) {
            zzhx.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzrj.recordImpression();
        } catch (Throwable e) {
            zzhx.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
