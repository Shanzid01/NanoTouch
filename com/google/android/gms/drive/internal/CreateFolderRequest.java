package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR = new zzl();
    final int zzFG;
    final MetadataBundle zzTp;
    final DriveId zzTr;

    CreateFolderRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.zzFG = i;
        this.zzTr = (DriveId) zzx.zzl(driveId);
        this.zzTp = (MetadataBundle) zzx.zzl(metadataBundle);
    }

    public CreateFolderRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
