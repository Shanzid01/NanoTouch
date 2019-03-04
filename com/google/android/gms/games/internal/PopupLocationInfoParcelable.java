package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager.PopupLocationInfo;

public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int zzFG;
    private final Bundle zzafr;
    private final IBinder zzafs;

    PopupLocationInfoParcelable(int i, Bundle bundle, IBinder iBinder) {
        this.zzFG = i;
        this.zzafr = bundle;
        this.zzafs = iBinder;
    }

    public PopupLocationInfoParcelable(PopupLocationInfo popupLocationInfo) {
        this.zzFG = 1;
        this.zzafr = popupLocationInfo.zzob();
        this.zzafs = popupLocationInfo.zzafv;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public IBinder getWindowToken() {
        return this.zzafs;
    }

    public void writeToParcel(Parcel parcel, int i) {
        PopupLocationInfoParcelableCreator.zza(this, parcel, i);
    }

    public Bundle zzob() {
        return this.zzafr;
    }
}
