package com.google.android.gms.drive.execution.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ContentTransferInfoResponse implements SafeParcelable {
    public static final Creator<ContentTransferInfoResponse> CREATOR = new zza();
    final int zzFG;
    final int zzJp;
    final long zzTc;
    final long zzTd;
    final int zzrX;

    ContentTransferInfoResponse(int i, int i2, int i3, long j, long j2) {
        this.zzFG = i;
        this.zzJp = i2;
        this.zzrX = i3;
        this.zzTc = j;
        this.zzTd = j2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
