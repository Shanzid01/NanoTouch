package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<zze> {
    static void zza(zze com_google_android_gms_wearable_internal_zze, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zze.zzFG);
        zzb.zzc(parcel, 2, com_google_android_gms_wearable_internal_zze.getId());
        zzb.zza(parcel, 3, com_google_android_gms_wearable_internal_zze.zznE(), false);
        zzb.zza(parcel, 4, com_google_android_gms_wearable_internal_zze.zzvb(), false);
        zzb.zza(parcel, 5, com_google_android_gms_wearable_internal_zze.zzvc(), false);
        zzb.zza(parcel, 6, com_google_android_gms_wearable_internal_zze.getTitle(), false);
        zzb.zza(parcel, 7, com_google_android_gms_wearable_internal_zze.zzmV(), false);
        zzb.zza(parcel, 8, com_google_android_gms_wearable_internal_zze.getDisplayName(), false);
        zzb.zza(parcel, 9, com_google_android_gms_wearable_internal_zze.zzvd());
        zzb.zza(parcel, 10, com_google_android_gms_wearable_internal_zze.zzve());
        zzb.zza(parcel, 11, com_google_android_gms_wearable_internal_zze.zzvf());
        zzb.zza(parcel, 12, com_google_android_gms_wearable_internal_zze.zzvg());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhV(i);
    }

    public zze zzfv(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 9:
                    b = zza.zze(parcel, zzI);
                    break;
                case 10:
                    b2 = zza.zze(parcel, zzI);
                    break;
                case 11:
                    b3 = zza.zze(parcel, zzI);
                    break;
                case 12:
                    b4 = zza.zze(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zze(i, i2, str, str2, str3, str4, str5, str6, b, b2, b3, b4);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zze[] zzhV(int i) {
        return new zze[i];
    }
}
