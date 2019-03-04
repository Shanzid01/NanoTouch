package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzam;
import com.google.android.gms.internal.zzwy;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int zzFG;
    final long zzRR;
    final long zzRS;
    final long zzRT;
    private volatile String zzRU = null;

    ChangeSequenceNumber(int i, long j, long j2, long j3) {
        boolean z = true;
        zzx.zzO(j != -1);
        zzx.zzO(j2 != -1);
        if (j3 == -1) {
            z = false;
        }
        zzx.zzO(z);
        this.zzFG = i;
        this.zzRR = j;
        this.zzRS = j2;
        this.zzRT = j3;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzRU == null) {
            this.zzRU = "ChangeSequenceNumber:" + Base64.encodeToString(zzkn(), 10);
        }
        return this.zzRU;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzRS == this.zzRS && changeSequenceNumber.zzRT == this.zzRT && changeSequenceNumber.zzRR == this.zzRR;
    }

    public int hashCode() {
        return (String.valueOf(this.zzRR) + String.valueOf(this.zzRS) + String.valueOf(this.zzRT)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    final byte[] zzkn() {
        zzwy com_google_android_gms_drive_internal_zzam = new zzam();
        com_google_android_gms_drive_internal_zzam.versionCode = this.zzFG;
        com_google_android_gms_drive_internal_zzam.zzUF = this.zzRR;
        com_google_android_gms_drive_internal_zzam.zzUG = this.zzRS;
        com_google_android_gms_drive_internal_zzam.zzUH = this.zzRT;
        return zzwy.zzf(com_google_android_gms_drive_internal_zzam);
    }
}
