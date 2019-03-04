package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR = new zzd();
    private final int zzFG;
    private final String zzFO;
    private final long zzON;
    private final List<DataType> zzYA;
    private final long zzYq;
    private final zznv zzaaN;
    private final List<DataSource> zzaaO;
    private final List<Session> zzaaP;
    private final boolean zzaaQ;
    private final boolean zzaaR;

    public class Builder {
        private long zzON;
        private List<DataType> zzYA = new ArrayList();
        private long zzYq;
        private List<DataSource> zzaaO = new ArrayList();
        private List<Session> zzaaP = new ArrayList();
        private boolean zzaaQ = false;
        private boolean zzaaR = false;

        private void zzlT() {
            if (!this.zzaaP.isEmpty()) {
                for (Session session : this.zzaaP) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.zzON && session.getEndTime(TimeUnit.MILLISECONDS) <= this.zzYq;
                    zzx.zza(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zzON), Long.valueOf(this.zzYq));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            zzx.zzb(!this.zzaaQ, (Object) "All data is already marked for deletion");
            if (dataSource == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data source");
            if (!this.zzaaO.contains(dataSource)) {
                this.zzaaO.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            zzx.zzb(!this.zzaaQ, (Object) "All data is already marked for deletion");
            if (dataType == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data type");
            if (!this.zzYA.contains(dataType)) {
                this.zzYA.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            zzx.zzb(!this.zzaaR, (Object) "All sessions already marked for deletion");
            zzx.zzb(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a session that has already ended");
            this.zzaaP.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.zzON > 0 && this.zzYq > this.zzON;
            zzx.zza(z2, (Object) "Must specify a valid time interval");
            z2 = (!this.zzaaQ && this.zzaaO.isEmpty() && this.zzYA.isEmpty()) ? false : true;
            boolean z3 = this.zzaaR || !this.zzaaP.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            zzx.zza(z, (Object) "No data or session marked for deletion");
            zzlT();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            boolean z = this.zzYA.isEmpty() && this.zzaaO.isEmpty();
            zzx.zzb(z, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", this.zzaaO, this.zzYA);
            this.zzaaQ = true;
            return this;
        }

        public Builder deleteAllSessions() {
            zzx.zzb(this.zzaaP.isEmpty(), "Specific sessions already added for deletion: %s", this.zzaaP);
            this.zzaaR = true;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            zzx.zzb(j > 0, "Invalid start time :%d", Long.valueOf(j));
            zzx.zzb(j2 > j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzON = timeUnit.toMillis(j);
            this.zzYq = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataDeleteRequest(int i, long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzON = j;
        this.zzYq = j2;
        this.zzaaO = Collections.unmodifiableList(list);
        this.zzYA = Collections.unmodifiableList(list2);
        this.zzaaP = list3;
        this.zzaaQ = z;
        this.zzaaR = z2;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public DataDeleteRequest(long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 2;
        this.zzON = j;
        this.zzYq = j2;
        this.zzaaO = Collections.unmodifiableList(list);
        this.zzYA = Collections.unmodifiableList(list2);
        this.zzaaP = list3;
        this.zzaaQ = z;
        this.zzaaR = z2;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzON, builder.zzYq, builder.zzaaO, builder.zzYA, builder.zzaaP, builder.zzaaQ, builder.zzaaR, null, null);
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zznv com_google_android_gms_internal_zznv, String str) {
        this(dataDeleteRequest.zzON, dataDeleteRequest.zzYq, dataDeleteRequest.zzaaO, dataDeleteRequest.zzYA, dataDeleteRequest.zzaaP, dataDeleteRequest.zzaaQ, dataDeleteRequest.zzaaR, com_google_android_gms_internal_zznv, str);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzON == dataDeleteRequest.zzON && this.zzYq == dataDeleteRequest.zzYq && zzw.equal(this.zzaaO, dataDeleteRequest.zzaaO) && zzw.equal(this.zzYA, dataDeleteRequest.zzYA) && zzw.equal(this.zzaaP, dataDeleteRequest.zzaaP) && this.zzaaQ == dataDeleteRequest.zzaaQ && this.zzaaR == dataDeleteRequest.zzaaR;
    }

    public boolean deleteAllData() {
        return this.zzaaQ;
    }

    public boolean deleteAllSessions() {
        return this.zzaaR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataDeleteRequest) && zzb((DataDeleteRequest) obj));
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

    public String getPackageName() {
        return this.zzFO;
    }

    public List<Session> getSessions() {
        return this.zzaaP;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzON, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzON), Long.valueOf(this.zzYq));
    }

    public String toString() {
        return zzw.zzk(this).zza("startTimeMillis", Long.valueOf(this.zzON)).zza("endTimeMillis", Long.valueOf(this.zzYq)).zza("dataSources", this.zzaaO).zza("dateTypes", this.zzYA).zza("sessions", this.zzaaP).zza("deleteAllData", Boolean.valueOf(this.zzaaQ)).zza("deleteAllSessions", Boolean.valueOf(this.zzaaR)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public boolean zzlR() {
        return this.zzaaQ;
    }

    public boolean zzlS() {
        return this.zzaaR;
    }

    public long zzlp() {
        return this.zzON;
    }

    public long zzlq() {
        return this.zzYq;
    }
}
