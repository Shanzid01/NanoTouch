package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class zzok implements SafeParcelable {
    public static final Creator<zzok> CREATOR = new zzol();
    private final int zzFG;
    private final List<DataType> zzYA;

    zzok(int i, List<DataType> list) {
        this.zzFG = i;
        this.zzYA = list;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzYA);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return zzw.zzk(this).zza("dataTypes", this.zzYA).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzol.zza(this, parcel, i);
    }
}
