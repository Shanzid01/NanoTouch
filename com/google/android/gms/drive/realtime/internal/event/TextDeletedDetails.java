package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails implements SafeParcelable {
    public static final Creator<TextDeletedDetails> CREATOR = new zzf();
    final int mIndex;
    final int zzFG;
    final int zzXC;

    TextDeletedDetails(int i, int i2, int i3) {
        this.zzFG = i;
        this.mIndex = i2;
        this.zzXC = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
