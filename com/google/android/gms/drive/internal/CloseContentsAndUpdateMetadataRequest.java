package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzf();
    final int zzFG;
    final String zzSq;
    final boolean zzSr;
    final DriveId zzTh;
    final MetadataBundle zzTi;
    final Contents zzTj;
    final int zzTk;

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, boolean z, String str, int i2) {
        this.zzFG = i;
        this.zzTh = driveId;
        this.zzTi = metadataBundle;
        this.zzTj = contents;
        this.zzSr = z;
        this.zzSq = str;
        this.zzTk = i2;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle, Contents contents, ExecutionOptions executionOptions) {
        this(1, driveId, metadataBundle, contents, executionOptions.zzku(), executionOptions.zzkt(), executionOptions.zzkv());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
