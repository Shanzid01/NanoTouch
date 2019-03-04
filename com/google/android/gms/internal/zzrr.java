package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzrr implements SafeParcelable {
    public static final zzrs CREATOR = new zzrs();
    final int versionCode;
    final int zzatf;
    final int zzatg;
    final int zzath;

    public class zza {
        private int zzatf = 1;
        private int zzatg = 300;
        private int zzath = 0;

        public zzrr zzrp() {
            return new zzrr(1, this.zzatf, this.zzatg, this.zzath);
        }
    }

    zzrr(int i, int i2, int i3, int i4) {
        this.versionCode = i;
        this.zzatf = i2;
        this.zzatg = i3;
        this.zzath = i4;
    }

    public int describeContents() {
        zzrs com_google_android_gms_internal_zzrs = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzrs com_google_android_gms_internal_zzrs = CREATOR;
        zzrs.zza(this, parcel, i);
    }
}
