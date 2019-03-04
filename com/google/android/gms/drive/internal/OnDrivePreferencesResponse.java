package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Creator<OnDrivePreferencesResponse> CREATOR = new zzat();
    final int zzFG;
    DrivePreferences zzUT;

    OnDrivePreferencesResponse(int i, DrivePreferences drivePreferences) {
        this.zzFG = i;
        this.zzUT = drivePreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzat.zza(this, parcel, i);
    }
}
