package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzc.zzc;
import com.google.android.gms.internal.zzc.zzd;
import com.google.android.gms.internal.zzc.zzi;
import com.google.android.gms.internal.zzd.zza;
import java.util.Map;

class zzai {
    private static void zza(DataLayer dataLayer, zzd com_google_android_gms_internal_zzc_zzd) {
        for (zza zzg : com_google_android_gms_internal_zzc_zzd.zzfB) {
            dataLayer.zzcU(zzde.zzg(zzg));
        }
    }

    public static void zza(DataLayer dataLayer, zzi com_google_android_gms_internal_zzc_zzi) {
        if (com_google_android_gms_internal_zzc_zzi.zzgq == null) {
            zzbf.zzac("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, com_google_android_gms_internal_zzc_zzi.zzgq);
        zzb(dataLayer, com_google_android_gms_internal_zzc_zzi.zzgq);
        zzc(dataLayer, com_google_android_gms_internal_zzc_zzi.zzgq);
    }

    private static void zzb(DataLayer dataLayer, zzd com_google_android_gms_internal_zzc_zzd) {
        for (zza zzc : com_google_android_gms_internal_zzc_zzd.zzfA) {
            Map zzc2 = zzc(zzc);
            if (zzc2 != null) {
                dataLayer.push(zzc2);
            }
        }
    }

    private static Map<String, Object> zzc(zza com_google_android_gms_internal_zzd_zza) {
        Object zzl = zzde.zzl(com_google_android_gms_internal_zzd_zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        zzbf.zzac("value: " + zzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzd com_google_android_gms_internal_zzc_zzd) {
        for (zzc com_google_android_gms_internal_zzc_zzc : com_google_android_gms_internal_zzc_zzd.zzfC) {
            if (com_google_android_gms_internal_zzc_zzc.zzfv == null) {
                zzbf.zzac("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(com_google_android_gms_internal_zzc_zzc.zzfv);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = com_google_android_gms_internal_zzc_zzc.zzfw;
                long j2 = com_google_android_gms_internal_zzc_zzc.zzfx;
                if (!com_google_android_gms_internal_zzc_zzc.zzfy || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbf.zzac("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzcU(com_google_android_gms_internal_zzc_zzc.zzfv);
                Map zzc = dataLayer.zzc(com_google_android_gms_internal_zzc_zzc.zzfv, obj);
                if (com_google_android_gms_internal_zzc_zzc.zzfz > 0) {
                    if (zzc.containsKey("gtm")) {
                        Object obj2 = zzc.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(com_google_android_gms_internal_zzc_zzc.zzfz));
                        } else {
                            zzbf.zzac("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        zzc.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(com_google_android_gms_internal_zzc_zzc.zzfz)));
                    }
                }
                dataLayer.push(zzc);
            }
        }
    }
}
