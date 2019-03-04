package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd.zza;
import java.util.Map;
import java.util.Set;

public abstract class zzbz extends zzaj {
    private static final String zzayC = zzb.ARG0.toString();
    private static final String zzazv = zzb.ARG1.toString();

    public zzbz(String str) {
        super(str, zzayC, zzazv);
    }

    public zza zzH(Map<String, zza> map) {
        for (zza com_google_android_gms_internal_zzd_zza : map.values()) {
            if (com_google_android_gms_internal_zzd_zza == zzde.zzuf()) {
                return zzde.zzx(Boolean.valueOf(false));
            }
        }
        zza com_google_android_gms_internal_zzd_zza2 = (zza) map.get(zzayC);
        zza com_google_android_gms_internal_zzd_zza3 = (zza) map.get(zzazv);
        boolean zza = (com_google_android_gms_internal_zzd_zza2 == null || com_google_android_gms_internal_zzd_zza3 == null) ? false : zza(com_google_android_gms_internal_zzd_zza2, com_google_android_gms_internal_zzd_zza3, map);
        return zzde.zzx(Boolean.valueOf(zza));
    }

    protected abstract boolean zza(zza com_google_android_gms_internal_zzd_zza, zza com_google_android_gms_internal_zzd_zza2, Map<String, zza> map);

    public boolean zzsD() {
        return true;
    }

    public /* bridge */ /* synthetic */ String zzth() {
        return super.zzth();
    }

    public /* bridge */ /* synthetic */ Set zzti() {
        return super.zzti();
    }
}
