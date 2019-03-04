package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhe.zza;

@zzgi
public class zzga extends zzfy {
    zzga(Context context, zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic, zzgc.zza com_google_android_gms_internal_zzgc_zza) {
        super(context, com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic, com_google_android_gms_internal_zzgc_zza);
    }

    protected void zzg(long j) {
        int i;
        int i2;
        zzba zzad = this.zzmu.zzad();
        if (zzad.zzpb) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = zzad.widthPixels;
            i2 = zzad.heightPixels;
        }
        final zzfz com_google_android_gms_internal_zzfz = new zzfz(this, this.zzmu, i, i2);
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzga zzvK;

            public void run() {
                synchronized (this.zzvK.zznh) {
                    if (this.zzvK.zzvO.errorCode != -2) {
                        return;
                    }
                    this.zzvK.zzmu.zzeG().zza(this.zzvK);
                    com_google_android_gms_internal_zzfz.zza(this.zzvK.zzvO);
                }
            }
        });
        zzf(j);
        if (com_google_android_gms_internal_zzfz.zzdE()) {
            zzhx.zzY("Ad-Network indicated no fill with passback URL.");
            throw new zzgb.zza("AdNetwork sent passback url", 3);
        } else if (!com_google_android_gms_internal_zzfz.zzdF()) {
            throw new zzgb.zza("AdNetwork timed out", 2);
        }
    }
}
