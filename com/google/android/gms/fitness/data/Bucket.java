package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zzxd.zza;
import com.google.android.gms.internal.zzxd.zzc;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
    public static final Creator<Bucket> CREATOR = new zzd();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    public static final Comparator<Bucket> zzYB = new C09831();
    private final int zzFG;
    private final long zzON;
    private final int zzYC;
    private final List<DataSet> zzYD;
    private final int zzYE;
    private boolean zzYF;
    private final long zzYq;
    private final Session zzYs;

    final class C09831 implements Comparator<Bucket> {
        C09831() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Bucket) obj, (Bucket) obj2);
        }

        public int zza(Bucket bucket, Bucket bucket2) {
            return zzmd.compare(bucket.getStartTime(TimeUnit.MILLISECONDS), bucket2.getStartTime(TimeUnit.MILLISECONDS));
        }
    }

    Bucket(int i, long j, long j2, Session session, int i2, List<DataSet> list, int i3, boolean z) {
        this.zzYF = false;
        this.zzFG = i;
        this.zzON = j;
        this.zzYq = j2;
        this.zzYs = session;
        this.zzYC = i2;
        this.zzYD = list;
        this.zzYE = i3;
        this.zzYF = z;
    }

    public Bucket(RawBucket rawBucket, List<DataSource> list) {
        this(zzms.zzb(rawBucket), (List) list);
    }

    public Bucket(zza com_google_android_gms_internal_zzxd_zza, List<DataSource> list) {
        this(2, com_google_android_gms_internal_zzxd_zza.zzaIq, com_google_android_gms_internal_zzxd_zza.zzaIr, com_google_android_gms_internal_zzxd_zza.zzaIt == null ? null : zzmw.zzZW.zza(com_google_android_gms_internal_zzxd_zza.zzaIt), com_google_android_gms_internal_zzxd_zza.zzaIu, zza(com_google_android_gms_internal_zzxd_zza.zzaIv, list), com_google_android_gms_internal_zzxd_zza.zzaIw, com_google_android_gms_internal_zzxd_zza.zzaIx);
    }

    private static List<DataSet> zza(zzc[] com_google_android_gms_internal_zzxd_zzcArr, List<DataSource> list) {
        List<DataSet> arrayList = new ArrayList(com_google_android_gms_internal_zzxd_zzcArr.length);
        for (zzc dataSet : com_google_android_gms_internal_zzxd_zzcArr) {
            arrayList.add(new DataSet(dataSet, (List) list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzON == bucket.zzON && this.zzYq == bucket.zzYq && this.zzYC == bucket.zzYC && zzw.equal(this.zzYD, bucket.zzYD) && this.zzYE == bucket.zzYE && this.zzYF == bucket.zzYF;
    }

    public static String zzdg(int i) {
        switch (i) {
            case 0:
                return FitnessActivities.UNKNOWN;
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Bucket) && zza((Bucket) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzYC);
    }

    public int getBucketType() {
        return this.zzYE;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzYD) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zzYD;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYq, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzYs;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzON, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzON), Long.valueOf(this.zzYq), Integer.valueOf(this.zzYC), Integer.valueOf(this.zzYE));
    }

    public String toString() {
        return zzw.zzk(this).zza("startTime", Long.valueOf(this.zzON)).zza("endTime", Long.valueOf(this.zzYq)).zza("activity", Integer.valueOf(this.zzYC)).zza("dataSets", this.zzYD).zza("bucketType", zzdg(this.zzYE)).zza("serverHasMoreData", Boolean.valueOf(this.zzYF)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzb(Bucket bucket) {
        return this.zzON == bucket.zzON && this.zzYq == bucket.zzYq && this.zzYC == bucket.zzYC && this.zzYE == bucket.zzYE;
    }

    public int zzln() {
        return this.zzYC;
    }

    public boolean zzlo() {
        if (this.zzYF) {
            return true;
        }
        for (DataSet zzlo : this.zzYD) {
            if (zzlo.zzlo()) {
                return true;
            }
        }
        return false;
    }

    public long zzlp() {
        return this.zzON;
    }

    public long zzlq() {
        return this.zzYq;
    }
}
