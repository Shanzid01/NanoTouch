package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class zzk implements Parcelable {
    private volatile transient boolean zzSN = false;

    public void writeToParcel(Parcel parcel, int i) {
        zzx.zzN(!zzkz());
        this.zzSN = true;
        zzI(parcel, i);
    }

    protected abstract void zzI(Parcel parcel, int i);

    public final boolean zzkz() {
        return this.zzSN;
    }
}
