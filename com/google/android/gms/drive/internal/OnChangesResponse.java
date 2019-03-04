package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class OnChangesResponse implements SafeParcelable {
    public static final Creator<OnChangesResponse> CREATOR = new zzao();
    final int zzFG;
    final DataHolder zzUL;
    final List<DriveId> zzUM;
    final ChangeSequenceNumber zzUN;
    final boolean zzUO;

    OnChangesResponse(int i, DataHolder dataHolder, List<DriveId> list, ChangeSequenceNumber changeSequenceNumber, boolean z) {
        this.zzFG = i;
        this.zzUL = dataHolder;
        this.zzUM = list;
        this.zzUN = changeSequenceNumber;
        this.zzUO = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzao.zza(this, parcel, i | 1);
    }
}
