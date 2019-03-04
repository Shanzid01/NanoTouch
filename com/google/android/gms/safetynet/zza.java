package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zza implements SafeParcelable {
    public static final Creator<zza> CREATOR = new zzb();
    public final int zzFG;
    private String zzawF;

    zza(int i, String str) {
        this.zzFG = i;
        this.zzawF = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getJwsResult() {
        return this.zzawF;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
