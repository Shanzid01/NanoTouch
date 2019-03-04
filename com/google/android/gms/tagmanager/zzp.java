package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzp extends zzaj {
    private static final String ID = zza.CONTAINER_VERSION.toString();
    private final String zzYw;

    public zzp(String str) {
        super(ID, new String[0]);
        this.zzYw = str;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return this.zzYw == null ? zzde.zzuf() : zzde.zzx(this.zzYw);
    }

    public boolean zzsD() {
        return true;
    }
}
