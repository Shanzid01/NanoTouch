package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrf;

class zzg implements zzq {
    protected String zzBa;
    protected String zzBb;
    protected String zzBc;
    protected String zzBd;

    zzg(zzra com_google_android_gms_internal_zzra) {
        zzrf zzqU = com_google_android_gms_internal_zzra.zzqU();
        this.zzBc = zzqU.zznE();
        this.zzBd = zzqU.zzra();
        this.zzBa = zzqU.zzga();
        this.zzBb = zzqU.zzgc();
    }

    public String getValue(String str) {
        return str == null ? null : str.equals("&an") ? this.zzBa : str.equals("&av") ? this.zzBb : str.equals("&aid") ? this.zzBc : str.equals("&aiid") ? this.zzBd : null;
    }

    public boolean zzaj(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }
}
