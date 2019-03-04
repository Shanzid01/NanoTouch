package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzao implements SafeParcelable {
    public static final Creator<zzao> CREATOR = new zzap();
    private final PendingIntent mPendingIntent;
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;

    zzao(int i, PendingIntent pendingIntent, IBinder iBinder, String str) {
        this.zzFG = i;
        this.mPendingIntent = pendingIntent;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzao(PendingIntent pendingIntent, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 4;
        this.mPendingIntent = pendingIntent;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
    }

    private boolean zzb(zzao com_google_android_gms_fitness_request_zzao) {
        return zzw.equal(this.mPendingIntent, com_google_android_gms_fitness_request_zzao.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzao) && zzb((zzao) obj));
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzk(this).zza("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzap.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public PendingIntent zzmb() {
        return this.mPendingIntent;
    }
}
