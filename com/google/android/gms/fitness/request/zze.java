package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zze implements SafeParcelable {
    public static final Creator<zze> CREATOR = new zzf();
    private final int zzFG;
    private final String zzFO;
    private final DataSet zzZP;
    private final zznv zzaaN;
    private final boolean zzaaS;

    zze(int i, DataSet dataSet, IBinder iBinder, String str, boolean z) {
        this.zzFG = i;
        this.zzZP = dataSet;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
        this.zzaaS = z;
    }

    public zze(DataSet dataSet, zznv com_google_android_gms_internal_zznv, String str, boolean z) {
        this.zzFG = 3;
        this.zzZP = dataSet;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
        this.zzaaS = z;
    }

    private boolean zzb(zze com_google_android_gms_fitness_request_zze) {
        return zzw.equal(this.zzZP, com_google_android_gms_fitness_request_zze.zzZP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zze) && zzb((zze) obj));
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzZP);
    }

    public String toString() {
        return zzw.zzk(this).zza("dataSet", this.zzZP).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public DataSet zzlH() {
        return this.zzZP;
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public boolean zzlU() {
        return this.zzaaS;
    }
}
