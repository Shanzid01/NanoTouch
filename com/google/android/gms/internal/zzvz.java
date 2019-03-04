package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzvz implements SafeParcelable {
    public static final Creator<zzvz> CREATOR = new zzwa();
    private final int zzFG;
    String[] zzaEr;
    byte[][] zzaEs;

    zzvz() {
        this(1, new String[0], new byte[0][]);
    }

    zzvz(int i, String[] strArr, byte[][] bArr) {
        this.zzFG = i;
        this.zzaEr = strArr;
        this.zzaEs = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzwa.zza(this, parcel, i);
    }
}
