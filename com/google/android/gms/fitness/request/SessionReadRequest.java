package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zznt.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR = new zzah();
    private final int zzFG;
    private final String zzFO;
    private final long zzON;
    private final List<DataType> zzYA;
    private final long zzYq;
    private final List<DataSource> zzaaO;
    private final boolean zzaaZ;
    private final String zzabC;
    private boolean zzabD;
    private final List<String> zzabE;
    private final zznt zzabF;
    private final String zzyL;

    public class Builder {
        private long zzON = 0;
        private List<DataType> zzYA = new ArrayList();
        private long zzYq = 0;
        private List<DataSource> zzaaO = new ArrayList();
        private boolean zzaaZ = false;
        private String zzabC;
        private boolean zzabD = false;
        private List<String> zzabE = new ArrayList();
        private String zzyL;

        public SessionReadRequest build() {
            zzx.zzb(this.zzON > 0, "Invalid start time: %s", Long.valueOf(this.zzON));
            boolean z = this.zzYq > 0 && this.zzYq > this.zzON;
            zzx.zzb(z, "Invalid end time: %s", Long.valueOf(this.zzYq));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzaaZ = true;
            return this;
        }

        public Builder excludePackage(String str) {
            zzx.zzb((Object) str, (Object) "Attempting to use a null package name");
            if (!this.zzabE.contains(str)) {
                this.zzabE.add(str);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.zzaaO.contains(dataSource)) {
                this.zzaaO.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.zzYA.contains(dataType)) {
                this.zzYA.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzabD = true;
            return this;
        }

        public Builder setSessionId(String str) {
            this.zzyL = str;
            return this;
        }

        public Builder setSessionName(String str) {
            this.zzabC = str;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzON = timeUnit.toMillis(j);
            this.zzYq = timeUnit.toMillis(j2);
            return this;
        }
    }

    SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder, String str3) {
        this.zzFG = i;
        this.zzabC = str;
        this.zzyL = str2;
        this.zzON = j;
        this.zzYq = j2;
        this.zzYA = Collections.unmodifiableList(list);
        this.zzaaO = Collections.unmodifiableList(list2);
        this.zzabD = z;
        this.zzaaZ = z2;
        this.zzabE = list3;
        this.zzabF = iBinder == null ? null : zza.zzaQ(iBinder);
        this.zzFO = str3;
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzabC, builder.zzyL, builder.zzON, builder.zzYq, builder.zzYA, builder.zzaaO, builder.zzabD, builder.zzaaZ, builder.zzabE, null, null);
    }

    public SessionReadRequest(SessionReadRequest sessionReadRequest, zznt com_google_android_gms_internal_zznt, String str) {
        this(sessionReadRequest.zzabC, sessionReadRequest.zzyL, sessionReadRequest.zzON, sessionReadRequest.zzYq, sessionReadRequest.zzYA, sessionReadRequest.zzaaO, sessionReadRequest.zzabD, sessionReadRequest.zzaaZ, sessionReadRequest.zzabE, com_google_android_gms_internal_zznt, str);
    }

    public SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, zznt com_google_android_gms_internal_zznt, String str3) {
        this.zzFG = 4;
        this.zzabC = str;
        this.zzyL = str2;
        this.zzON = j;
        this.zzYq = j2;
        this.zzYA = Collections.unmodifiableList(list);
        this.zzaaO = Collections.unmodifiableList(list2);
        this.zzabD = z;
        this.zzaaZ = z2;
        this.zzabE = list3;
        this.zzabF = com_google_android_gms_internal_zznt;
        this.zzFO = str3;
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return zzw.equal(this.zzabC, sessionReadRequest.zzabC) && this.zzyL.equals(sessionReadRequest.zzyL) && this.zzON == sessionReadRequest.zzON && this.zzYq == sessionReadRequest.zzYq && zzw.equal(this.zzYA, sessionReadRequest.zzYA) && zzw.equal(this.zzaaO, sessionReadRequest.zzaaO) && this.zzabD == sessionReadRequest.zzabD && this.zzabE.equals(sessionReadRequest.zzabE) && this.zzaaZ == sessionReadRequest.zzaaZ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && zzb((SessionReadRequest) obj));
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

    public List<String> getExcludedPackages() {
        return this.zzabE;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    public String getSessionId() {
        return this.zzyL;
    }

    public String getSessionName() {
        return this.zzabC;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzON, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzabC, this.zzyL, Long.valueOf(this.zzON), Long.valueOf(this.zzYq));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzabD;
    }

    public String toString() {
        return zzw.zzk(this).zza("sessionName", this.zzabC).zza("sessionId", this.zzyL).zza("startTimeMillis", Long.valueOf(this.zzON)).zza("endTimeMillis", Long.valueOf(this.zzYq)).zza("dataTypes", this.zzYA).zza("dataSources", this.zzaaO).zza("sessionsFromAllApps", Boolean.valueOf(this.zzabD)).zza("excludedPackages", this.zzabE).zza("useServer", Boolean.valueOf(this.zzaaZ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabF == null ? null : this.zzabF.asBinder();
    }

    public boolean zzlV() {
        return this.zzaaZ;
    }

    public long zzlp() {
        return this.zzON;
    }

    public long zzlq() {
        return this.zzYq;
    }

    public boolean zzmj() {
        return this.zzabD;
    }
}
