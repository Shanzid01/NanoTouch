package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzip implements SafeParcelable {
    public static final zziq CREATOR = new zziq();
    final int zzFG;
    final String zzFO;
    final String zzFP;
    final String zzFQ;

    zzip(int i, String str, String str2, String str3) {
        this.zzFG = i;
        this.zzFO = str;
        this.zzFP = str2;
        this.zzFQ = str3;
    }

    public zzip(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public int describeContents() {
        zziq com_google_android_gms_internal_zziq = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zzFO, this.zzFP, this.zzFQ});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zziq com_google_android_gms_internal_zziq = CREATOR;
        zziq.zza(this, parcel, i);
    }
}
