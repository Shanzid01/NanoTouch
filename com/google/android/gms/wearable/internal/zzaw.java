package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzaw implements SafeParcelable {
    public static final Creator<zzaw> CREATOR = new zzax();
    public final int statusCode;
    public final int versionCode;
    public final int zzaGD;

    zzaw(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGD = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzax.zza(this, parcel, i);
    }
}
