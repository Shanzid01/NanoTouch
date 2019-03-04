package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzwm;
import com.google.android.gms.internal.zzwm.zza;
import com.google.android.gms.internal.zzwy;

public class PutDataMapRequest {
    private final DataMap zzaFy = new DataMap();
    private final PutDataRequest zzaFz;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.zzaFz = putDataRequest;
        if (dataMap != null) {
            this.zzaFy.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String str) {
        return new PutDataMapRequest(PutDataRequest.create(str), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem dataMapItem) {
        return new PutDataMapRequest(PutDataRequest.zzn(dataMapItem.getUri()), dataMapItem.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String str) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
    }

    public PutDataRequest asPutDataRequest() {
        zza zza = zzwm.zza(this.zzaFy);
        this.zzaFz.setData(zzwy.zzf(zza.zzaGQ));
        int size = zza.zzaGR.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) zza.zzaGR.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.zzaFz.putAsset(num, asset);
                i++;
            }
        }
        return this.zzaFz;
    }

    public DataMap getDataMap() {
        return this.zzaFy;
    }

    public Uri getUri() {
        return this.zzaFz.getUri();
    }
}
