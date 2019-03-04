package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzm();
    private final String zzFA;
    final int zzFG;
    private final String zzqd;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.zzFG = i;
        this.zzFA = str;
        this.zzqd = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.zzFG = 1;
        this.zzFA = (String) zzx.zzl(dataItemAsset.getId());
        this.zzqd = (String) zzx.zzl(dataItemAsset.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzvi();
    }

    public String getDataItemKey() {
        return this.zzqd;
    }

    public String getId() {
        return this.zzFA;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzFA == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzFA);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zzqd);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public DataItemAsset zzvi() {
        return this;
    }
}
