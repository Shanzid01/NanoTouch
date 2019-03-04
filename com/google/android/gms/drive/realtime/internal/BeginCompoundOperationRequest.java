package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR = new zza();
    final String mName;
    final int zzFG;
    final boolean zzWV;
    final boolean zzWW;

    BeginCompoundOperationRequest(int i, boolean z, String str, boolean z2) {
        this.zzFG = i;
        this.zzWV = z;
        this.mName = str;
        this.zzWW = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
