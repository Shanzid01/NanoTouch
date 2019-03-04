package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzci.zza;

@zzgi
public final class zzcg extends zza {
    private final zzv zzrg;
    private final String zzrh;
    private final String zzri;

    public zzcg(zzv com_google_android_gms_internal_zzv, String str, String str2) {
        this.zzrg = com_google_android_gms_internal_zzv;
        this.zzrh = str;
        this.zzri = str2;
    }

    public String getContent() {
        return this.zzri;
    }

    public void recordClick() {
        this.zzrg.recordClick();
    }

    public void recordImpression() {
        this.zzrg.recordImpression();
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd) {
        if (com_google_android_gms_dynamic_zzd != null) {
            this.zzrg.zzb((View) zze.zzf(com_google_android_gms_dynamic_zzd));
        }
    }

    public String zzcv() {
        return this.zzrh;
    }
}
