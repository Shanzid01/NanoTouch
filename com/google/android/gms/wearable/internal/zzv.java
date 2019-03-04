package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.zze;

public class zzv implements Creator<zzu> {
    static void zza(zzu com_google_android_gms_wearable_internal_zzu, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzu.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_wearable_internal_zzu.statusCode);
        zzb.zza(parcel, 3, com_google_android_gms_wearable_internal_zzu.zzaGi, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhZ(i);
    }

    public zzu zzfz(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zze com_google_android_gms_wearable_zze = null;
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
                    com_google_android_gms_wearable_zze = (zze) zza.zza(parcel, zzI, zze.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzu(i2, i, com_google_android_gms_wearable_zze);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzu[] zzhZ(int i) {
        return new zzu[i];
    }
}
