package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new zza();
    String name;
    private final int zzFG;
    String zzaCP;
    String zzaCQ;
    String zzalB;
    String zzalD;
    boolean zzalE;
    String zzalF;
    String zzalu;
    String zzalv;
    String zzalw;
    String zzyc;

    Address() {
        this.zzFG = 1;
    }

    Address(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.zzFG = i;
        this.name = str;
        this.zzalu = str2;
        this.zzalv = str3;
        this.zzalw = str4;
        this.zzyc = str5;
        this.zzaCP = str6;
        this.zzaCQ = str7;
        this.zzalB = str8;
        this.zzalD = str9;
        this.zzalE = z;
        this.zzalF = str10;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzalu;
    }

    public String getAddress2() {
        return this.zzalv;
    }

    public String getAddress3() {
        return this.zzalw;
    }

    public String getCity() {
        return this.zzaCP;
    }

    public String getCompanyName() {
        return this.zzalF;
    }

    public String getCountryCode() {
        return this.zzyc;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.zzalD;
    }

    public String getPostalCode() {
        return this.zzalB;
    }

    public String getState() {
        return this.zzaCQ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isPostBox() {
        return this.zzalE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
