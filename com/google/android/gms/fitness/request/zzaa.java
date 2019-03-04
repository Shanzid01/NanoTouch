package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zzns.zza;

public class zzaa implements SafeParcelable {
    public static final Creator<zzaa> CREATOR = new zzab();
    private final int zzFG;
    private final String zzFO;
    private final zzns zzabo;

    zzaa(int i, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzabo = zza.zzaP(iBinder);
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
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabo.asBinder();
    }
}
