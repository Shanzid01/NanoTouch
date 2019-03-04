package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzjw implements SafeParcelable {
    public static final Creator<zzjw> CREATOR = new zzjx();
    private final int zzFG;
    private double zzJm;
    private boolean zzJn;
    private ApplicationMetadata zzKD;
    private int zzKr;
    private int zzKs;

    public zzjw() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    zzjw(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.zzFG = i;
        this.zzJm = d;
        this.zzJn = z;
        this.zzKr = i2;
        this.zzKD = applicationMetadata;
        this.zzKs = i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjw)) {
            return false;
        }
        zzjw com_google_android_gms_internal_zzjw = (zzjw) obj;
        return this.zzJm == com_google_android_gms_internal_zzjw.zzJm && this.zzJn == com_google_android_gms_internal_zzjw.zzJn && this.zzKr == com_google_android_gms_internal_zzjw.zzKr && zzjv.zza(this.zzKD, com_google_android_gms_internal_zzjw.zzKD) && this.zzKs == com_google_android_gms_internal_zzjw.zzKs;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzKD;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Double.valueOf(this.zzJm), Boolean.valueOf(this.zzJn), Integer.valueOf(this.zzKr), this.zzKD, Integer.valueOf(this.zzKs));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzjx.zza(this, parcel, i);
    }

    public boolean zzhA() {
        return this.zzJn;
    }

    public int zzhB() {
        return this.zzKr;
    }

    public int zzhC() {
        return this.zzKs;
    }

    public double zzhs() {
        return this.zzJm;
    }
}
