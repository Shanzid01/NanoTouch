package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR = new zzba();
    private final int zzFG;
    private final List<String> zzTg;

    OnResourceIdSetResponse(int i, List<String> list) {
        this.zzFG = i;
        this.zzTg = list;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzba.zza(this, parcel, i);
    }

    public List<String> zzkE() {
        return this.zzTg;
    }
}
