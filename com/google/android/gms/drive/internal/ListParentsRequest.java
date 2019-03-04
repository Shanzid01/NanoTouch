package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest implements SafeParcelable {
    public static final Creator<ListParentsRequest> CREATOR = new zzak();
    final int zzFG;
    final DriveId zzUC;

    ListParentsRequest(int i, DriveId driveId) {
        this.zzFG = i;
        this.zzUC = driveId;
    }

    public ListParentsRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }
}
