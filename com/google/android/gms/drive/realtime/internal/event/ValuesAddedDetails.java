package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR = new zzi();
    final int mIndex;
    final int zzFG;
    final String zzXD;
    final int zzXE;
    final int zzXf;
    final int zzXg;

    ValuesAddedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.zzFG = i;
        this.mIndex = i2;
        this.zzXf = i3;
        this.zzXg = i4;
        this.zzXD = str;
        this.zzXE = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
