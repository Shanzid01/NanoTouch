package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzad extends zzcy {
    private static final String ID = zza.ENDS_WITH.toString();

    public zzad() {
        super(ID);
    }

    protected boolean zza(String str, String str2, Map<String, zzd.zza> map) {
        return str.endsWith(str2);
    }
}
