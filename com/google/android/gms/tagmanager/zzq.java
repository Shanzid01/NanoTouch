package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzq extends zzcy {
    private static final String ID = zza.CONTAINS.toString();

    public zzq() {
        super(ID);
    }

    protected boolean zza(String str, String str2, Map<String, zzd.zza> map) {
        return str.contains(str2);
    }
}
