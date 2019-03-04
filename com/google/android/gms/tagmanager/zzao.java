package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzao extends zzaj {
    private static final String ID = zza.HASH.toString();
    private static final String zzayC = zzb.ARG0.toString();
    private static final String zzayE = zzb.INPUT_FORMAT.toString();
    private static final String zzayI = zzb.ALGORITHM.toString();

    public zzao() {
        super(ID, zzayC);
    }

    private byte[] zze(String str, byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayC);
        if (com_google_android_gms_internal_zzd_zza == null || com_google_android_gms_internal_zzd_zza == zzde.zzuf()) {
            return zzde.zzuf();
        }
        byte[] bytes;
        String zzg = zzde.zzg(com_google_android_gms_internal_zzd_zza);
        com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayI);
        String zzg2 = com_google_android_gms_internal_zzd_zza == null ? "MD5" : zzde.zzg(com_google_android_gms_internal_zzd_zza);
        com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzayE);
        String zzg3 = com_google_android_gms_internal_zzd_zza == null ? "text" : zzde.zzg(com_google_android_gms_internal_zzd_zza);
        if ("text".equals(zzg3)) {
            bytes = zzg.getBytes();
        } else if ("base16".equals(zzg3)) {
            bytes = zzj.zzcL(zzg);
        } else {
            zzbf.zzZ("Hash: unknown input format: " + zzg3);
            return zzde.zzuf();
        }
        try {
            return zzde.zzx(zzj.zze(zze(zzg2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            zzbf.zzZ("Hash: unknown algorithm: " + zzg2);
            return zzde.zzuf();
        }
    }

    public boolean zzsD() {
        return true;
    }
}
