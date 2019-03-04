package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzp implements SafeParcelable {
    public static final Creator<zzp> CREATOR = new zzq();
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;

    zzp(int i, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzaaN = zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzp(zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 1;
        this.zzaaN = com_google_android_gms_internal_zznv;
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
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN.asBinder();
    }
}
