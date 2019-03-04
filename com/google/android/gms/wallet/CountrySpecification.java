package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new zzc();
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
        zzc.zza(this, parcel, i);
    }
}
