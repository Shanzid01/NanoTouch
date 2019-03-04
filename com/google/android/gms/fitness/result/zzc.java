package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class zzc implements SafeParcelable {
    public static final Creator<zzc> CREATOR = new zzd();
    final int zzFG;
    public final long zzHf;
    public final DataSource zzYp;
    public final boolean zzabP;
    public final long zzabQ;
    public final long zzabR;

    zzc(int i, DataSource dataSource, long j, boolean z, long j2, long j3) {
        this.zzFG = i;
        this.zzYp = dataSource;
        this.zzHf = j;
        this.zzabP = z;
        this.zzabQ = j2;
        this.zzabR = j3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
