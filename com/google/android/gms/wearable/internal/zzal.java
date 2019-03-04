package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class zzal implements SafeParcelable, MessageEvent {
    public static final Creator<zzal> CREATOR = new zzam();
    final int zzFG;
    private final int zzRV;
    private final String zzaGw;
    private final byte[] zzakd;
    private final String zzanN;

    zzal(int i, int i2, String str, byte[] bArr, String str2) {
        this.zzFG = i;
        this.zzRV = i2;
        this.zzaGw = str;
        this.zzakd = bArr;
        this.zzanN = str2;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public String getPath() {
        return this.zzaGw;
    }

    public int getRequestId() {
        return this.zzRV;
    }

    public String getSourceNodeId() {
        return this.zzanN;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzRV + "," + this.zzaGw + ", size=" + (this.zzakd == null ? "null" : Integer.valueOf(this.zzakd.length)) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzam.zza(this, parcel, i);
    }
}
