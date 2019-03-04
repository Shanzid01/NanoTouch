package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class zzaz implements SafeParcelable {
    public static final Creator<zzaz> CREATOR = new zzba();
    public final int statusCode;
    public final int versionCode;
    public final long zzaGC;
    public final List<zzaq> zzaGE;

    zzaz(int i, int i2, long j, List<zzaq> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGC = j;
        this.zzaGE = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzba.zza(this, parcel, i);
    }
}
