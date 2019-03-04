package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Creator<OnFetchThumbnailResponse> CREATOR = new zzav();
    final int zzFG;
    final ParcelFileDescriptor zzUX;

    OnFetchThumbnailResponse(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzFG = i;
        this.zzUX = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzav.zza(this, parcel, i | 1);
    }
}
