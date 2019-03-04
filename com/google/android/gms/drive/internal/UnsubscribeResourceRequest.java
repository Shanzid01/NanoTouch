package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UnsubscribeResourceRequest implements SafeParcelable {
    public static final Creator<UnsubscribeResourceRequest> CREATOR = new zzbn();
    final int zzFG;
    final DriveId zzTh;

    UnsubscribeResourceRequest(int i, DriveId driveId) {
        this.zzFG = i;
        this.zzTh = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbn.zza(this, parcel, i);
    }
}
