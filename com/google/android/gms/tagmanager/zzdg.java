package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzdg extends zzaj {
    private static final String ID = zza.UPPERCASE_STRING.toString();
    private static final String zzayC = zzb.ARG0.toString();

    public zzdg() {
        super(ID, zzayC);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return zzde.zzx(zzde.zzg((zzd.zza) map.get(zzayC)).toUpperCase());
    }

    public boolean zzsD() {
        return true;
    }
}
