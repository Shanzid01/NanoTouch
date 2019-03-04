package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new zzap();
    final int zzFG;
    final Contents zzTO;
    final boolean zzUP;

    OnContentsResponse(int i, Contents contents, boolean z) {
        this.zzFG = i;
        this.zzTO = contents;
        this.zzUP = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzap.zza(this, parcel, i);
    }

    public Contents zzkL() {
        return this.zzTO;
    }

    public boolean zzkM() {
        return this.zzUP;
    }
}
