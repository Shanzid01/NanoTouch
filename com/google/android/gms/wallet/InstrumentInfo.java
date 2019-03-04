package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new zzi();
    private final int zzFG;
    private String zzaDr;
    private String zzaDs;

    InstrumentInfo(int i, String str, String str2) {
        this.zzFG = i;
        this.zzaDr = str;
        this.zzaDs = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzaDs;
    }

    public String getInstrumentType() {
        return this.zzaDr;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
