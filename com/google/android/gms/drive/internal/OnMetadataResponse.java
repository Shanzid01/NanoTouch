package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new zzay();
    final int zzFG;
    final MetadataBundle zzTp;

    OnMetadataResponse(int i, MetadataBundle metadataBundle) {
        this.zzFG = i;
        this.zzTp = metadataBundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzay.zza(this, parcel, i);
    }

    public MetadataBundle zzkU() {
        return this.zzTp;
    }
}
