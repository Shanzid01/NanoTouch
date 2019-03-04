package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzcz extends zzaj {
    private static final String ID = zza.TIME.toString();

    public zzcz() {
        super(ID, new String[0]);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return zzde.zzx(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean zzsD() {
        return false;
    }
}
