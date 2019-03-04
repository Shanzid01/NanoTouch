package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbh implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.zzFG);
        zzb.zza(parcel, 2, removeEventListenerRequest.zzRX, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzTe);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcm(i);
    }

    public RemoveEventListenerRequest zzaT(Parcel parcel) {
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
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public RemoveEventListenerRequest[] zzcm(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
