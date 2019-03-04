package com.google.android.gms.drive.execution.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzb implements Creator<GetContentTransferInfoRequest> {
    static void zza(GetContentTransferInfoRequest getContentTransferInfoRequest, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getContentTransferInfoRequest.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getContentTransferInfoRequest.zzRX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, getContentTransferInfoRequest.zzJp);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzah(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbv(i);
    }

    public GetContentTransferInfoRequest zzah(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    zzI = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    zzI = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzI = zza.zzg(parcel, zzI);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzI = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new GetContentTransferInfoRequest(i2, driveId, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GetContentTransferInfoRequest[] zzbv(int i) {
        return new GetContentTransferInfoRequest[i];
    }
}
