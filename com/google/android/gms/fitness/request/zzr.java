package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zznw.zza;

public class zzr implements SafeParcelable {
    public static final Creator<zzr> CREATOR = new zzs();
    private final int zzFG;
    private final String zzFO;
    private final zznw zzabj;

    zzr(int i, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzabj = zza.zzaT(iBinder);
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
        return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[]{Integer.valueOf(this.zzFG), this.zzabj, this.zzFO});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabj.asBinder();
    }
}
