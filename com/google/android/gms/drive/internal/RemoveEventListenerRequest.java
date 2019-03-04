package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR = new zzbh();
    final int zzFG;
    final DriveId zzRX;
    final int zzTe;

    RemoveEventListenerRequest(int i, DriveId driveId, int i2) {
        this.zzFG = i;
        this.zzRX = driveId;
        this.zzTe = i2;
    }

    public RemoveEventListenerRequest(DriveId driveId, int i) {
        this(1, driveId, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbh.zza(this, parcel, i);
    }
}
