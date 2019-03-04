package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzce extends zzcy {
    private static final String ID = zza.REGEX.toString();
    private static final String zzazJ = zzb.IGNORE_CASE.toString();

    public zzce() {
        super(ID);
    }

    protected boolean zza(String str, String str2, Map<String, zzd.zza> map) {
        try {
            return Pattern.compile(str2, zzde.zzk((zzd.zza) map.get(zzazJ)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
