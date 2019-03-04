package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR = new zzh();
    final int zzFG;
    final int zzRW;

    public CreateContentsRequest(int i) {
        this(1, i);
    }

    CreateContentsRequest(int i, int i2) {
        this.zzFG = i;
        boolean z = i2 == DriveFile.MODE_WRITE_ONLY || i2 == DriveFile.MODE_READ_WRITE;
        zzx.zzb(z, (Object) "Cannot create a new read-only contents!");
        this.zzRW = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
