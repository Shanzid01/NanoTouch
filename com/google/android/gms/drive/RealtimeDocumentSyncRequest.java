package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new zzh();
    final int zzFG;
    final List<String> zzSB;
    final List<String> zzSC;

    RealtimeDocumentSyncRequest(int i, List<String> list, List<String> list2) {
        this.zzFG = i;
        this.zzSB = (List) zzx.zzl(list);
        this.zzSC = (List) zzx.zzl(list2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
