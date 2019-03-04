package com.google.android.gms.drive.execution.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetContentTransferInfoRequest implements SafeParcelable {
    public static final Creator<GetContentTransferInfoRequest> CREATOR = new zzb();
    final int zzFG;
    final int zzJp;
    final DriveId zzRX;

    GetContentTransferInfoRequest(int i, DriveId driveId, int i2) {
        this.zzFG = i;
        this.zzRX = driveId;
        this.zzJp = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
