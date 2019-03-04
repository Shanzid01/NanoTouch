package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzru.zza;

public final class zzse implements SafeParcelable {
    public static final Creator<zzse> CREATOR = new zzsf();
    final int versionCode;
    public zzrw zzatk;
    public zzru zzatm;

    zzse() {
        this.versionCode = 1;
    }

    zzse(int i, zzrw com_google_android_gms_internal_zzrw, IBinder iBinder) {
        this.versionCode = i;
        this.zzatk = com_google_android_gms_internal_zzrw;
        this.zzatm = zza.zzck(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzsf.zza(this, parcel, i);
    }

    IBinder zzrq() {
        return this.zzatm.asBinder();
    }
}
