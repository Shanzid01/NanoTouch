package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.QueryEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new zzau();
    final int zzFG;
    final int zzTe;
    final ChangeEvent zzUU;
    final CompletionEvent zzUV;
    final QueryEvent zzUW;

    OnEventResponse(int i, int i2, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryEvent queryEvent) {
        this.zzFG = i;
        this.zzTe = i2;
        this.zzUU = changeEvent;
        this.zzUV = completionEvent;
        this.zzUW = queryEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzau.zza(this, parcel, i);
    }

    public DriveEvent zzkQ() {
        switch (this.zzTe) {
            case 1:
                return this.zzUU;
            case 2:
                return this.zzUV;
            case 3:
                return this.zzUW;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzTe);
        }
    }
}
