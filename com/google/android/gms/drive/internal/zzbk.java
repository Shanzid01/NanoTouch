package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzbk implements Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.zzFG);
        zzb.zza(parcel, 2, setResourceParentsRequest.zzVe, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzVf, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcp(i);
    }

    public SetResourceParentsRequest zzaW(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            ArrayList zzc;
            int zzI = zza.zzI(parcel);
            List list2;
            switch (zza.zzaP(zzI)) {
                case 1:
                    List list3 = list;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    list2 = list3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzI, DriveId.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzc = list;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzJ) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SetResourceParentsRequest[] zzcp(int i) {
        return new SetResourceParentsRequest[i];
    }
}
