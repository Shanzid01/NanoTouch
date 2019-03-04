package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new zzb();
    String name;
    private final int zzFG;
    String zzalA;
    String zzalB;
    String zzalC;
    String zzalD;
    boolean zzalE;
    String zzalF;
    String zzalG;
    String zzalu;
    String zzalv;
    String zzalw;
    String zzalx;
    String zzaly;
    String zzalz;
    String zzyc;

    UserAddress() {
        this.zzFG = 1;
    }

    UserAddress(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.zzFG = i;
        this.name = str;
        this.zzalu = str2;
        this.zzalv = str3;
        this.zzalw = str4;
        this.zzalx = str5;
        this.zzaly = str6;
        this.zzalz = str7;
        this.zzalA = str8;
        this.zzyc = str9;
        this.zzalB = str10;
        this.zzalC = str11;
        this.zzalD = str12;
        this.zzalE = z;
        this.zzalF = str13;
        this.zzalG = str14;
    }

    public static UserAddress fromIntent(Intent intent) {
        return (intent == null || !intent.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) intent.getParcelableExtra(Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.zzalx;
    }

    public String getAddress5() {
        return this.zzaly;
    }

    public String getAdministrativeArea() {
        return this.zzalz;
    }

    public String getCompanyName() {
        return this.zzalF;
    }

    public String getCountryCode() {
        return this.zzyc;
    }

    public String getEmailAddress() {
        return this.zzalG;
    }

    public String getLocality() {
        return this.zzalA;
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

    public String getSortingCode() {
        return this.zzalC;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isPostBox() {
        return this.zzalE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
