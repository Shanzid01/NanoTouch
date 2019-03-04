package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznq.zza;

public class zzw implements SafeParcelable {
    public static final Creator<zzw> CREATOR = new zzx();
    private final int zzFG;
    private final String zzFO;
    private final DataType zzYo;
    private final zznq zzabl;

    zzw(int i, DataType dataType, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYo = dataType;
        this.zzabl = iBinder == null ? null : zza.zzaN(iBinder);
        this.zzFO = str;
    }

    public zzw(DataType dataType, zznq com_google_android_gms_internal_zznq, String str) {
        this.zzFG = 2;
        this.zzYo = dataType;
        this.zzabl = com_google_android_gms_internal_zznq;
        this.zzFO = str;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzx.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabl == null ? null : this.zzabl.asBinder();
    }
}
