package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzah extends zzaj {
    private static final String ID = zza.EVENT.toString();
    private final zzco zzaxy;

    public zzah(zzco com_google_android_gms_tagmanager_zzco) {
        super(ID, new String[0]);
        this.zzaxy = com_google_android_gms_tagmanager_zzco;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        String zztH = this.zzaxy.zztH();
        return zztH == null ? zzde.zzuf() : zzde.zzx(zztH);
    }

    public boolean zzsD() {
        return false;
    }
}
