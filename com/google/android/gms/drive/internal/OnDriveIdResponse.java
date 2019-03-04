package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new zzas();
    final int zzFG;
    DriveId zzTh;

    OnDriveIdResponse(int i, DriveId driveId) {
        this.zzFG = i;
        this.zzTh = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzTh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzas.zza(this, parcel, i);
    }
}
