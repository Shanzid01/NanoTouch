package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Creator<ObjectChangedDetails> CREATOR = new zzb();
    final int zzFG;
    final int zzXf;
    final int zzXg;

    ObjectChangedDetails(int i, int i2, int i3) {
        this.zzFG = i;
        this.zzXf = i2;
        this.zzXg = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
