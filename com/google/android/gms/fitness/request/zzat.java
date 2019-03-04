package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class zzat implements SafeParcelable {
    public static final Creator<zzat> CREATOR = new zzau();
    private final int zzFG;
    private final String zzFO;
    private final zznv zzaaN;
    private final Subscription zzabJ;
    private final boolean zzabK;

    zzat(int i, Subscription subscription, boolean z, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzabJ = subscription;
        this.zzabK = z;
        this.zzaaN = iBinder == null ? null : zza.zzaS(iBinder);
        this.zzFO = str;
    }

    public zzat(Subscription subscription, boolean z, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 2;
        this.zzabJ = subscription;
        this.zzabK = z;
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
        return zzw.zzk(this).zza("subscription", this.zzabJ).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzau.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public Subscription zzml() {
        return this.zzabJ;
    }

    public boolean zzmm() {
        return this.zzabK;
    }
}
