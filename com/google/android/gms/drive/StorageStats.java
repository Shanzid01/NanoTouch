package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats implements SafeParcelable {
    public static final Creator<StorageStats> CREATOR = new zzi();
    final int zzFG;
    final long zzSD;
    final long zzSE;
    final long zzSF;
    final long zzSG;
    final int zzSH;

    StorageStats(int i, long j, long j2, long j3, long j4, int i2) {
        this.zzFG = i;
        this.zzSD = j;
        this.zzSE = j2;
        this.zzSF = j3;
        this.zzSG = j4;
        this.zzSH = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
