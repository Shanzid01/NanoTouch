package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR = new zzq();
    final int mIndex;
    final int zzFG;
    final String zzXc;
    final boolean zzXd;

    ParcelableIndexReference(int i, String str, int i2, boolean z) {
        this.zzFG = i;
        this.zzXc = str;
        this.mIndex = i2;
        this.zzXd = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
