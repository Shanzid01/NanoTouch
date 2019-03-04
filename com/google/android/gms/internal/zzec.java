package com.google.android.gms.internal;

import java.util.Map;

@zzgi
public class zzec {
    private final zzic zzmu;
    private final boolean zztv;
    private final String zztw;

    public zzec(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zztw = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zztv = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.zztv = true;
        }
    }

    public void execute() {
        if (this.zzmu == null) {
            zzhx.zzac("AdWebView is null");
            return;
        }
        int zzey = "portrait".equalsIgnoreCase(this.zztw) ? zzab.zzaO().zzey() : "landscape".equalsIgnoreCase(this.zztw) ? zzab.zzaO().zzex() : this.zztv ? -1 : zzab.zzaO().zzez();
        this.zzmu.setRequestedOrientation(zzey);
    }
}
