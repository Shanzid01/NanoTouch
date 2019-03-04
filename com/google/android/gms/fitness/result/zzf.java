package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class zzf implements Result, SafeParcelable {
    public static final Creator<zzf> CREATOR = new zzg();
    private final int zzFG;
    private final Status zzHb;
    private final List<zzc> zzabS;

    zzf(int i, Status status, List<zzc> list) {
        this.zzFG = i;
        this.zzHb = status;
        this.zzabS = list;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    List<zzc> zzmr() {
        return this.zzabS;
    }
}
