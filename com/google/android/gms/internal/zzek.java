package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzgi
public final class zzek implements SafeParcelable {
    public static final zzej CREATOR = new zzej();
    public final String mimeType;
    public final String packageName;
    public final int versionCode;
    public final String zztQ;
    public final String zztR;
    public final String zztS;
    public final String zztT;
    public final String zztU;

    public zzek(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.zztQ = str;
        this.zztR = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zztS = str5;
        this.zztT = str6;
        this.zztU = str7;
    }

    public zzek(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzej.zza(this, parcel, i);
    }
}
