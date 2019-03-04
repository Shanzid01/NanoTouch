package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new zzar();
    final int zzFG;
    final long zzUR;
    final long zzUS;

    OnDownloadProgressResponse(int i, long j, long j2) {
        this.zzFG = i;
        this.zzUR = j;
        this.zzUS = j2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzar.zza(this, parcel, i);
    }

    public long zzkO() {
        return this.zzUR;
    }

    public long zzkP() {
        return this.zzUS;
    }
}
