package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzb extends zzaj {
    private static final String ID = zza.ADVERTISER_ID.toString();
    private final zza zzaxm;

    public zzb(Context context) {
        this(zza.zzaj(context));
    }

    zzb(zza com_google_android_gms_tagmanager_zza) {
        super(ID, new String[0]);
        this.zzaxm = com_google_android_gms_tagmanager_zza;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        String zzsz = this.zzaxm.zzsz();
        return zzsz == null ? zzde.zzuf() : zzde.zzx(zzsz);
    }

    public boolean zzsD() {
        return false;
    }
}
