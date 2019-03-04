package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbd implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.zzFG);
        zzb.zza(parcel, 2, openContentsRequest.zzTh, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzRW);
        zzb.zzc(parcel, 4, openContentsRequest.zzVb);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcj(i);
    }

    public OpenContentsRequest zzaQ(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            int zzI = zza.zzI(parcel);
            int i4;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    zzI = i4;
                    break;
                case 2:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    zzI = i;
                    i = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzI);
                    zzI = i4;
                    break;
                case 4:
                    zzI = zza.zzg(parcel, zzI);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzI = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OpenContentsRequest[] zzcj(int i) {
        return new OpenContentsRequest[i];
    }
}
