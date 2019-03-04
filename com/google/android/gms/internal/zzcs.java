package com.google.android.gms.internal;

import java.util.Map;

@zzgi
public final class zzcs implements zzcv {
    private final zzct zzry;

    public zzcs(zzct com_google_android_gms_internal_zzct) {
        this.zzry = com_google_android_gms_internal_zzct;
    }

    public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzhx.zzac("App event with no name parameter.");
        } else {
            this.zzry.onAppEvent(str, (String) map.get("info"));
        }
    }
}
