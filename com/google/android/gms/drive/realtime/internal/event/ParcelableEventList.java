package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new zzd();
    final int zzFG;
    final DataHolder zzXv;
    final boolean zzXw;
    final List<String> zzXx;
    final List<ParcelableEvent> zzmv;

    ParcelableEventList(int i, List<ParcelableEvent> list, DataHolder dataHolder, boolean z, List<String> list2) {
        this.zzFG = i;
        this.zzmv = list;
        this.zzXv = dataHolder;
        this.zzXw = z;
        this.zzXx = list2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
