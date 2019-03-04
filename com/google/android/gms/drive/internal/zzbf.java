package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbf implements Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.zzFG);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzSy, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzSz, false);
        zzb.zza(parcel, 4, openFileIntentSenderRequest.zzSA, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzck(i);
    }

    public OpenFileIntentSenderRequest zzaR(Parcel parcel) {
        DriveId driveId = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    strArr = zza.zzA(parcel, zzI);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OpenFileIntentSenderRequest[] zzck(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
