package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR = new zzk();
    final int mIndex;
    final int zzFG;
    final int zzXf;
    final int zzXg;

    ValuesSetDetails(int i, int i2, int i3, int i4) {
        this.zzFG = i;
        this.mIndex = i2;
        this.zzXf = i3;
        this.zzXg = i4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
