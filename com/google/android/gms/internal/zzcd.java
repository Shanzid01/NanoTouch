package com.google.android.gms.internal;

import android.text.TextUtils;

public class zzcd {
    private boolean zzqO = false;

    private zzcc zzb(zzcb com_google_android_gms_internal_zzcb, int i) {
        zzcc com_google_android_gms_internal_zzcc = new zzcc(com_google_android_gms_internal_zzcb.getContext(), com_google_android_gms_internal_zzcb.zzaX(), com_google_android_gms_internal_zzcb.zzce(), com_google_android_gms_internal_zzcb.zzcf(), com_google_android_gms_internal_zzcb.zzcg(), com_google_android_gms_internal_zzcb.zzch(), com_google_android_gms_internal_zzcb.zzci(), com_google_android_gms_internal_zzcb.zzcj(), i);
        this.zzqO = true;
        return com_google_android_gms_internal_zzcc;
    }

    public zzcc zza(zzcb com_google_android_gms_internal_zzcb) {
        return zza(com_google_android_gms_internal_zzcb, 1);
    }

    public zzcc zza(zzcb com_google_android_gms_internal_zzcb, int i) {
        if (com_google_android_gms_internal_zzcb == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!com_google_android_gms_internal_zzcb.zzcd()) {
            zzhx.zzaa("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (com_google_android_gms_internal_zzcb.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcb.zzaX())) {
            return zzb(com_google_android_gms_internal_zzcb, i);
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }

    public zzcc zzb(zzcb com_google_android_gms_internal_zzcb) {
        return zza(com_google_android_gms_internal_zzcb, 2);
    }

    public boolean zzcd() {
        return this.zzqO;
    }
}
