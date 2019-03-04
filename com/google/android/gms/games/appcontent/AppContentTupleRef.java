package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;

public final class AppContentTupleRef extends zzd implements AppContentTuple {
    AppContentTupleRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentTupleEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zznj();
    }

    public String getName() {
        return getString("tuple_name");
    }

    public String getValue() {
        return getString("tuple_value");
    }

    public int hashCode() {
        return AppContentTupleEntity.zza(this);
    }

    public String toString() {
        return AppContentTupleEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentTupleEntity) zznj()).writeToParcel(parcel, i);
    }

    public AppContentTuple zznj() {
        return new AppContentTupleEntity(this);
    }
}
