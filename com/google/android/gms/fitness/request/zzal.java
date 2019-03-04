package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzal implements Creator<zzak> {
    static void zza(zzak com_google_android_gms_fitness_request_zzak, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzak.getSession(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_request_zzak.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzak.zzlQ(), false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzak.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdU(i);
    }

    public zzak zzcv(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        Session session = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            Session session2;
            String str2;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            String str3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    session2 = (Session) zza.zza(parcel, zzI, Session.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    session2 = session;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzI);
                    str2 = str3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzI);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    str2 = str;
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzak(i, session, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzak[] zzdU(int i) {
        return new zzak[i];
    }
}
