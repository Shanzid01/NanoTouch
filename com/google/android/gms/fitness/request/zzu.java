package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class zzu implements SafeParcelable {
    public static final Creator<zzu> CREATOR = new zzv();
    private final int zzFG;
    private final String zzFO;
    private final zzoj zzabk;

    zzu(int i, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzabk = zza.zzaU(iBinder);
        this.zzFO = str;
    }

    public zzu(zzoj com_google_android_gms_internal_zzoj, String str) {
        this.zzFG = 1;
        this.zzabk = com_google_android_gms_internal_zzoj;
        this.zzFO = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return String.format("ListClaimedBleDevicesRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabk.asBinder();
    }
}
