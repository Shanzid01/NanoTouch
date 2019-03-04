package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzcq extends zzaj {
    private static final String ID = zza.SDK_VERSION.toString();

    public zzcq() {
        super(ID, new String[0]);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return zzde.zzx(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean zzsD() {
        return true;
    }
}
