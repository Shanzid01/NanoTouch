package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzat implements Creator<zzas> {
    static void zza(zzas com_google_android_gms_wearable_internal_zzas, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzas.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_wearable_internal_zzas.statusCode);
        zzb.zza(parcel, 3, com_google_android_gms_wearable_internal_zzas.zzaGl, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzii(i);
    }

    public zzas zzfI(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zzp com_google_android_gms_wearable_internal_zzp = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzp = (zzp) zza.zza(parcel, zzI, zzp.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzas(i2, i, com_google_android_gms_wearable_internal_zzp);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzas[] zzii(int i) {
        return new zzas[i];
    }
}
