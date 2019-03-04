package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzl implements DataItemAsset {
    private final String zzFA;
    private final String zzqd;

    public zzl(DataItemAsset dataItemAsset) {
        this.zzFA = dataItemAsset.getId();
        this.zzqd = dataItemAsset.getDataItemKey();
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
        stringBuilder.append("DataItemAssetEntity[");
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

    public DataItemAsset zzvi() {
        return this;
    }
}
