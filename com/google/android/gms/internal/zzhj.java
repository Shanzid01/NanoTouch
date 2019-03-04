package com.google.android.gms.internal;

import android.os.Bundle;

@zzgi
public class zzhj {
    private final zzhg zzmV;
    private final Object zznh;
    private final String zzyC;
    private int zzze;
    private int zzzf;

    zzhj(zzhg com_google_android_gms_internal_zzhg, String str) {
        this.zznh = new Object();
        this.zzmV = com_google_android_gms_internal_zzhg;
        this.zzyC = str;
    }

    public zzhj(String str) {
        this(zzab.zzaP(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zznh) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzze);
            bundle.putInt("pmnll", this.zzzf);
        }
        return bundle;
    }

    public void zzg(int i, int i2) {
        synchronized (this.zznh) {
            this.zzze = i;
            this.zzzf = i2;
            this.zzmV.zza(this.zzyC, this);
        }
    }
}
