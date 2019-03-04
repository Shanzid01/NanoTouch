package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzs implements SafeParcelable {
    public static final Creator<zzs> CREATOR = new zzt();
    public final int statusCode;
    public final int versionCode;
    public final int zzaGh;

    zzs(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGh = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }
}
