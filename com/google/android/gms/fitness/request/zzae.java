package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import com.google.android.gms.internal.zznv;

public class zzae implements SafeParcelable {
    public static final Creator<zzae> CREATOR = new zzaf();
    private final PendingIntent mPendingIntent;
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;
    private final zzk zzabp;

    zzae(int i, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, String str) {
        this.zzFG = i;
        this.zzabp = iBinder == null ? null : zza.zzav(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaaN = zznv.zza.zzaS(iBinder2);
        this.zzFO = str;
    }

    public zzae(zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 3;
        this.zzabp = com_google_android_gms_fitness_data_zzk;
        this.mPendingIntent = pendingIntent;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzabp});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public PendingIntent zzmb() {
        return this.mPendingIntent;
    }

    IBinder zzmg() {
        return this.zzabp == null ? null : this.zzabp.asBinder();
    }
}
