package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class PartialDriveId implements SafeParcelable {
    public static final Creator<PartialDriveId> CREATOR = new zzl();
    final int zzFG;
    final String zzSh;
    final long zzSi;
    final int zzSj;

    PartialDriveId(int i, String str, long j, int i2) {
        this.zzFG = i;
        this.zzSh = str;
        this.zzSi = j;
        this.zzSj = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public DriveId zzt(long j) {
        return new DriveId(this.zzSh, this.zzSi, j, this.zzSj);
    }
}
