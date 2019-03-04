package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzav extends zzaj {
    private static final String ID = zza.INSTALL_REFERRER.toString();
    private static final String zzaxn = zzb.COMPONENT.toString();
    private final Context zzlN;

    public zzav(Context context) {
        super(ID, new String[0]);
        this.zzlN = context;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        String zzi = zzaw.zzi(this.zzlN, ((zzd.zza) map.get(zzaxn)) != null ? zzde.zzg((zzd.zza) map.get(zzaxn)) : null);
        return zzi != null ? zzde.zzx(zzi) : zzde.zzuf();
    }

    public boolean zzsD() {
        return true;
    }
}
