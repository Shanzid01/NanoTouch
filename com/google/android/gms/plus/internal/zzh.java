package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class zzh implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    private final int zzFG;
    private final String zzHg;
    private final String[] zzauA;
    private final String[] zzauB;
    private final String[] zzauC;
    private final String zzauD;
    private final String zzauE;
    private final String zzauF;
    private final String zzauG;
    private final PlusCommonExtras zzauH;

    zzh(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.zzFG = i;
        this.zzHg = str;
        this.zzauA = strArr;
        this.zzauB = strArr2;
        this.zzauC = strArr3;
        this.zzauD = str2;
        this.zzauE = str3;
        this.zzauF = str4;
        this.zzauG = str5;
        this.zzauH = plusCommonExtras;
    }

    public zzh(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.zzFG = 1;
        this.zzHg = str;
        this.zzauA = strArr;
        this.zzauB = strArr2;
        this.zzauC = strArr3;
        this.zzauD = str2;
        this.zzauE = str3;
        this.zzauF = str4;
        this.zzauG = null;
        this.zzauH = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh com_google_android_gms_plus_internal_zzh = (zzh) obj;
        return this.zzFG == com_google_android_gms_plus_internal_zzh.zzFG && zzw.equal(this.zzHg, com_google_android_gms_plus_internal_zzh.zzHg) && Arrays.equals(this.zzauA, com_google_android_gms_plus_internal_zzh.zzauA) && Arrays.equals(this.zzauB, com_google_android_gms_plus_internal_zzh.zzauB) && Arrays.equals(this.zzauC, com_google_android_gms_plus_internal_zzh.zzauC) && zzw.equal(this.zzauD, com_google_android_gms_plus_internal_zzh.zzauD) && zzw.equal(this.zzauE, com_google_android_gms_plus_internal_zzh.zzauE) && zzw.equal(this.zzauF, com_google_android_gms_plus_internal_zzh.zzauF) && zzw.equal(this.zzauG, com_google_android_gms_plus_internal_zzh.zzauG) && zzw.equal(this.zzauH, com_google_android_gms_plus_internal_zzh.zzauH);
    }

    public String getAccountName() {
        return this.zzHg;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzFG), this.zzHg, this.zzauA, this.zzauB, this.zzauC, this.zzauD, this.zzauE, this.zzauF, this.zzauG, this.zzauH);
    }

    public String toString() {
        return zzw.zzk(this).zza("versionCode", Integer.valueOf(this.zzFG)).zza("accountName", this.zzHg).zza("requestedScopes", this.zzauA).zza("visibleActivities", this.zzauB).zza("requiredFeatures", this.zzauC).zza("packageNameForAuth", this.zzauD).zza("callingPackageName", this.zzauE).zza("applicationName", this.zzauF).zza("extra", this.zzauH.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public String[] zzrS() {
        return this.zzauA;
    }

    public String[] zzrT() {
        return this.zzauB;
    }

    public String[] zzrU() {
        return this.zzauC;
    }

    public String zzrV() {
        return this.zzauD;
    }

    public String zzrW() {
        return this.zzauE;
    }

    public String zzrX() {
        return this.zzauF;
    }

    public String zzrY() {
        return this.zzauG;
    }

    public PlusCommonExtras zzrZ() {
        return this.zzauH;
    }

    public Bundle zzsa() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.zzauH.zzu(bundle);
        return bundle;
    }
}
