package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR = new zzbd();
    final int zzFG;
    final int zzRW;
    final DriveId zzTh;
    final int zzVb;

    OpenContentsRequest(int i, DriveId driveId, int i2, int i3) {
        this.zzFG = i;
        this.zzTh = driveId;
        this.zzRW = i2;
        this.zzVb = i3;
    }

    public OpenContentsRequest(DriveId driveId, int i, int i2) {
        this(1, driveId, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }
}
