package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.Map;

@zzgi
public class zzcx implements zzcv {
    private final zzcy zzrJ;

    public zzcx(zzcy com_google_android_gms_internal_zzcy) {
        this.zzrJ = com_google_android_gms_internal_zzcy;
    }

    public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        this.zzrJ.zzd(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground")));
    }
}
