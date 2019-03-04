package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final int zzFG;
    private final String zzadN;
    private final int zzadO;

    public ConnectionInfo(int i, String str, int i2) {
        this.zzFG = i;
        this.zzadN = str;
        this.zzadO = i2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ConnectionInfoCreator.zza(this, parcel, i);
    }

    public String zznl() {
        return this.zzadN;
    }

    public int zznm() {
        return this.zzadO;
    }
}
