package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrg;

class zzai implements zzq {
    private final zzra zzAM;

    zzai(zzra com_google_android_gms_internal_zzra) {
        zzx.zzl(com_google_android_gms_internal_zzra);
        this.zzAM = com_google_android_gms_internal_zzra;
    }

    public String getValue(String str) {
        return "&sr".equals(str) ? zzgC() : null;
    }

    public boolean zzaj(String str) {
        return "&sr".equals(str);
    }

    protected String zzgC() {
        zzrg zzqV = this.zzAM.zzqV();
        return zzqV.zzrb() + "x" + zzqV.zzrc();
    }
}
