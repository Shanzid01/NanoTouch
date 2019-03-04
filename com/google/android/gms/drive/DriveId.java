package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzan;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.internal.zzwx;
import com.google.android.gms.internal.zzwy;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new zzd();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int zzFG;
    final long zzRS;
    private volatile String zzRU;
    final String zzSh;
    final long zzSi;
    final int zzSj;

    DriveId(int i, String str, long j, long j2, int i2) {
        boolean z = false;
        this.zzRU = null;
        this.zzFG = i;
        this.zzSh = str;
        zzx.zzO(!"".equals(str));
        if (!(str == null && j == -1)) {
            z = true;
        }
        zzx.zzO(z);
        this.zzSi = j;
        this.zzRS = j2;
        this.zzSj = i2;
    }

    public DriveId(String str, long j, long j2, int i) {
        this(1, str, j, j2, i);
    }

    public static DriveId decodeFromString(String str) {
        zzx.zzb(str.startsWith("DriveId:"), "Invalid DriveId: " + str);
        return zzg(Base64.decode(str.substring("DriveId:".length()), 10));
    }

    public static DriveId zzbu(String str) {
        zzx.zzl(str);
        return new DriveId(str, -1, -1, -1);
    }

    static DriveId zzg(byte[] bArr) {
        try {
            zzan zzh = zzan.zzh(bArr);
            return new DriveId(zzh.versionCode, "".equals(zzh.zzUI) ? null : zzh.zzUI, zzh.zzUJ, zzh.zzUG, zzh.zzUK);
        } catch (zzwx e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzRU == null) {
            this.zzRU = "DriveId:" + Base64.encodeToString(zzkn(), 10);
        }
        return this.zzRU;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzRS == this.zzRS) {
            return (driveId.zzSi == -1 && this.zzSi == -1) ? driveId.zzSh.equals(this.zzSh) : driveId.zzSi == this.zzSi;
        } else {
            zzw.zzr("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        }
    }

    public String getResourceId() {
        return this.zzSh;
    }

    public int getResourceType() {
        return this.zzSj;
    }

    public int hashCode() {
        return this.zzSi == -1 ? this.zzSh.hashCode() : (String.valueOf(this.zzRS) + String.valueOf(this.zzSi)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    final byte[] zzkn() {
        zzwy com_google_android_gms_drive_internal_zzan = new zzan();
        com_google_android_gms_drive_internal_zzan.versionCode = this.zzFG;
        com_google_android_gms_drive_internal_zzan.zzUI = this.zzSh == null ? "" : this.zzSh;
        com_google_android_gms_drive_internal_zzan.zzUJ = this.zzSi;
        com_google_android_gms_drive_internal_zzan.zzUG = this.zzRS;
        com_google_android_gms_drive_internal_zzan.zzUK = this.zzSj;
        return zzwy.zzf(com_google_android_gms_drive_internal_zzan);
    }
}
