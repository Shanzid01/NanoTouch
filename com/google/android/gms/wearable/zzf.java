package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<zze> {
    static void zza(zze com_google_android_gms_wearable_zze, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_zze.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_wearable_zze.getName(), false);
        zzb.zza(parcel, 3, com_google_android_gms_wearable_zze.getAddress(), false);
        zzb.zzc(parcel, 4, com_google_android_gms_wearable_zze.getType());
        zzb.zzc(parcel, 5, com_google_android_gms_wearable_zze.getRole());
        zzb.zza(parcel, 6, com_google_android_gms_wearable_zze.isEnabled());
        zzb.zza(parcel, 7, com_google_android_gms_wearable_zze.isConnected());
        zzb.zza(parcel, 8, com_google_android_gms_wearable_zze.zzuX(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhS(i);
    }

    public zze zzfs(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zze(i3, str3, str2, i2, i, z2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zze[] zzhS(int i) {
        return new zze[i];
    }
}
