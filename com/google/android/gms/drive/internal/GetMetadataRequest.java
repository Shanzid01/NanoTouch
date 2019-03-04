package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR = new zzaf();
    final int zzFG;
    final DriveId zzTh;
    final boolean zzUB;

    GetMetadataRequest(int i, DriveId driveId, boolean z) {
        this.zzFG = i;
        this.zzTh = driveId;
        this.zzUB = z;
    }

    public GetMetadataRequest(DriveId driveId, boolean z) {
        this(1, driveId, z);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }
}
