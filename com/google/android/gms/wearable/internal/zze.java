package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class zze implements SafeParcelable, zzb {
    public static final Creator<zze> CREATOR = new zzf();
    private int mId;
    private final String zzBc;
    final int zzFG;
    private String zzSJ;
    private final String zzSy;
    private final String zzaFP;
    private final String zzaFQ;
    private byte zzaFR;
    private byte zzaFS;
    private byte zzaFT;
    private byte zzaFU;
    private final String zzadw;

    zze(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.mId = i2;
        this.zzFG = i;
        this.zzBc = str;
        this.zzaFP = str2;
        this.zzaFQ = str3;
        this.zzSy = str4;
        this.zzadw = str5;
        this.zzSJ = str6;
        this.zzaFR = b;
        this.zzaFS = b2;
        this.zzaFT = b3;
        this.zzaFU = b4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zze com_google_android_gms_wearable_internal_zze = (zze) obj;
        return this.zzaFU != com_google_android_gms_wearable_internal_zze.zzaFU ? false : this.zzaFT != com_google_android_gms_wearable_internal_zze.zzaFT ? false : this.zzaFS != com_google_android_gms_wearable_internal_zze.zzaFS ? false : this.zzaFR != com_google_android_gms_wearable_internal_zze.zzaFR ? false : this.mId != com_google_android_gms_wearable_internal_zze.mId ? false : this.zzFG != com_google_android_gms_wearable_internal_zze.zzFG ? false : !this.zzBc.equals(com_google_android_gms_wearable_internal_zze.zzBc) ? false : (this.zzaFP == null ? com_google_android_gms_wearable_internal_zze.zzaFP != null : !this.zzaFP.equals(com_google_android_gms_wearable_internal_zze.zzaFP)) ? false : !this.zzSJ.equals(com_google_android_gms_wearable_internal_zze.zzSJ) ? false : !this.zzaFQ.equals(com_google_android_gms_wearable_internal_zze.zzaFQ) ? false : !this.zzadw.equals(com_google_android_gms_wearable_internal_zze.zzadw) ? false : this.zzSy.equals(com_google_android_gms_wearable_internal_zze.zzSy);
    }

    public String getDisplayName() {
        return this.zzSJ == null ? this.zzBc : this.zzSJ;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzaFP != null ? this.zzaFP.hashCode() : 0) + (((((this.zzFG * 31) + this.mId) * 31) + this.zzBc.hashCode()) * 31)) * 31) + this.zzaFQ.hashCode()) * 31) + this.zzSy.hashCode()) * 31) + this.zzadw.hashCode()) * 31) + this.zzSJ.hashCode()) * 31) + this.zzaFR) * 31) + this.zzaFS) * 31) + this.zzaFT) * 31) + this.zzaFU;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.zzFG + ", mId=" + this.mId + ", mAppId='" + this.zzBc + '\'' + ", mDateTime='" + this.zzaFP + '\'' + ", mNotificationText='" + this.zzaFQ + '\'' + ", mTitle='" + this.zzSy + '\'' + ", mSubtitle='" + this.zzadw + '\'' + ", mDisplayName='" + this.zzSJ + '\'' + ", mEventId=" + this.zzaFR + ", mEventFlags=" + this.zzaFS + ", mCategoryId=" + this.zzaFT + ", mCategoryCount=" + this.zzaFU + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzmV() {
        return this.zzadw;
    }

    public String zznE() {
        return this.zzBc;
    }

    public String zzvb() {
        return this.zzaFP;
    }

    public String zzvc() {
        return this.zzaFQ;
    }

    public byte zzvd() {
        return this.zzaFR;
    }

    public byte zzve() {
        return this.zzaFS;
    }

    public byte zzvf() {
        return this.zzaFT;
    }

    public byte zzvg() {
        return this.zzaFU;
    }
}
