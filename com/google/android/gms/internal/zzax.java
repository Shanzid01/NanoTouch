package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzgi
public final class zzax implements SafeParcelable {
    public static final zzay CREATOR = new zzay();
    public final Bundle extras;
    public final int versionCode;
    public final long zzoL;
    public final int zzoM;
    public final List<String> zzoN;
    public final boolean zzoO;
    public final int zzoP;
    public final boolean zzoQ;
    public final String zzoR;
    public final zzbs zzoS;
    public final Location zzoT;
    public final String zzoU;
    public final Bundle zzoV;
    public final Bundle zzoW;
    public final List<String> zzoX;
    public final String zzoY;

    public zzax(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzbs com_google_android_gms_internal_zzbs, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3) {
        this.versionCode = i;
        this.zzoL = j;
        this.extras = bundle;
        this.zzoM = i2;
        this.zzoN = list;
        this.zzoO = z;
        this.zzoP = i3;
        this.zzoQ = z2;
        this.zzoR = str;
        this.zzoS = com_google_android_gms_internal_zzbs;
        this.zzoT = location;
        this.zzoU = str2;
        this.zzoV = bundle2;
        this.zzoW = bundle3;
        this.zzoX = list2;
        this.zzoY = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzay.zza(this, parcel, i);
    }
}
