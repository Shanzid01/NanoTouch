package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzpj implements Creator<zzpi> {
    static void zza(zzpi com_google_android_gms_internal_zzpi, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzpi.zzanl);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzpi.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzpi.zzanm, i, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzpi.zzpz(), false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzpi.mPendingIntent, i, false);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzpi.zzpA(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfv(i);
    }

    public zzpi zzdw(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 1;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        zzpg com_google_android_gms_internal_zzpg = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    com_google_android_gms_internal_zzpg = (zzpg) zza.zza(parcel, zzI, zzpg.CREATOR);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzI, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzI);
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
            return new zzpi(i, i2, com_google_android_gms_internal_zzpg, iBinder2, pendingIntent, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpi[] zzfv(int i) {
        return new zzpi[i];
    }
}
