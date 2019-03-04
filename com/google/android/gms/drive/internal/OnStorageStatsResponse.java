package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR = new zzbb();
    final int zzFG;
    StorageStats zzVa;

    OnStorageStatsResponse(int i, StorageStats storageStats) {
        this.zzFG = i;
        this.zzVa = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbb.zza(this, parcel, i);
    }
}
