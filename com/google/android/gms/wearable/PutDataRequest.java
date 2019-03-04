package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new zzg();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final Random zzaFA = new SecureRandom();
    private final Uri mUri;
    final int zzFG;
    private final Bundle zzaFB;
    private byte[] zzakd;

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), null);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.zzFG = i;
        this.mUri = uri;
        this.zzaFB = bundle;
        this.zzaFB.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzakd = bArr;
    }

    public static PutDataRequest create(String str) {
        return zzn(zzdK(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        PutDataRequest zzn = zzn(dataItem.getUri());
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) entry.getKey()));
            }
            zzn.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        zzn.setData(dataItem.getData());
        return zzn;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!str.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzaFA.nextLong());
        return new PutDataRequest(1, zzdK(stringBuilder.toString()));
    }

    private static Uri zzdK(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzn(Uri uri) {
        return new PutDataRequest(1, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzaFB.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.zzaFB.keySet()) {
            hashMap.put(str, (Asset) this.zzaFB.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzaFB.containsKey(str);
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        zzx.zzl(str);
        zzx.zzl(asset);
        this.zzaFB.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzaFB.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzakd = bArr;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.zzakd == null ? "null" : Integer.valueOf(this.zzakd.length)));
        stringBuilder.append(", numAssets=" + this.zzaFB.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzaFB.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzaFB.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public Bundle zzuY() {
        return this.zzaFB;
    }
}
