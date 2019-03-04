package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
    public static final Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbj();
    final int zzFG;
    final FileUploadPreferencesImpl zzUQ;

    SetFileUploadPreferencesRequest(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.zzFG = i;
        this.zzUQ = fileUploadPreferencesImpl;
    }

    public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this(1, fileUploadPreferencesImpl);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbj.zza(this, parcel, i);
    }
}
