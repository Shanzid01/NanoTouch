package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.zzwm;
import com.google.android.gms.internal.zzwm.zza;
import com.google.android.gms.internal.zzwn;
import com.google.android.gms.internal.zzwx;
import java.util.ArrayList;
import java.util.List;

public class DataMapItem {
    private final Uri mUri;
    private final DataMap zzaFy;

    private DataMapItem(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzaFy = zza((DataItem) dataItem.freeze());
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        if (dataItem != null) {
            return new DataMapItem(dataItem);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    private DataMap zza(DataItem dataItem) {
        if (dataItem.getData() == null && dataItem.getAssets().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (dataItem.getData() == null) {
            return new DataMap();
        } else {
            try {
                List arrayList = new ArrayList();
                int size = dataItem.getAssets().size();
                for (int i = 0; i < size; i++) {
                    DataItemAsset dataItemAsset = (DataItemAsset) dataItem.getAssets().get(Integer.toString(i));
                    if (dataItemAsset == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + dataItem);
                    }
                    arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                }
                return zzwm.zza(new zza(zzwn.zzq(dataItem.getData()), arrayList));
            } catch (zzwx e) {
                throw new IllegalStateException("Unable to parse. Not a DataItem.");
            }
        }
    }

    public DataMap getDataMap() {
        return this.zzaFy;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
