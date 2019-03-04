package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzn implements Result, SafeParcelable {
    public static final Creator<zzn> CREATOR = new zzo();
    private final int zzFG;
    private final Status zzHb;
    private final long zzLk;

    zzn(int i, Status status, long j) {
        this.zzFG = i;
        this.zzHb = status;
        this.zzLk = j;
    }

    private boolean zzb(zzn com_google_android_gms_fitness_result_zzn) {
        return this.zzHb.equals(com_google_android_gms_fitness_result_zzn.zzHb) && zzw.equal(Long.valueOf(this.zzLk), Long.valueOf(com_google_android_gms_fitness_result_zzn.zzLk));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzn) && zzb((zzn) obj));
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, Long.valueOf(this.zzLk));
    }

    public String toString() {
        return zzw.zzk(this).zza("status", this.zzHb).zza("timestamp", Long.valueOf(this.zzLk)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public long zzmu() {
        return this.zzLk;
    }
}
