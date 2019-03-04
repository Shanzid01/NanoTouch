package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR = new zzo();
    final int zzFG;
    public final boolean zzYF;
    public final int zzZJ;
    public final int zzZL;
    public final List<RawDataPoint> zzZM;

    public RawDataSet(int i, int i2, int i3, List<RawDataPoint> list, boolean z) {
        this.zzFG = i;
        this.zzZJ = i2;
        this.zzZL = i3;
        this.zzZM = list;
        this.zzYF = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list, List<DataType> list2) {
        this.zzFG = 3;
        this.zzZM = dataSet.zzk(list);
        this.zzYF = dataSet.zzlo();
        this.zzZJ = zzt.zza(dataSet.getDataSource(), list);
        this.zzZL = zzt.zza(dataSet.getDataType(), list2);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzZJ == rawDataSet.zzZJ && this.zzYF == rawDataSet.zzYF && zzw.equal(this.zzZM, rawDataSet.zzZM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && zza((RawDataSet) obj));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzZJ));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzZJ), this.zzZM});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
