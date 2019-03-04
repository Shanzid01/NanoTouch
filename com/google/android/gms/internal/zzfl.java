package com.google.android.gms.internal;

import android.content.Intent;

@zzgi
public class zzfl {
    private final String zzpH;

    public zzfl(String str) {
        this.zzpH = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String zze = zzab.zzaU().zze(intent);
        String zzf = zzab.zzaU().zzf(intent);
        if (zze == null || zzf == null) {
            return false;
        }
        if (!str.equals(zzab.zzaU().zzL(zze))) {
            zzhx.zzac("Developer payload not match.");
            return false;
        } else if (this.zzpH == null || zzfm.zzc(this.zzpH, zze, zzf)) {
            return true;
        } else {
            zzhx.zzac("Fail to verify signature.");
            return false;
        }
    }

    public String zzdB() {
        return zzab.zzaM().zzeu();
    }
}
