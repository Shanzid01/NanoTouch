package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
    public static final Creator<SessionInsertRequest> CREATOR = new zzag();
    private final int zzFG;
    private final String zzFO;
    private final List<DataSet> zzYD;
    private final Session zzYs;
    private final zznv zzaaN;
    private final List<DataPoint> zzabA;

    public class Builder {
        private List<DataSet> zzYD = new ArrayList();
        private Session zzYs;
        private List<DataPoint> zzabA = new ArrayList();
        private List<DataSource> zzabB = new ArrayList();

        private void zzd(DataPoint dataPoint) {
            zzf(dataPoint);
            zze(dataPoint);
        }

        private void zze(DataPoint dataPoint) {
            long startTime = this.zzYs.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzYs.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 != 0 && endTime2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (endTime2 > endTime) {
                    endTime2 = zzmo.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = startTime2 >= startTime && endTime2 <= endTime;
                zzx.zza(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit}));
                    dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzf(DataPoint dataPoint) {
            long startTime = this.zzYs.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzYs.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzmo.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = timestamp >= startTime && timestamp <= endTime;
                zzx.zza(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit}));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzmi() {
            for (DataSet dataPoints : this.zzYD) {
                for (DataPoint zzd : dataPoints.getDataPoints()) {
                    zzd(zzd);
                }
            }
            for (DataPoint zzd2 : this.zzabA) {
                zzd(zzd2);
            }
        }

        public Builder addAggregateDataPoint(DataPoint dataPoint) {
            zzx.zzb(dataPoint != null, (Object) "Must specify a valid aggregate data point.");
            long startTime = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            boolean z = startTime > 0 && dataPoint.getEndTime(TimeUnit.NANOSECONDS) > startTime;
            zzx.zzb(z, "Aggregate data point should have valid start and end times: %s", dataPoint);
            DataSource dataSource = dataPoint.getDataSource();
            zzx.zza(!this.zzabB.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.zzabB.add(dataSource);
            this.zzabA.add(dataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            zzx.zzb(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            zzx.zza(!this.zzabB.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            zzx.zzb(z, (Object) "No data points specified in the input data set.");
            this.zzabB.add(dataSource);
            this.zzYD.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            zzx.zza(this.zzYs != null, (Object) "Must specify a valid session.");
            if (this.zzYs.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid end time, cannot insert a continuing session.");
            zzmi();
            return new SessionInsertRequest();
        }

        public Builder setSession(Session session) {
            this.zzYs = session;
            return this;
        }
    }

    SessionInsertRequest(int i, Session session, List<DataSet> list, List<DataPoint> list2, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYs = session;
        this.zzYD = Collections.unmodifiableList(list);
        this.zzabA = Collections.unmodifiableList(list2);
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 2;
        this.zzYs = session;
        this.zzYD = Collections.unmodifiableList(list);
        this.zzabA = Collections.unmodifiableList(list2);
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzYs, builder.zzYD, builder.zzabA, null, null);
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zznv com_google_android_gms_internal_zznv, String str) {
        this(sessionInsertRequest.zzYs, sessionInsertRequest.zzYD, sessionInsertRequest.zzabA, com_google_android_gms_internal_zznv, str);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return zzw.equal(this.zzYs, sessionInsertRequest.zzYs) && zzw.equal(this.zzYD, sessionInsertRequest.zzYD) && zzw.equal(this.zzabA, sessionInsertRequest.zzabA);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && zzb((SessionInsertRequest) obj));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzabA;
    }

    public List<DataSet> getDataSets() {
        return this.zzYD;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public Session getSession() {
        return this.zzYs;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYs, this.zzYD, this.zzabA);
    }

    public String toString() {
        return zzw.zzk(this).zza("session", this.zzYs).zza("dataSets", this.zzYD).zza("aggregateDataPoints", this.zzabA).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzag.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }
}
