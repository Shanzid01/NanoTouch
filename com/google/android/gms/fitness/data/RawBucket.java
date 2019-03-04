package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR = new zzm();
    final int zzFG;
    public final long zzON;
    public final List<RawDataSet> zzYD;
    public final int zzYE;
    public final boolean zzYF;
    public final long zzYq;
    public final Session zzYs;
    public final int zzZI;

    public RawBucket(int i, long j, long j2, Session session, int i2, List<RawDataSet> list, int i3, boolean z) {
        this.zzFG = i;
        this.zzON = j;
        this.zzYq = j2;
        this.zzYs = session;
        this.zzZI = i2;
        this.zzYD = list;
        this.zzYE = i3;
        this.zzYF = z;
    }

    public RawBucket(Bucket bucket, List<DataSource> list, List<DataType> list2) {
        this.zzFG = 2;
        this.zzON = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzYq = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzYs = bucket.getSession();
        this.zzZI = bucket.zzln();
        this.zzYE = bucket.getBucketType();
        this.zzYF = bucket.zzlo();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zzYD = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.zzYD.add(new RawDataSet(rawDataSet, list, list2));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzON == rawBucket.zzON && this.zzYq == rawBucket.zzYq && this.zzZI == rawBucket.zzZI && zzw.equal(this.zzYD, rawBucket.zzYD) && this.zzYE == rawBucket.zzYE && this.zzYF == rawBucket.zzYF;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawBucket) && zza((RawBucket) obj));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzON), Long.valueOf(this.zzYq), Integer.valueOf(this.zzYE));
    }

    public String toString() {
        return zzw.zzk(this).zza("startTime", Long.valueOf(this.zzON)).zza("endTime", Long.valueOf(this.zzYq)).zza("activity", Integer.valueOf(this.zzZI)).zza("dataSets", this.zzYD).zza("bucketType", Integer.valueOf(this.zzYE)).zza("serverHasMoreData", Boolean.valueOf(this.zzYF)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
