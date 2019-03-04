package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UntrashResourceRequest implements SafeParcelable {
    public static final Creator<UntrashResourceRequest> CREATOR = new zzbo();
    final int zzFG;
    final DriveId zzTh;

    UntrashResourceRequest(int i, DriveId driveId) {
        this.zzFG = i;
        this.zzTh = driveId;
    }

    public UntrashResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbo.zza(this, parcel, i);
    }
}
