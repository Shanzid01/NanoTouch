package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetChangesRequest implements SafeParcelable {
    public static final Creator<GetChangesRequest> CREATOR = new zzad();
    final int zzFG;
    final ChangeSequenceNumber zzUv;
    final int zzUw;
    final List<DriveSpace> zzUx;
    private final Set<DriveSpace> zzUy;

    GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list) {
        this(i, changeSequenceNumber, i2, list, list == null ? null : new HashSet(list));
    }

    private GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list, Set<DriveSpace> set) {
        this.zzFG = i;
        this.zzUv = changeSequenceNumber;
        this.zzUw = i2;
        this.zzUx = list;
        this.zzUy = set;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }
}
