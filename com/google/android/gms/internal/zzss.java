package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsm.zza;

public final class zzss implements SafeParcelable {
    public static final Creator<zzss> CREATOR = new zzst();
    final int versionCode;
    public long zzatv;
    public zzsm zzatw;

    zzss() {
        this.versionCode = 1;
    }

    zzss(int i, long j, IBinder iBinder) {
        this.versionCode = i;
        this.zzatv = j;
        this.zzatw = zza.zzco(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzst.zza(this, parcel, i);
    }

    IBinder zzrq() {
        return this.zzatw.asBinder();
    }
}
