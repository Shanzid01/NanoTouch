package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzae();
    final int zzFG;
    final boolean zzUA;
    final String zzUz;

    GetDriveIdFromUniqueIdentifierRequest(int i, String str, boolean z) {
        this.zzFG = i;
        this.zzUz = str;
        this.zzUA = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }
}
