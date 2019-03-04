package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class FetchThumbnailRequest implements SafeParcelable {
    public static final Creator<FetchThumbnailRequest> CREATOR = new zzab();
    final int zzFG;
    final DriveId zzTh;

    FetchThumbnailRequest(int i, DriveId driveId) {
        this.zzFG = i;
        this.zzTh = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }
}
