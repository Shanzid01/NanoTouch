package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new zzal();
    final int zzFG;
    final DriveId zzRX;
    final boolean zzUD;
    final List<String> zzUE;

    LoadRealtimeRequest(int i, DriveId driveId, boolean z, List<String> list) {
        this.zzFG = i;
        this.zzRX = driveId;
        this.zzUD = z;
        this.zzUE = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }
}
