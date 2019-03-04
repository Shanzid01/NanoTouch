package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Creator<zzaa> {
    static void zza(zzaa com_google_android_gms_common_internal_zzaa, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_common_internal_zzaa.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_common_internal_zzaa.zzPn, false);
        zzb.zza(parcel, 3, com_google_android_gms_common_internal_zzaa.zzjo(), i, false);
        zzb.zza(parcel, 4, com_google_android_gms_common_internal_zzaa.zzjp());
        zzb.zza(parcel, 5, com_google_android_gms_common_internal_zzaa.zzjq());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaN(i);
    }

    public zzaa zzG(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) zza.zza(parcel, zzI, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzaa(i, iBinder, connectionResult, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzaa[] zzaN(int i) {
        return new zzaa[i];
    }
}
