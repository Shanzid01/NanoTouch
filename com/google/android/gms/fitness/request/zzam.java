package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznu.zza;

public class zzam implements SafeParcelable {
    public static final Creator<zzam> CREATOR = new zzan();
    private final String mName;
    private final int zzFG;
    private final String zzFO;
    private final String zzZN;
    private final zznu zzabG;

    zzam(int i, String str, String str2, IBinder iBinder, String str3) {
        this.zzFG = i;
        this.mName = str;
        this.zzZN = str2;
        this.zzabG = iBinder == null ? null : zza.zzaR(iBinder);
        this.zzFO = str3;
    }

    public zzam(String str, String str2, zznu com_google_android_gms_internal_zznu, String str3) {
        this.zzFG = 2;
        this.mName = str;
        this.zzZN = str2;
        this.zzabG = com_google_android_gms_internal_zznu;
        this.zzFO = str3;
    }

    private boolean zzb(zzam com_google_android_gms_fitness_request_zzam) {
        return zzw.equal(this.mName, com_google_android_gms_fitness_request_zzam.mName) && zzw.equal(this.zzZN, com_google_android_gms_fitness_request_zzam.zzZN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzam) && zzb((zzam) obj));
    }

    public String getIdentifier() {
        return this.zzZN;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzZN);
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).zza("identifier", this.zzZN).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzan.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabG == null ? null : this.zzabG.asBinder();
    }
}
