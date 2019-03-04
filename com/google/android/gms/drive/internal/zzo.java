package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, disconnectRequest.zzFG);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzat(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbI(i);
    }

    public DisconnectRequest zzat(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new DisconnectRequest(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DisconnectRequest[] zzbI(int i) {
        return new DisconnectRequest[i];
    }
}
