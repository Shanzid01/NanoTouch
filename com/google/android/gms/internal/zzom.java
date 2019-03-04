package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class zzom implements SafeParcelable {
    public static final Creator<zzom> CREATOR = new zzon();
    private final int zzFG;
    private final DataSource zzYp;

    zzom(int i, DataSource dataSource) {
        this.zzFG = i;
        this.zzYp = dataSource;
    }

    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.zzYp});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzon.zza(this, parcel, i);
    }
}
