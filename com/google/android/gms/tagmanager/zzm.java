package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzm extends zzaj {
    private static final String ID = zza.CONSTANT.toString();
    private static final String VALUE = zzb.VALUE.toString();

    public zzm() {
        super(ID, VALUE);
    }

    public static String zzsG() {
        return ID;
    }

    public static String zzsH() {
        return VALUE;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return (zzd.zza) map.get(VALUE);
    }

    public boolean zzsD() {
        return true;
    }
}
