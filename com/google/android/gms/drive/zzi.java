package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<StorageStats> {
    static void zza(StorageStats storageStats, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, storageStats.zzFG);
        zzb.zza(parcel, 2, storageStats.zzSD);
        zzb.zza(parcel, 3, storageStats.zzSE);
        zzb.zza(parcel, 4, storageStats.zzSF);
        zzb.zza(parcel, 5, storageStats.zzSG);
        zzb.zzc(parcel, 6, storageStats.zzSH);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzab(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbo(i);
    }

    public StorageStats zzab(Parcel parcel) {
        int i = 0;
        long j = 0;
        int zzJ = zza.zzJ(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    j4 = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public StorageStats[] zzbo(int i) {
        return new StorageStats[i];
    }
}
