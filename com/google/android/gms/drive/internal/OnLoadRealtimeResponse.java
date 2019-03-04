package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR = new zzaz();
    final int zzFG;
    final boolean zzmE;

    OnLoadRealtimeResponse(int i, boolean z) {
        this.zzFG = i;
        this.zzmE = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaz.zza(this, parcel, i);
    }
}
