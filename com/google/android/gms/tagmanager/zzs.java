package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzs extends zzaj {
    private static final String ID = com.google.android.gms.internal.zza.FUNCTION_CALL.toString();
    private static final String zzaxp = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzayb = zzb.FUNCTION_CALL_NAME.toString();
    private final zza zzayc;

    public interface zza {
        Object zzc(String str, Map<String, Object> map);
    }

    public zzs(zza com_google_android_gms_tagmanager_zzs_zza) {
        super(ID, zzayb);
        this.zzayc = com_google_android_gms_tagmanager_zzs_zza;
    }

    public com.google.android.gms.internal.zzd.zza zzH(Map<String, com.google.android.gms.internal.zzd.zza> map) {
        String zzg = zzde.zzg((com.google.android.gms.internal.zzd.zza) map.get(zzayb));
        Map hashMap = new HashMap();
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza = (com.google.android.gms.internal.zzd.zza) map.get(zzaxp);
        if (com_google_android_gms_internal_zzd_zza != null) {
            Object zzl = zzde.zzl(com_google_android_gms_internal_zzd_zza);
            if (zzl instanceof Map) {
                for (Entry entry : ((Map) zzl).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                zzbf.zzac("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzde.zzuf();
            }
        }
        try {
            return zzde.zzx(this.zzayc.zzc(zzg, hashMap));
        } catch (Exception e) {
            zzbf.zzac("Custom macro/tag " + zzg + " threw exception " + e.getMessage());
            return zzde.zzuf();
        }
    }

    public boolean zzsD() {
        return false;
    }
}
