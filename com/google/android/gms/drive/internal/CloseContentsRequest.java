package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR = new zzg();
    final int zzFG;
    final Contents zzTj;
    final Boolean zzTl;

    CloseContentsRequest(int i, Contents contents, Boolean bool) {
        this.zzFG = i;
        this.zzTj = contents;
        this.zzTl = bool;
    }

    public CloseContentsRequest(Contents contents, boolean z) {
        this(1, contents, Boolean.valueOf(z));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
