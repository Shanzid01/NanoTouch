package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzco.zza;

@zzgi
public class zzcl extends zza implements zzcn.zza {
    private final Object zznh = new Object();
    private final String zzrk;
    private final Drawable zzrl;
    private final String zzrm;
    private final Drawable zzrn;
    private final String zzro;
    private final double zzrp;
    private final String zzrq;
    private final String zzrr;
    private zzcn zzrs;

    public zzcl(String str, Drawable drawable, String str2, Drawable drawable2, String str3, double d, String str4, String str5) {
        this.zzrk = str;
        this.zzrl = drawable;
        this.zzrm = str2;
        this.zzrn = drawable2;
        this.zzro = str3;
        this.zzrp = d;
        this.zzrq = str4;
        this.zzrr = str5;
    }

    public String getBody() {
        return this.zzrm;
    }

    public void recordImpression() {
        synchronized (this.zznh) {
            if (this.zzrs == null) {
                zzhx.zzZ("Attempt to record impression before app install ad initialized.");
                return;
            }
            this.zzrs.recordImpression();
        }
    }

    public void zza(zzcn com_google_android_gms_internal_zzcn) {
        synchronized (this.zznh) {
            this.zzrs = com_google_android_gms_internal_zzcn;
        }
    }

    public double zzcA() {
        return this.zzrp;
    }

    public String zzcB() {
        return this.zzrq;
    }

    public String zzcC() {
        return this.zzrr;
    }

    public String zzcw() {
        return this.zzrk;
    }

    public zzd zzcx() {
        return zze.zzn(this.zzrl);
    }

    public zzd zzcy() {
        return zze.zzn(this.zzrn);
    }

    public String zzcz() {
        return this.zzro;
    }

    public void zzl(int i) {
        synchronized (this.zznh) {
            if (this.zzrs == null) {
                zzhx.zzZ("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.zzrs.zzb("2", i);
        }
    }
}
