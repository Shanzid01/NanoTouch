package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzgi
public class zzcz implements zzcv {
    static final Map<String, Integer> zzrM = new HashMap();
    private final zzu zzrK;
    private final zzeb zzrL;

    static {
        zzrM.put("resize", Integer.valueOf(1));
        zzrM.put("playVideo", Integer.valueOf(2));
        zzrM.put("storePicture", Integer.valueOf(3));
        zzrM.put("createCalendarEvent", Integer.valueOf(4));
        zzrM.put("setOrientationProperties", Integer.valueOf(5));
        zzrM.put("closeResizedAd", Integer.valueOf(6));
    }

    public zzcz(zzu com_google_android_gms_internal_zzu, zzeb com_google_android_gms_internal_zzeb) {
        this.zzrK = com_google_android_gms_internal_zzu;
        this.zzrL = com_google_android_gms_internal_zzeb;
    }

    public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        int intValue = ((Integer) zzrM.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.zzrK == null || this.zzrK.zzaB()) {
            switch (intValue) {
                case 1:
                    this.zzrL.zzg(map);
                    return;
                case 3:
                    new zzed(com_google_android_gms_internal_zzic, map).execute();
                    return;
                case 4:
                    new zzea(com_google_android_gms_internal_zzic, map).execute();
                    return;
                case 5:
                    new zzec(com_google_android_gms_internal_zzic, map).execute();
                    return;
                case 6:
                    this.zzrL.zzm(true);
                    return;
                default:
                    zzhx.zzaa("Unknown MRAID command called.");
                    return;
            }
        }
        this.zzrK.zzd(null);
    }
}
