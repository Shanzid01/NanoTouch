package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, session.zzlp());
        zzb.zzc(parcel, 1000, session.getVersionCode());
        zzb.zza(parcel, 2, session.zzlq());
        zzb.zza(parcel, 3, session.getName(), false);
        zzb.zza(parcel, 4, session.getIdentifier(), false);
        zzb.zza(parcel, 5, session.getDescription(), false);
        zzb.zzc(parcel, 7, session.zzln());
        zzb.zza(parcel, 8, session.zzlz(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdt(i);
    }

    public Session zzbV(Parcel parcel) {
        long j = 0;
        int i = 0;
        zza com_google_android_gms_fitness_data_zza = null;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 8:
                    com_google_android_gms_fitness_data_zza = (zza) zza.zza(parcel, zzI, zza.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new Session(i2, j2, j, str3, str2, str, i, com_google_android_gms_fitness_data_zza);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public Session[] zzdt(int i) {
        return new Session[i];
    }
}
