package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzd.zza;
import java.net.URLEncoder;

class zzdi {
    private static zzbv<zza> zza(zzbv<zza> com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza) {
        try {
            return new zzbv(zzde.zzx(zzdv(zzde.zzg((zza) com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza.getObject()))), com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza.zztu());
        } catch (Throwable e) {
            zzbf.zzb("Escape URI: unsupported encoding", e);
            return com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza;
        }
    }

    private static zzbv<zza> zza(zzbv<zza> com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza, int i) {
        if (zzn((zza) com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza.getObject())) {
            switch (i) {
                case 12:
                    return zza(com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza);
                default:
                    zzbf.zzZ("Unsupported Value Escaping: " + i);
                    return com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza;
            }
        }
        zzbf.zzZ("Escaping can only be applied to strings.");
        return com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza;
    }

    static zzbv<zza> zza(zzbv<zza> com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza, int... iArr) {
        zzbv zza;
        for (int zza2 : iArr) {
            zza = zza(zza, zza2);
        }
        return zza;
    }

    static String zzdv(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(zza com_google_android_gms_internal_zzd_zza) {
        return zzde.zzl(com_google_android_gms_internal_zzd_zza) instanceof String;
    }
}
