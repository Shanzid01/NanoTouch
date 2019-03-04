package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzd.zza;
import java.util.Map;

abstract class zzcy extends zzbz {
    public zzcy(String str) {
        super(str);
    }

    protected boolean zza(zza com_google_android_gms_internal_zzd_zza, zza com_google_android_gms_internal_zzd_zza2, Map<String, zza> map) {
        String zzg = zzde.zzg(com_google_android_gms_internal_zzd_zza);
        String zzg2 = zzde.zzg(com_google_android_gms_internal_zzd_zza2);
        return (zzg == zzde.zzue() || zzg2 == zzde.zzue()) ? false : zza(zzg, zzg2, (Map) map);
    }

    protected abstract boolean zza(String str, String str2, Map<String, zza> map);
}
