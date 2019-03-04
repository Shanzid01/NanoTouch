package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzvx implements SafeParcelable {
    public static final Creator<zzvx> CREATOR = new zzvy();
    private final int zzFG;
    int[] zzaEq;

    zzvx() {
        this(1, null);
    }

    zzvx(int i, int[] iArr) {
        this.zzFG = i;
        this.zzaEq = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzvy.zza(this, parcel, i);
    }
}
