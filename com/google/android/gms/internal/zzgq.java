package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@zzgi
public final class zzgq implements SafeParcelable {
    public static final zzgr CREATOR = new zzgr();
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final List<String> zzst;
    public final List<String> zzsu;
    public final long zzsx;
    public final String zzus;
    public final String zzwG;
    public final long zzwH;
    public final boolean zzwI;
    public final long zzwJ;
    public final List<String> zzwK;
    public final String zzwL;
    public final long zzwM;
    public final String zzwN;
    public final boolean zzwO;
    public final String zzwP;
    public final String zzwQ;
    public final boolean zzwR;
    public final boolean zzwS;
    public final boolean zzwT;
    public final boolean zzwU;
    public final boolean zzwv;

    public zzgq(int i) {
        this(11, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false);
    }

    public zzgq(int i, long j) {
        this(11, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false);
    }

    zzgq(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.versionCode = i;
        this.zzus = str;
        this.zzwG = str2;
        this.zzst = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzsu = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzwH = j;
        this.zzwI = z;
        this.zzwJ = j2;
        this.zzwK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzsx = j3;
        this.orientation = i3;
        this.zzwL = str3;
        this.zzwM = j4;
        this.zzwN = str4;
        this.zzwO = z2;
        this.zzwP = str5;
        this.zzwQ = str6;
        this.zzwR = z3;
        this.zzwS = z4;
        this.zzwv = z5;
        this.zzwT = z6;
        this.zzwU = z7;
    }

    public zzgq(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this(11, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6);
    }

    public zzgq(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this(11, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzgr.zza(this, parcel, i);
    }
}
