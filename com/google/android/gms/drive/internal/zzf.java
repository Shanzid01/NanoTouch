package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzf implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.zzFG);
        zzb.zza(parcel, 2, closeContentsAndUpdateMetadataRequest.zzTh, i, false);
        zzb.zza(parcel, 3, closeContentsAndUpdateMetadataRequest.zzTi, i, false);
        zzb.zza(parcel, 4, closeContentsAndUpdateMetadataRequest.zzTj, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzSr);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzSq, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzTk);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzam(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbA(i);
    }

    public CloseContentsAndUpdateMetadataRequest zzam(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        boolean z = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzI, Contents.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CloseContentsAndUpdateMetadataRequest(i2, driveId, metadataBundle, contents, z, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] zzbA(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
