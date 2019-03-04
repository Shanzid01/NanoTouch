package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzd implements Creator<zzc> {
    static void zza(zzc com_google_android_gms_fitness_result_zzc, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_result_zzc.zzYp, i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_result_zzc.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_fitness_result_zzc.zzHf);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_result_zzc.zzabP);
        zzb.zza(parcel, 4, com_google_android_gms_fitness_result_zzc.zzabQ);
        zzb.zza(parcel, 5, com_google_android_gms_fitness_result_zzc.zzabR);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzee(i);
    }

    public zzc zzcF(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzJ = zza.zzJ(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzI, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzc(i, dataSource, j3, z, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzc[] zzee(int i) {
        return new zzc[i];
    }
}
