package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzae implements SafeParcelable {
    public static final Creator<zzae> CREATOR = new zzaf();
    public final int statusCode;
    public final int versionCode;
    public final zzao zzaGn;

    zzae(int i, int i2, zzao com_google_android_gms_wearable_internal_zzao) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGn = com_google_android_gms_wearable_internal_zzao;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }
}
