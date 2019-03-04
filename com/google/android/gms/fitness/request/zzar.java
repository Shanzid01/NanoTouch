package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzt.zza;
import com.google.android.gms.internal.zznv;

public class zzar implements SafeParcelable {
    public static final Creator<zzar> CREATOR = new zzas();
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;
    private final zzt zzabH;

    zzar(int i, IBinder iBinder, IBinder iBinder2, String str) {
        this.zzFG = i;
        this.zzabH = zza.zzaV(iBinder);
        this.zzaaN = iBinder2 == null ? null : zznv.zza.zzaS(iBinder2);
        this.zzFO = str;
    }

    public zzar(BleScanCallback bleScanCallback, zznv com_google_android_gms_internal_zznv, String str) {
        this(zza.zza.zzlO().zzb(bleScanCallback), com_google_android_gms_internal_zznv, str);
    }

    public zzar(zzt com_google_android_gms_fitness_request_zzt, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 2;
        this.zzabH = com_google_android_gms_fitness_request_zzt;
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

    public void writeToParcel(Parcel parcel, int i) {
        zzas.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public IBinder zzmk() {
        return this.zzabH.asBinder();
    }
}
