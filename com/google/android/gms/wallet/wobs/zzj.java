package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzj implements SafeParcelable {
    public static final Creator<zzj> CREATOR = new zzk();
    private final int zzFG;
    String zzaFl;
    String zzwG;

    zzj() {
        this.zzFG = 1;
    }

    zzj(int i, String str, String str2) {
        this.zzFG = i;
        this.zzaFl = str;
        this.zzwG = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
