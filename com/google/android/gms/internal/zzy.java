package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<zzx> {
    static void zza(zzx com_google_android_gms_internal_zzx, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzx.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzx.zzml);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzx.zzmy);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzb(i);
    }

    public zzx zza(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzx(i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzx[] zzb(int i) {
        return new zzx[i];
    }
}
