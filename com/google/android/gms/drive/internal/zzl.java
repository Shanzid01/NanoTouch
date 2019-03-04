package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzl implements Creator<CreateFolderRequest> {
    static void zza(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, createFolderRequest.zzFG);
        zzb.zza(parcel, 2, createFolderRequest.zzTr, i, false);
        zzb.zza(parcel, 3, createFolderRequest.zzTp, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzar(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbG(i);
    }

    public CreateFolderRequest zzar(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            MetadataBundle metadataBundle2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CreateFolderRequest[] zzbG(int i) {
        return new CreateFolderRequest[i];
    }
}
