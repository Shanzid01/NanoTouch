package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR = new zzj();
    final int mIndex;
    final int zzFG;
    final String zzXF;
    final int zzXG;
    final int zzXf;
    final int zzXg;

    ValuesRemovedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.zzFG = i;
        this.mIndex = i2;
        this.zzXf = i3;
        this.zzXg = i4;
        this.zzXF = str;
        this.zzXG = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
