package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
    public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
    private final String mName;
    private final String mValue;
    private final int zzFG;

    AppContentTupleEntity(int i, String str, String str2) {
        this.zzFG = i;
        this.mName = str;
        this.mValue = str2;
    }

    public AppContentTupleEntity(AppContentTuple appContentTuple) {
        this.zzFG = 1;
        this.mName = appContentTuple.getName();
        this.mValue = appContentTuple.getValue();
    }

    static int zza(AppContentTuple appContentTuple) {
        return zzw.hashCode(appContentTuple.getName(), appContentTuple.getValue());
    }

    static boolean zza(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return zzw.equal(appContentTuple2.getName(), appContentTuple.getName()) && zzw.equal(appContentTuple2.getValue(), appContentTuple.getValue());
    }

    static String zzb(AppContentTuple appContentTuple) {
        return zzw.zzk(appContentTuple).zza("Name", appContentTuple.getName()).zza("Value", appContentTuple.getValue()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zznj();
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppContentTupleEntityCreator.zza(this, parcel, i);
    }

    public AppContentTuple zznj() {
        return this;
    }
}
