package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzz implements Creator<zzy> {
    static void zza(zzy com_google_android_gms_fitness_request_zzy, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzy.zzlQ(), false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_request_zzy.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzy.getPackageName(), false);
        zzb.zzc(parcel, 3, com_google_android_gms_fitness_request_zzy.zzma(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzco(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdM(i);
    }

    public zzy zzco(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzI, zzh.CREATOR);
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
            return new zzy(i, iBinder, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzy[] zzdM(int i) {
        return new zzy[i];
    }
}
