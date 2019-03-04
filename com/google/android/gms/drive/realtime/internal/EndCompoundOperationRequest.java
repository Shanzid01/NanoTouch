package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class EndCompoundOperationRequest implements SafeParcelable {
    public static final Creator<EndCompoundOperationRequest> CREATOR = new zzb();
    final int zzFG;

    public EndCompoundOperationRequest() {
        this(1);
    }

    EndCompoundOperationRequest(int i) {
        this.zzFG = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
