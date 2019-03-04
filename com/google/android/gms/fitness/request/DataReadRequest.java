package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzng;
import com.google.android.gms.internal.zzng.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new zzg();
    public static final int NO_LIMIT = 0;
    private final int zzFG;
    private final String zzFO;
    private final long zzON;
    private final List<DataType> zzYA;
    private final int zzYE;
    private final long zzYq;
    private final List<DataSource> zzaaO;
    private final List<DataType> zzaaT;
    private final List<DataSource> zzaaU;
    private final long zzaaV;
    private final DataSource zzaaW;
    private final int zzaaX;
    private final boolean zzaaY;
    private final boolean zzaaZ;
    private final zzng zzaba;

    public class Builder {
        private long zzON;
        private List<DataType> zzYA = new ArrayList();
        private int zzYE = 0;
        private long zzYq;
        private List<DataSource> zzaaO = new ArrayList();
        private List<DataType> zzaaT = new ArrayList();
        private List<DataSource> zzaaU = new ArrayList();
        private long zzaaV = 0;
        private DataSource zzaaW;
        private int zzaaX = 0;
        private boolean zzaaY = false;
        private boolean zzaaZ = false;

        public Builder aggregate(DataSource dataSource, DataType dataType) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzx.zza(!this.zzaaO.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            DataType dataType2 = dataSource.getDataType();
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType2), "Unsupported input data type specified for aggregation: %s", dataType2);
            zzx.zzb(DataType.getAggregatesForInput(dataType2).contains(dataType), "Invalid output aggregate data type specified: %s -> %s", dataType2, dataType);
            if (!this.zzaaU.contains(dataSource)) {
                this.zzaaU.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType dataType, DataType dataType2) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzYA.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            zzx.zzb(DataType.getAggregatesForInput(dataType).contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.zzaaT.contains(dataType)) {
                this.zzaaT.add(dataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzYE == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzYE));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzYE = 4;
            this.zzaaV = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit, DataSource dataSource) {
            zzx.zzb(this.zzYE == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzYE));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            zzx.zzb(dataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzaaW = dataSource;
            this.zzYE = 4;
            this.zzaaV = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzYE == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzYE));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzYE = 3;
            this.zzaaV = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit, DataSource dataSource) {
            zzx.zzb(this.zzYE == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzYE));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            zzx.zzb(dataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzaaW = dataSource;
            this.zzYE = 3;
            this.zzaaV = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzYE == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzYE));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzYE = 2;
            this.zzaaV = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzYE == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzYE));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzYE = 1;
            this.zzaaV = timeUnit.toMillis((long) i);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.zzaaO.isEmpty() && this.zzYA.isEmpty() && this.zzaaU.isEmpty() && this.zzaaT.isEmpty()) ? false : true;
            zzx.zza(z2, (Object) "Must add at least one data source (aggregated or detailed)");
            zzx.zza(this.zzON > 0, "Invalid start time: %s", Long.valueOf(this.zzON));
            z2 = this.zzYq > 0 && this.zzYq > this.zzON;
            zzx.zza(z2, "Invalid end time: %s", Long.valueOf(this.zzYq));
            z2 = this.zzaaU.isEmpty() && this.zzaaT.isEmpty();
            if (!(z2 && this.zzYE == 0) && (z2 || this.zzYE == 0)) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzaaZ = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzx.zzb(!this.zzaaU.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzaaO.contains(dataSource)) {
                this.zzaaO.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzaaT.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzYA.contains(dataType)) {
                this.zzYA.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int i) {
            zzx.zzb(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.zzaaX = i;
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.zzON = timeUnit.toMillis(j);
            this.zzYq = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYA = Collections.unmodifiableList(list);
        this.zzaaO = Collections.unmodifiableList(list2);
        this.zzON = j;
        this.zzYq = j2;
        this.zzaaT = Collections.unmodifiableList(list3);
        this.zzaaU = Collections.unmodifiableList(list4);
        this.zzYE = i2;
        this.zzaaV = j3;
        this.zzaaW = dataSource;
        this.zzaaX = i3;
        this.zzaaY = z;
        this.zzaaZ = z2;
        this.zzaba = iBinder == null ? null : zza.zzaD(iBinder);
        this.zzFO = str;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzYA, builder.zzaaO, builder.zzON, builder.zzYq, builder.zzaaT, builder.zzaaU, builder.zzYE, builder.zzaaV, builder.zzaaW, builder.zzaaX, builder.zzaaY, builder.zzaaZ, null, null);
    }

    public DataReadRequest(DataReadRequest dataReadRequest, zzng com_google_android_gms_internal_zzng, String str) {
        this(dataReadRequest.zzYA, dataReadRequest.zzaaO, dataReadRequest.zzON, dataReadRequest.zzYq, dataReadRequest.zzaaT, dataReadRequest.zzaaU, dataReadRequest.zzYE, dataReadRequest.zzaaV, dataReadRequest.zzaaW, dataReadRequest.zzaaX, dataReadRequest.zzaaY, dataReadRequest.zzaaZ, com_google_android_gms_internal_zzng, str);
    }

    public DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, zzng com_google_android_gms_internal_zzng, String str) {
        this.zzFG = 3;
        this.zzYA = Collections.unmodifiableList(list);
        this.zzaaO = Collections.unmodifiableList(list2);
        this.zzON = j;
        this.zzYq = j2;
        this.zzaaT = Collections.unmodifiableList(list3);
        this.zzaaU = Collections.unmodifiableList(list4);
        this.zzYE = i;
        this.zzaaV = j3;
        this.zzaaW = dataSource;
        this.zzaaX = i2;
        this.zzaaY = z;
        this.zzaaZ = z2;
        this.zzaba = com_google_android_gms_internal_zzng;
        this.zzFO = str;
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzYA.equals(dataReadRequest.zzYA) && this.zzaaO.equals(dataReadRequest.zzaaO) && this.zzON == dataReadRequest.zzON && this.zzYq == dataReadRequest.zzYq && this.zzYE == dataReadRequest.zzYE && this.zzaaU.equals(dataReadRequest.zzaaU) && this.zzaaT.equals(dataReadRequest.zzaaT) && zzw.equal(this.zzaaW, dataReadRequest.zzaaW) && this.zzaaV == dataReadRequest.zzaaV && this.zzaaZ == dataReadRequest.zzaaZ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && zzb((DataReadRequest) obj));
    }

    public DataSource getActivityDataSource() {
        return this.zzaaW;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzaaU;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzaaT;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaaV, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzYE;
    }

    public List<DataSource> getDataSources() {
        return this.zzaaO;
    }

    public List<DataType> getDataTypes() {
        return this.zzYA;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYq, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzaaX;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzON, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzYE), Long.valueOf(this.zzON), Long.valueOf(this.zzYq));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.zzYA.isEmpty()) {
            for (DataType zzlB : this.zzYA) {
                stringBuilder.append(zzlB.zzlB()).append(" ");
            }
        }
        if (!this.zzaaO.isEmpty()) {
            for (DataSource toDebugString : this.zzaaO) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.zzYE != 0) {
            stringBuilder.append("bucket by ").append(Bucket.zzdg(this.zzYE));
            if (this.zzaaV > 0) {
                stringBuilder.append(" >").append(this.zzaaV).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.zzaaT.isEmpty()) {
            for (DataType zzlB2 : this.zzaaT) {
                stringBuilder.append(zzlB2.zzlB()).append(" ");
            }
        }
        if (!this.zzaaU.isEmpty()) {
            for (DataSource toDebugString2 : this.zzaaU) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzON), Long.valueOf(this.zzON), Long.valueOf(this.zzYq), Long.valueOf(this.zzYq)}));
        if (this.zzaaW != null) {
            stringBuilder.append("activities: ").append(this.zzaaW.toDebugString());
        }
        if (this.zzaaZ) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaba == null ? null : this.zzaba.asBinder();
    }

    public boolean zzlV() {
        return this.zzaaZ;
    }

    public boolean zzlW() {
        return this.zzaaY;
    }

    public long zzlX() {
        return this.zzaaV;
    }

    public long zzlp() {
        return this.zzON;
    }

    public long zzlq() {
        return this.zzYq;
    }
}
