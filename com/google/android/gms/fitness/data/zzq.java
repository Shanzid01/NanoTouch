package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzq implements SafeParcelable {
    public static final Creator<zzq> CREATOR = new zzr();
    final int zzFG;
    private final Session zzYs;
    private final DataSet zzZP;

    zzq(int i, Session session, DataSet dataSet) {
        this.zzFG = i;
        this.zzYs = session;
        this.zzZP = dataSet;
    }

    private boolean zza(zzq com_google_android_gms_fitness_data_zzq) {
        return zzw.equal(this.zzYs, com_google_android_gms_fitness_data_zzq.zzYs) && zzw.equal(this.zzZP, com_google_android_gms_fitness_data_zzq.zzZP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzq) && zza((zzq) obj));
    }

    public Session getSession() {
        return this.zzYs;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYs, this.zzZP);
    }

    public String toString() {
        return zzw.zzk(this).zza("session", this.zzYs).zza("dataSet", this.zzZP).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    public DataSet zzlH() {
        return this.zzZP;
    }
}
