package com.google.android.gms.internal;

import android.text.TextUtils;

public abstract class zzjt {
    protected final zzkc zzKe;
    private final String zzKf;
    private zzke zzKg;

    protected zzjt(String str, String str2, String str3) {
        zzjv.zzaK(str);
        this.zzKf = str;
        this.zzKe = new zzkc(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.zzKe.zzaP(str3);
        }
    }

    public final String getNamespace() {
        return this.zzKf;
    }

    public final void zza(zzke com_google_android_gms_internal_zzke) {
        this.zzKg = com_google_android_gms_internal_zzke;
        if (this.zzKg == null) {
            zzhm();
        }
    }

    protected final void zza(String str, long j, String str2) {
        this.zzKe.zza("Sending text message: %s to: %s", str, str2);
        this.zzKg.zza(this.zzKf, str, j, str2);
    }

    public void zzaI(String str) {
    }

    public void zzb(long j, int i) {
    }

    public void zzhm() {
    }

    protected final long zzhn() {
        return this.zzKg.zzhk();
    }
}
