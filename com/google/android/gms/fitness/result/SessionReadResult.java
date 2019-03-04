package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR = new zzl();
    private final int zzFG;
    private final Status zzHb;
    private final List<Session> zzaaP;
    private final List<zzq> zzabU;

    SessionReadResult(int i, List<Session> list, List<zzq> list2, Status status) {
        this.zzFG = i;
        this.zzaaP = list;
        this.zzabU = Collections.unmodifiableList(list2);
        this.zzHb = status;
    }

    public SessionReadResult(List<Session> list, List<zzq> list2, Status status) {
        this.zzFG = 3;
        this.zzaaP = list;
        this.zzabU = Collections.unmodifiableList(list2);
        this.zzHb = status;
    }

    public static SessionReadResult zzF(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzHb.equals(sessionReadResult.zzHb) && zzw.equal(this.zzaaP, sessionReadResult.zzaaP) && zzw.equal(this.zzabU, sessionReadResult.zzabU);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && zzb((SessionReadResult) obj));
    }

    public List<DataSet> getDataSet(Session session) {
        zzx.zzb(this.zzaaP.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (zzq com_google_android_gms_fitness_data_zzq : this.zzabU) {
            if (zzw.equal(session, com_google_android_gms_fitness_data_zzq.getSession())) {
                arrayList.add(com_google_android_gms_fitness_data_zzq.zzlH());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzx.zzb(this.zzaaP.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (zzq com_google_android_gms_fitness_data_zzq : this.zzabU) {
            if (zzw.equal(session, com_google_android_gms_fitness_data_zzq.getSession()) && dataType.equals(com_google_android_gms_fitness_data_zzq.zzlH().getDataType())) {
                arrayList.add(com_google_android_gms_fitness_data_zzq.zzlH());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.zzaaP;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzaaP, this.zzabU);
    }

    public String toString() {
        return zzw.zzk(this).zza("status", this.zzHb).zza("sessions", this.zzaaP).zza("sessionDataSets", this.zzabU).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public List<zzq> zzmt() {
        return this.zzabU;
    }
}
