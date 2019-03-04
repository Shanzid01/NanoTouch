package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR = new zzac();
    final int zzFG;
    int zzUs;
    int zzUt;
    boolean zzUu;

    FileUploadPreferencesImpl(int i, int i2, int i3, boolean z) {
        this.zzFG = i;
        this.zzUs = i2;
        this.zzUt = i3;
        this.zzUu = z;
    }

    public static boolean zzbM(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzbN(int i) {
        switch (i) {
            case 256:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        return !zzbN(this.zzUt) ? 0 : this.zzUt;
    }

    public int getNetworkTypePreference() {
        return !zzbM(this.zzUs) ? 0 : this.zzUs;
    }

    public boolean isRoamingAllowed() {
        return this.zzUu;
    }

    public void setBatteryUsagePreference(int i) {
        if (zzbN(i)) {
            this.zzUt = i;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int i) {
        if (zzbM(i)) {
            this.zzUs = i;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean z) {
        this.zzUu = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.zza(this, parcel, i);
    }
}
