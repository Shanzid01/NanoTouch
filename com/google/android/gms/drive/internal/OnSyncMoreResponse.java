package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new zzbc();
    final int zzFG;
    final boolean zzTB;

    OnSyncMoreResponse(int i, boolean z) {
        this.zzFG = i;
        this.zzTB = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }
}
