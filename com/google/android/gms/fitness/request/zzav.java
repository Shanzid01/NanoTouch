package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzav implements SafeParcelable {
    public static final Creator<zzav> CREATOR = new zzaw();
    private final int zzFG;
    private final String zzFO;
    private final String zzaaL;
    private final zznv zzaaN;

    zzav(int i, String str, IBinder iBinder, String str2) {
        this.zzFG = i;
        this.zzaaL = str;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str2;
    }

    public zzav(String str, zznv com_google_android_gms_internal_zznv, String str2) {
        this.zzFG = 4;
        this.zzaaL = str;
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
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.zzaaL});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }
}
