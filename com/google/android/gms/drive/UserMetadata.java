package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new zzj();
    final int zzFG;
    final String zzSI;
    final String zzSJ;
    final String zzSK;
    final boolean zzSL;
    final String zzSM;

    UserMetadata(int i, String str, String str2, String str3, boolean z, String str4) {
        this.zzFG = i;
        this.zzSI = str;
        this.zzSJ = str2;
        this.zzSK = str3;
        this.zzSL = z;
        this.zzSM = str4;
    }

    public UserMetadata(String str, String str2, String str3, boolean z, String str4) {
        this(1, str, str2, str3, z, str4);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzSI, this.zzSJ, this.zzSK, Boolean.valueOf(this.zzSL), this.zzSM});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
