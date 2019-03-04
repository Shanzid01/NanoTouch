package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzc extends zzaj {
    private static final String ID = zza.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzaxm;

    public zzc(Context context) {
        this(zza.zzaj(context));
    }

    zzc(zza com_google_android_gms_tagmanager_zza) {
        super(ID, new String[0]);
        this.zzaxm = com_google_android_gms_tagmanager_zza;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return zzde.zzx(Boolean.valueOf(!this.zzaxm.isLimitAdTrackingEnabled()));
    }

    public boolean zzsD() {
        return false;
    }
}
