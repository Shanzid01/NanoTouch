package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new zzbf();
    final int zzFG;
    final DriveId zzSA;
    final String zzSy;
    final String[] zzSz;

    OpenFileIntentSenderRequest(int i, String str, String[] strArr, DriveId driveId) {
        this.zzFG = i;
        this.zzSy = str;
        this.zzSz = strArr;
        this.zzSA = driveId;
    }

    public OpenFileIntentSenderRequest(String str, String[] strArr, DriveId driveId) {
        this(1, str, strArr, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbf.zza(this, parcel, i);
    }
}
