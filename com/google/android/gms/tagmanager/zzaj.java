package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzd.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzaj {
    private final Set<String> zzayG;
    private final String zzayH;

    public zzaj(String str, String... strArr) {
        this.zzayH = str;
        this.zzayG = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.zzayG.add(add);
        }
    }

    public abstract zza zzH(Map<String, zza> map);

    boolean zzb(Set<String> set) {
        return set.containsAll(this.zzayG);
    }

    public abstract boolean zzsD();

    public String zzth() {
        return this.zzayH;
    }

    public Set<String> zzti() {
        return this.zzayG;
    }
}
