package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzo implements DataItem {
    private Uri mUri;
    private Map<String, DataItemAsset> zzaGg;
    private byte[] zzakd;

    public zzo(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzakd = dataItem.getData();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzaGg = Collections.unmodifiableMap(hashMap);
    }

    public /* synthetic */ Object freeze() {
        return zzvj();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzaGg;
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.zzakd == null ? "null" : Integer.valueOf(this.zzakd.length)));
        stringBuilder.append(", numAssets=" + this.zzaGg.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzaGg.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzaGg.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public DataItem zzvj() {
        return this;
    }
}
