package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzl implements SafeParcelable {
    public static final Creator<zzl> CREATOR = new zzm();
    private final int zzFG;
    long zzaFm;
    long zzaFn;

    zzl() {
        this.zzFG = 1;
    }

    zzl(int i, long j, long j2) {
        this.zzFG = i;
        this.zzaFm = j;
        this.zzaFn = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
