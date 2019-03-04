package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzgi
public final class zzdu implements MediationAdRequest {
    private final Date zzd;
    private final Set<String> zzf;
    private final boolean zzg;
    private final Location zzh;
    private final int zzpo;
    private final int zzsQ;

    public zzdu(Date date, int i, Set<String> set, Location location, boolean z, int i2) {
        this.zzd = date;
        this.zzpo = i;
        this.zzf = set;
        this.zzh = location;
        this.zzg = z;
        this.zzsQ = i2;
    }

    public Date getBirthday() {
        return this.zzd;
    }

    public int getGender() {
        return this.zzpo;
    }

    public Set<String> getKeywords() {
        return this.zzf;
    }

    public Location getLocation() {
        return this.zzh;
    }

    public boolean isTesting() {
        return this.zzg;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzsQ;
    }
}
