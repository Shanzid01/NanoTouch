package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zznr.zza;
import java.util.List;

public class zzy implements SafeParcelable {
    public static final Creator<zzy> CREATOR = new zzz();
    private final int zzFG;
    private final String zzFO;
    private final zznr zzabm;
    private final List<zzh> zzabn;

    zzy(int i, IBinder iBinder, String str, List<zzh> list) {
        this.zzFG = i;
        this.zzabm = zza.zzaO(iBinder);
        this.zzabn = list;
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

    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabm.asBinder();
    }

    public List<zzh> zzma() {
        return this.zzabn;
    }
}
