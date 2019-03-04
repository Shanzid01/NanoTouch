package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzd.zza;
import java.util.Map;

abstract class zzbu extends zzbz {
    public zzbu(String str) {
        super(str);
    }

    protected boolean zza(zza com_google_android_gms_internal_zzd_zza, zza com_google_android_gms_internal_zzd_zza2, Map<String, zza> map) {
        zzdd zzh = zzde.zzh(com_google_android_gms_internal_zzd_zza);
        zzdd zzh2 = zzde.zzh(com_google_android_gms_internal_zzd_zza2);
        return (zzh == zzde.zzud() || zzh2 == zzde.zzud()) ? false : zza(zzh, zzh2, (Map) map);
    }

    protected abstract boolean zza(zzdd com_google_android_gms_tagmanager_zzdd, zzdd com_google_android_gms_tagmanager_zzdd2, Map<String, zza> map);
}
