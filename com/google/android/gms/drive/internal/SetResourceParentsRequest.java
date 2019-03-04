package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR = new zzbk();
    final int zzFG;
    final DriveId zzVe;
    final List<DriveId> zzVf;

    SetResourceParentsRequest(int i, DriveId driveId, List<DriveId> list) {
        this.zzFG = i;
        this.zzVe = driveId;
        this.zzVf = list;
    }

    public SetResourceParentsRequest(DriveId driveId, List<DriveId> list) {
        this(1, driveId, list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbk.zza(this, parcel, i);
    }
}
