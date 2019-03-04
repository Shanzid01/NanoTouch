package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.StorageStats;

public class zzbb implements Creator<OnStorageStatsResponse> {
    static void zza(OnStorageStatsResponse onStorageStatsResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onStorageStatsResponse.zzFG);
        zzb.zza(parcel, 2, onStorageStatsResponse.zzVa, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzch(i);
    }

    public OnStorageStatsResponse zzaO(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        StorageStats storageStats = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    storageStats = (StorageStats) zza.zza(parcel, zzI, StorageStats.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnStorageStatsResponse(i, storageStats);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnStorageStatsResponse[] zzch(int i) {
        return new OnStorageStatsResponse[i];
    }
}
