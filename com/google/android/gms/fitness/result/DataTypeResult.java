package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new zzh();
    private final int zzFG;
    private final Status zzHb;
    private final DataType zzYo;

    DataTypeResult(int i, Status status, DataType dataType) {
        this.zzFG = i;
        this.zzHb = status;
        this.zzYo = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.zzFG = 2;
        this.zzHb = status;
        this.zzYo = dataType;
    }

    public static DataTypeResult zzD(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzHb.equals(dataTypeResult.zzHb) && zzw.equal(this.zzYo, dataTypeResult.zzYo);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && zzb((DataTypeResult) obj));
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzYo);
    }

    public String toString() {
        return zzw.zzk(this).zza("status", this.zzHb).zza("dataType", this.zzYo).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
