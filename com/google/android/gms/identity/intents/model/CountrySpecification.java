package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new zza();
    private final int zzFG;
    String zzyc;

    CountrySpecification(int i, String str) {
        this.zzFG = i;
        this.zzyc = str;
    }

    public CountrySpecification(String str) {
        this.zzFG = 1;
        this.zzyc = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzyc;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
