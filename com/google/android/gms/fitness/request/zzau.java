package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;

public class zzau implements Creator<zzat> {
    static void zza(zzat com_google_android_gms_fitness_request_zzat, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzat.zzml(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_request_zzat.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzat.zzmm());
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzat.zzlQ(), false);
        zzb.zza(parcel, 4, com_google_android_gms_fitness_request_zzat.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdZ(i);
    }

    public zzat zzcA(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        IBinder iBinder = null;
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    subscription = (Subscription) zza.zza(parcel, zzI, Subscription.CREATOR);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
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
            return new zzat(i, subscription, z, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzat[] zzdZ(int i) {
        return new zzat[i];
    }
}
