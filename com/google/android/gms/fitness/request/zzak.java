package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzak implements SafeParcelable {
    public static final Creator<zzak> CREATOR = new zzal();
    private final int zzFG;
    private final String zzFO;
    private final Session zzYs;
    private final zznv zzaaN;

    zzak(int i, Session session, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYs = session;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzak(Session session, zznv com_google_android_gms_internal_zznv, String str) {
        zzx.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.zzFG = 2;
        this.zzYs = session;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
    }

    private boolean zzb(zzak com_google_android_gms_fitness_request_zzak) {
        return zzw.equal(this.zzYs, com_google_android_gms_fitness_request_zzak.zzYs);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzak) && zzb((zzak) obj));
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
        return zzw.hashCode(this.zzYs);
    }

    public String toString() {
        return zzw.zzk(this).zza("session", this.zzYs).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }
}
