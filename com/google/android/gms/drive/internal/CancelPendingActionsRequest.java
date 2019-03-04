package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Creator<CancelPendingActionsRequest> CREATOR = new zzd();
    final int zzFG;
    final List<String> zzSS;

    CancelPendingActionsRequest(int i, List<String> list) {
        this.zzFG = i;
        this.zzSS = list;
    }

    public CancelPendingActionsRequest(List<String> list) {
        this(1, list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
