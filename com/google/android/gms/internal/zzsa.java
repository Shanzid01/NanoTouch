package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzru.zza;

public final class zzsa implements SafeParcelable {
    public static final Creator<zzsa> CREATOR = new zzsb();
    final int versionCode;
    public zzrw zzatk;
    public zzrr zzatl;
    public zzru zzatm;

    zzsa() {
        this.versionCode = 1;
    }

    zzsa(int i, zzrw com_google_android_gms_internal_zzrw, zzrr com_google_android_gms_internal_zzrr, IBinder iBinder) {
        this.versionCode = i;
        this.zzatk = com_google_android_gms_internal_zzrw;
        this.zzatl = com_google_android_gms_internal_zzrr;
        this.zzatm = zza.zzck(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzsb.zza(this, parcel, i);
    }

    IBinder zzrq() {
        return this.zzatm.asBinder();
    }
}
