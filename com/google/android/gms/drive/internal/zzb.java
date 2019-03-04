package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzb implements Creator<AuthorizeAccessRequest> {
    static void zza(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, authorizeAccessRequest.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, authorizeAccessRequest.zzTf);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, authorizeAccessRequest.zzRX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbx(i);
    }

    public AuthorizeAccessRequest zzaj(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AuthorizeAccessRequest[] zzbx(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
