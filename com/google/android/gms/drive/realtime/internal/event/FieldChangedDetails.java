package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldChangedDetails implements SafeParcelable {
    public static final Creator<FieldChangedDetails> CREATOR = new zza();
    final int zzFG;
    final int zzXe;

    FieldChangedDetails(int i, int i2) {
        this.zzFG = i;
        this.zzXe = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
