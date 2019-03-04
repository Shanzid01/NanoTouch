package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class zzy implements SafeParcelable {
    public static final Creator<zzy> CREATOR = new zzz();
    public final int statusCode;
    public final int versionCode;
    public final List<zzao> zzaGk;

    zzy(int i, int i2, List<zzao> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGk = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }
}
