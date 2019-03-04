package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new zzbm();
    final int zzFG;
    final DriveId zzTh;

    TrashResourceRequest(int i, DriveId driveId) {
        this.zzFG = i;
        this.zzTh = driveId;
    }

    public TrashResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbm.zza(this, parcel, i);
    }
}
