package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class zzh implements SafeParcelable {
    public static final Creator<zzh> CREATOR = new zzi();
    final int zzFG;
    public final long zzHf;
    public final long zzYH;
    public final DataSource zzYp;
    public final int zzaaX;
    public final long zzabb;
    public final int zzabc;

    zzh(int i, DataSource dataSource, long j, long j2, long j3, int i2, int i3) {
        this.zzFG = i;
        this.zzYp = dataSource;
        this.zzHf = j;
        this.zzYH = j2;
        this.zzabb = j3;
        this.zzaaX = i2;
        this.zzabc = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
