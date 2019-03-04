package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzb implements SafeParcelable {
    public static final Creator<zzb> CREATOR = new zzc();
    String label;
    String value;
    private final int zzFG;

    zzb() {
        this.zzFG = 1;
    }

    zzb(int i, String str, String str2) {
        this.zzFG = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
