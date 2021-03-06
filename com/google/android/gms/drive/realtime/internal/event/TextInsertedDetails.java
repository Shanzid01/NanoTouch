package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextInsertedDetails implements SafeParcelable {
    public static final Creator<TextInsertedDetails> CREATOR = new zzg();
    final int mIndex;
    final int zzFG;
    final int zzXC;

    TextInsertedDetails(int i, int i2, int i3) {
        this.zzFG = i;
        this.mIndex = i2;
        this.zzXC = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
