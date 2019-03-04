package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzg implements SafeParcelable {
    public static final Creator<zzg> CREATOR = new zzh();
    private final int zzFG;
    String zzaDo;
    int zzaFg;
    String zzaFh;
    double zzaFi;
    long zzaFj;
    int zzaFk;

    zzg() {
        this.zzFG = 1;
        this.zzaFk = -1;
        this.zzaFg = -1;
        this.zzaFi = -1.0d;
    }

    zzg(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.zzFG = i;
        this.zzaFg = i2;
        this.zzaFh = str;
        this.zzaFi = d;
        this.zzaDo = str2;
        this.zzaFj = j;
        this.zzaFk = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
