package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsl.zza;
import java.util.List;

public final class zzsp implements SafeParcelable {
    public static final Creator<zzsp> CREATOR = new zzsq();
    final int versionCode;
    public IBinder zzats;
    public zzsl zzatt;
    public List<zzsi> zzatu;
    public long zzatv;
    public zzsm zzatw;

    zzsp() {
        this.versionCode = 1;
    }

    zzsp(int i, IBinder iBinder, IBinder iBinder2, List<zzsi> list, long j, IBinder iBinder3) {
        this.versionCode = i;
        this.zzats = iBinder;
        this.zzatt = zza.zzcn(iBinder2);
        this.zzatu = list;
        this.zzatv = j;
        this.zzatw = zzsm.zza.zzco(iBinder3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzsq.zza(this, parcel, i);
    }

    IBinder zzrq() {
        return this.zzatw.asBinder();
    }

    IBinder zzru() {
        return this.zzatt == null ? null : this.zzatt.asBinder();
    }
}
