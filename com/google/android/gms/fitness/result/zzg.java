package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzg implements Creator<zzf> {
    static void zza(zzf com_google_android_gms_fitness_result_zzf, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_result_zzf.getStatus(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_result_zzf.getVersionCode());
        zzb.zzc(parcel, 2, com_google_android_gms_fitness_result_zzf.zzmr(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeg(i);
    }

    public zzf zzcH(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzI = zza.zzI(parcel);
            List list2;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzI, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzI, zzc.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzI);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzf(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzf[] zzeg(int i) {
        return new zzf[i];
    }
}
