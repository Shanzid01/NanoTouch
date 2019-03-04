package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new zzk();
    final int zzFG;
    final String zzSq;
    final Contents zzTj;
    final MetadataBundle zzTp;
    final Integer zzTq;
    final DriveId zzTr;
    final boolean zzTs;
    final int zzTt;
    final int zzTu;

    CreateFileRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, Integer num, boolean z, String str, int i2, int i3) {
        if (!(contents == null || i3 == 0)) {
            zzx.zzb(contents.getRequestId() == i3, (Object) "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzFG = i;
        this.zzTr = (DriveId) zzx.zzl(driveId);
        this.zzTp = (MetadataBundle) zzx.zzl(metadataBundle);
        this.zzTj = contents;
        this.zzTq = num;
        this.zzSq = str;
        this.zzTt = i2;
        this.zzTs = z;
        this.zzTu = i3;
    }

    public CreateFileRequest(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, ExecutionOptions executionOptions) {
        this(2, driveId, metadataBundle, null, Integer.valueOf(i2), executionOptions.zzku(), executionOptions.zzkt(), executionOptions.zzkv(), i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
