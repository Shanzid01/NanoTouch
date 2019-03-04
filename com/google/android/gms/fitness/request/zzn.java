package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzn implements SafeParcelable {
    public static final Creator<zzn> CREATOR = new zzo();
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;

    zzn(int i, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzaaN = zza.zzaS(iBinder);
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
        zzo.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN.asBinder();
    }
}
