package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new zzp();
    private final int zzFG;
    String zzaEi;
    String zzaEj;
    int zzaEk;
    int zzaEl;

    ProxyCard(int i, String str, String str2, int i2, int i3) {
        this.zzFG = i;
        this.zzaEi = str;
        this.zzaEj = str2;
        this.zzaEk = i2;
        this.zzaEl = i3;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzaEj;
    }

    public int getExpirationMonth() {
        return this.zzaEk;
    }

    public int getExpirationYear() {
        return this.zzaEl;
    }

    public String getPan() {
        return this.zzaEi;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
