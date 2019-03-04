package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzl implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    private final int zzFG;
    int zzamw;
    int zzamx;
    long zzamy;

    public zzl(int i, int i2, int i3, long j) {
        this.zzFG = i;
        this.zzamw = i2;
        this.zzamx = i3;
        this.zzamy = j;
    }

    private String zzfp(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl com_google_android_gms_location_zzl = (zzl) obj;
        return this.zzamw == com_google_android_gms_location_zzl.zzamw && this.zzamx == com_google_android_gms_location_zzl.zzamx && this.zzamy == com_google_android_gms_location_zzl.zzamy;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzamw), Integer.valueOf(this.zzamx), Long.valueOf(this.zzamy));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(zzfp(this.zzamw));
        stringBuilder.append(", wifi status: ").append(zzfp(this.zzamx));
        stringBuilder.append(", elapsed realtime ns: ").append(this.zzamy);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
