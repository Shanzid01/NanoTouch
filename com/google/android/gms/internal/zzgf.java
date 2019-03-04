package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.zzhe.zza;

@zzgi
public class zzgf extends zzgb {
    private zzdr zzlD;
    private zzdk zzsf;
    private zzdi zzvW;
    protected zzdo zzvX;

    zzgf(Context context, zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic, zzdr com_google_android_gms_internal_zzdr, zzgc.zza com_google_android_gms_internal_zzgc_zza) {
        super(context, com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic, com_google_android_gms_internal_zzgc_zza);
        this.zzlD = com_google_android_gms_internal_zzdr;
        this.zzsf = com_google_android_gms_internal_zzhe_zza.zzyt;
    }

    public void onStop() {
        synchronized (this.zzvM) {
            super.onStop();
            if (this.zzvW != null) {
                this.zzvW.cancel();
            }
        }
    }

    protected void zzg(long j) {
        synchronized (this.zzvM) {
            this.zzvW = new zzdi(this.mContext, this.zzvN.zzyy, this.zzlD, this.zzsf);
        }
        this.zzvX = this.zzvW.zza(j, 60000);
        switch (this.zzvX.zzsK) {
            case 0:
                return;
            case 1:
                throw new zzgb.zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zzgb.zza("Unexpected mediation result: " + this.zzvX.zzsK, 0);
        }
    }

    protected zzhe zzt(int i) {
        zzgo com_google_android_gms_internal_zzgo = this.zzvN.zzyy;
        return new zzhe(com_google_android_gms_internal_zzgo.zzwn, this.zzmu, this.zzvO.zzst, i, this.zzvO.zzsu, this.zzvO.zzwK, this.zzvO.orientation, this.zzvO.zzsx, com_google_android_gms_internal_zzgo.zzwq, this.zzvO.zzwI, this.zzvX != null ? this.zzvX.zzsL : null, this.zzvX != null ? this.zzvX.zzsM : null, this.zzvX != null ? this.zzvX.zzsN : AdMobAdapter.class.getName(), this.zzsf, this.zzvX != null ? this.zzvX.zzsO : null, this.zzvO.zzwJ, this.zzvN.zzlV, this.zzvO.zzwH, this.zzvN.zzyv, this.zzvO.zzwM, this.zzvO.zzwN, this.zzvN.zzys, null, com_google_android_gms_internal_zzgo.zzwD);
    }
}
