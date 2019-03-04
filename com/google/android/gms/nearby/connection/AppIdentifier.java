package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class AppIdentifier implements SafeParcelable {
    public static final AppIdentifierCreator CREATOR = new AppIdentifierCreator();
    private final int zzFG;
    private final String zzZN;

    AppIdentifier(int i, String str) {
        this.zzFG = i;
        this.zzZN = zzx.zzb(str, (Object) "Missing application identifier value");
    }

    public AppIdentifier(String str) {
        this(1, str);
    }

    public int describeContents() {
        AppIdentifierCreator appIdentifierCreator = CREATOR;
        return 0;
    }

    public String getIdentifier() {
        return this.zzZN;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppIdentifierCreator appIdentifierCreator = CREATOR;
        AppIdentifierCreator.zza(this, parcel, i);
    }
}
