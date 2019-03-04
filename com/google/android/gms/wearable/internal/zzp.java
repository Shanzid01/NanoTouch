package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzp implements SafeParcelable, DataItem {
    public static final Creator<zzp> CREATOR = new zzq();
    private final Uri mUri;
    final int zzFG;
    private final Map<String, DataItemAsset> zzaGg;
    private byte[] zzakd;

    zzp(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.zzFG = i;
        this.mUri = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.zzaGg = hashMap;
        this.zzakd = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzvk();
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

    public /* synthetic */ DataItem setData(byte[] bArr) {
        return zzp(bArr);
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
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

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    public zzp zzp(byte[] bArr) {
        this.zzakd = bArr;
        return this;
    }

    public Bundle zzuY() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.zzaGg.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    public zzp zzvk() {
        return this;
    }
}
