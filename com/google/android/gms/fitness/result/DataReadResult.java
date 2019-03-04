package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Creator<DataReadResult> CREATOR = new zzb();
    private final int zzFG;
    private final Status zzHb;
    private final List<DataSet> zzYD;
    private final List<DataSource> zzYN;
    private final List<Bucket> zzabM;
    private int zzabN;
    private final List<DataType> zzabO;

    DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.zzFG = i;
        this.zzHb = status;
        this.zzabN = i2;
        this.zzYN = list3;
        this.zzabO = list4;
        this.zzYD = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.zzYD.add(new DataSet(dataSet, (List) list3));
        }
        this.zzabM = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.zzabM.add(new Bucket(bucket, (List) list3));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.zzFG = 5;
        this.zzYD = list;
        this.zzHb = status;
        this.zzabM = list2;
        this.zzabN = 1;
        this.zzYN = new ArrayList();
        this.zzabO = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzabM.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzHb.equals(dataReadResult.zzHb) && zzw.equal(this.zzYD, dataReadResult.zzYD) && zzw.equal(this.zzabM, dataReadResult.zzabM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && zzc((DataReadResult) obj));
    }

    public List<Bucket> getBuckets() {
        return this.zzabM;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzYD) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataSource.getStreamIdentifier()}));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzYD) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataType.getName()}));
    }

    public List<DataSet> getDataSets() {
        return this.zzYD;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzYD, this.zzabM);
    }

    public String toString() {
        return zzw.zzk(this).zza("status", this.zzHb).zza("dataSets", this.zzYD.size() > 5 ? this.zzYD.size() + " data sets" : this.zzYD).zza("buckets", this.zzabM.size() > 5 ? this.zzabM.size() + " buckets" : this.zzabM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzYD);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzabM);
        }
    }

    List<DataSource> zzlx() {
        return this.zzYN;
    }

    public int zzmn() {
        return this.zzabN;
    }

    List<RawBucket> zzmo() {
        List<RawBucket> arrayList = new ArrayList(this.zzabM.size());
        for (Bucket rawBucket : this.zzabM) {
            arrayList.add(new RawBucket(rawBucket, this.zzYN, this.zzabO));
        }
        return arrayList;
    }

    List<RawDataSet> zzmp() {
        List<RawDataSet> arrayList = new ArrayList(this.zzYD.size());
        for (DataSet rawDataSet : this.zzYD) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzYN, this.zzabO));
        }
        return arrayList;
    }

    List<DataType> zzmq() {
        return this.zzabO;
    }
}
