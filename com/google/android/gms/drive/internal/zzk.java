package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzk implements Creator<CreateFileRequest> {
    static void zza(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, createFileRequest.zzFG);
        zzb.zza(parcel, 2, createFileRequest.zzTr, i, false);
        zzb.zza(parcel, 3, createFileRequest.zzTp, i, false);
        zzb.zza(parcel, 4, createFileRequest.zzTj, i, false);
        zzb.zza(parcel, 5, createFileRequest.zzTq, false);
        zzb.zza(parcel, 6, createFileRequest.zzTs);
        zzb.zza(parcel, 7, createFileRequest.zzSq, false);
        zzb.zzc(parcel, 8, createFileRequest.zzTt);
        zzb.zzc(parcel, 9, createFileRequest.zzTu);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbF(i);
    }

    public CreateFileRequest zzaq(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
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
                    num = zza.zzh(parcel, zzI);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CreateFileRequest[] zzbF(int i) {
        return new CreateFileRequest[i];
    }
}
