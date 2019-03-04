package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzac extends zzaj {
    private static final String ID = zza.ENCODE.toString();
    private static final String zzayC = zzb.ARG0.toString();
    private static final String zzayD = zzb.NO_PADDING.toString();
    private static final String zzayE = zzb.INPUT_FORMAT.toString();
    private static final String zzayF = zzb.OUTPUT_FORMAT.toString();

    public zzac() {
        super(ID, zzayC);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayC);
        if (com_google_android_gms_internal_zzd_zza == null || com_google_android_gms_internal_zzd_zza == zzde.zzuf()) {
            return zzde.zzuf();
        }
        String zzg = zzde.zzg(com_google_android_gms_internal_zzd_zza);
        com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayE);
        String zzg2 = com_google_android_gms_internal_zzd_zza == null ? "text" : zzde.zzg(com_google_android_gms_internal_zzd_zza);
        com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayF);
        String zzg3 = com_google_android_gms_internal_zzd_zza == null ? "base16" : zzde.zzg(com_google_android_gms_internal_zzd_zza);
        com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayD);
        int i = (com_google_android_gms_internal_zzd_zza == null || !zzde.zzk(com_google_android_gms_internal_zzd_zza).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object zze;
            if ("text".equals(zzg2)) {
                bytes = zzg.getBytes();
            } else if ("base16".equals(zzg2)) {
                bytes = zzj.zzcL(zzg);
            } else if ("base64".equals(zzg2)) {
                bytes = Base64.decode(zzg, i);
            } else if ("base64url".equals(zzg2)) {
                bytes = Base64.decode(zzg, i | 8);
            } else {
                zzbf.zzZ("Encode: unknown input format: " + zzg2);
                return zzde.zzuf();
            }
            if ("base16".equals(zzg3)) {
                zze = zzj.zze(bytes);
            } else if ("base64".equals(zzg3)) {
                zze = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(zzg3)) {
                zze = Base64.encodeToString(bytes, i | 8);
            } else {
                zzbf.zzZ("Encode: unknown output format: " + zzg3);
                return zzde.zzuf();
            }
            return zzde.zzx(zze);
        } catch (IllegalArgumentException e) {
            zzbf.zzZ("Encode: invalid input:");
            return zzde.zzuf();
        }
    }

    public boolean zzsD() {
        return true;
    }
}
