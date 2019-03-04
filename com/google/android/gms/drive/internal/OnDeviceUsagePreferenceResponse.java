package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzaq();
    final int zzFG;
    final FileUploadPreferencesImpl zzUQ;

    OnDeviceUsagePreferenceResponse(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.zzFG = i;
        this.zzUQ = fileUploadPreferencesImpl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }

    public FileUploadPreferencesImpl zzkN() {
        return this.zzUQ;
    }
}
