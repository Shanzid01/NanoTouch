package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class zzrw implements SafeParcelable {
    public static final zzrx CREATOR = new zzrx();
    final int versionCode;
    public final zzro zzati;

    zzrw(int i, zzro com_google_android_gms_internal_zzro) {
        this.versionCode = i;
        this.zzati = (zzro) zzx.zzl(com_google_android_gms_internal_zzro);
    }

    public int describeContents() {
        zzrx com_google_android_gms_internal_zzrx = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzrx com_google_android_gms_internal_zzrx = CREATOR;
        zzrx.zza(this, parcel, i);
    }
}
