package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR = new zze();
    final int zzFG;
    final int zzXA;
    final int zzXB;
    final String zzXy;
    final String zzXz;

    ReferenceShiftedDetails(int i, String str, String str2, int i2, int i3) {
        this.zzFG = i;
        this.zzXy = str;
        this.zzXz = str2;
        this.zzXA = i2;
        this.zzXB = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
