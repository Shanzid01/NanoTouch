package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzb implements SafeParcelable {
    public static final Creator<zzb> CREATOR = new zzc();
    private final int zzFG;
    private final String zzFO;
    private final String zzaaL;
    private final BleDevice zzaaM;
    private final zznv zzaaN;

    zzb(int i, String str, BleDevice bleDevice, IBinder iBinder, String str2) {
        this.zzFG = i;
        this.zzaaL = str;
        this.zzaaM = bleDevice;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str2;
    }

    public zzb(String str, BleDevice bleDevice, zznv com_google_android_gms_internal_zznv, String str2) {
        this.zzFG = 3;
        this.zzaaL = str;
        this.zzaaM = bleDevice;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.zzaaL;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.zzaaL, this.zzaaM});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public BleDevice zzlP() {
        return this.zzaaM;
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }
}
