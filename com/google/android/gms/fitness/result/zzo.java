package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<zzn> {
    static void zza(zzn com_google_android_gms_fitness_result_zzn, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_result_zzn.getStatus(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_result_zzn.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_result_zzn.zzmu());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzem(i);
    }

    public zzn zzcN(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Status status = null;
        long j = 0;
        while (parcel.dataPosition() < zzJ) {
            Status status2;
            int i2;
            long j2;
            int zzI = zza.zzI(parcel);
            long j3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    j3 = j;
                    status2 = (Status) zza.zza(parcel, zzI, Status.CREATOR);
                    i2 = i;
                    j2 = j3;
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzI);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    j3 = j;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzI);
                    j2 = j3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    j2 = j;
                    status2 = status;
                    i2 = i;
                    break;
            }
            status = status2;
            i = i2;
            j = j2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzn(i, status, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzn[] zzem(int i) {
        return new zzn[i];
    }
}
