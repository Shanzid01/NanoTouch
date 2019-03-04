package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzgr implements Creator<zzgq> {
    static void zza(zzgq com_google_android_gms_internal_zzgq, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzgq.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzgq.zzus, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzgq.zzwG, false);
        zzb.zzb(parcel, 4, com_google_android_gms_internal_zzgq.zzst, false);
        zzb.zzc(parcel, 5, com_google_android_gms_internal_zzgq.errorCode);
        zzb.zzb(parcel, 6, com_google_android_gms_internal_zzgq.zzsu, false);
        zzb.zza(parcel, 7, com_google_android_gms_internal_zzgq.zzwH);
        zzb.zza(parcel, 8, com_google_android_gms_internal_zzgq.zzwI);
        zzb.zza(parcel, 9, com_google_android_gms_internal_zzgq.zzwJ);
        zzb.zzb(parcel, 10, com_google_android_gms_internal_zzgq.zzwK, false);
        zzb.zza(parcel, 11, com_google_android_gms_internal_zzgq.zzsx);
        zzb.zzc(parcel, 12, com_google_android_gms_internal_zzgq.orientation);
        zzb.zza(parcel, 13, com_google_android_gms_internal_zzgq.zzwL, false);
        zzb.zza(parcel, 14, com_google_android_gms_internal_zzgq.zzwM);
        zzb.zza(parcel, 15, com_google_android_gms_internal_zzgq.zzwN, false);
        zzb.zza(parcel, 19, com_google_android_gms_internal_zzgq.zzwP, false);
        zzb.zza(parcel, 18, com_google_android_gms_internal_zzgq.zzwO);
        zzb.zza(parcel, 21, com_google_android_gms_internal_zzgq.zzwQ, false);
        zzb.zza(parcel, 23, com_google_android_gms_internal_zzgq.zzwS);
        zzb.zza(parcel, 22, com_google_android_gms_internal_zzgq.zzwR);
        zzb.zza(parcel, 25, com_google_android_gms_internal_zzgq.zzwT);
        zzb.zza(parcel, 24, com_google_android_gms_internal_zzgq.zzwv);
        zzb.zza(parcel, 26, com_google_android_gms_internal_zzgq.zzwU);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzw(i);
    }

    public zzgq zzi(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    list = zza.zzC(parcel, zzI);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    list2 = zza.zzC(parcel, zzI);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 9:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 10:
                    list3 = zza.zzC(parcel, zzI);
                    break;
                case 11:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 13:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 14:
                    j4 = zza.zzi(parcel, zzI);
                    break;
                case 15:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 19:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 21:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 22:
                    z3 = zza.zzc(parcel, zzI);
                    break;
                case 23:
                    z4 = zza.zzc(parcel, zzI);
                    break;
                case 24:
                    z5 = zza.zzc(parcel, zzI);
                    break;
                case 25:
                    z6 = zza.zzc(parcel, zzI);
                    break;
                case 26:
                    z7 = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzgq(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzgq[] zzw(int i) {
        return new zzgq[i];
    }
}
