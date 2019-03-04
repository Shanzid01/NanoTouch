package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zztw.zzc;
import com.google.android.gms.internal.zztw.zzd;
import com.google.android.gms.internal.zztw.zzf;
import com.google.android.gms.internal.zztw.zzg;
import com.google.android.gms.internal.zztw.zzh;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zztx implements Creator<zztw> {
    static void zza(zztw com_google_android_gms_internal_zztw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = com_google_android_gms_internal_zztw.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, com_google_android_gms_internal_zztw.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, com_google_android_gms_internal_zztw.zzavV, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, com_google_android_gms_internal_zztw.zzavW, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, com_google_android_gms_internal_zztw.zzavX, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, com_google_android_gms_internal_zztw.zzavY, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, com_google_android_gms_internal_zztw.zzavZ);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, com_google_android_gms_internal_zztw.zzawa, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, com_google_android_gms_internal_zztw.zzawb, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, com_google_android_gms_internal_zztw.zzSJ, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, com_google_android_gms_internal_zztw.zzpo);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, com_google_android_gms_internal_zztw.zzFA, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, com_google_android_gms_internal_zztw.zzawc, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, com_google_android_gms_internal_zztw.zzawd);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zza(parcel, 19, com_google_android_gms_internal_zztw.zzawe, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, com_google_android_gms_internal_zztw.zzIO, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zzc(parcel, 21, com_google_android_gms_internal_zztw.zzawg);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, com_google_android_gms_internal_zztw.zzawf, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zzc(parcel, 23, com_google_android_gms_internal_zztw.zzawi, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zzc(parcel, 22, com_google_android_gms_internal_zztw.zzawh, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zzc(parcel, 25, com_google_android_gms_internal_zztw.zzawk);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zzc(parcel, 24, com_google_android_gms_internal_zztw.zzawj);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, com_google_android_gms_internal_zztw.zzxX, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zza(parcel, 26, com_google_android_gms_internal_zztw.zzawl, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zza(parcel, 29, com_google_android_gms_internal_zztw.zzawn);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zzc(parcel, 28, com_google_android_gms_internal_zztw.zzawm, true);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgO(i);
    }

    public zztw zzeB(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        zztw.zza com_google_android_gms_internal_zztw_zza = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        zztw.zzb com_google_android_gms_internal_zztw_zzb = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        zzc com_google_android_gms_internal_zztw_zzc = null;
        boolean z = false;
        String str7 = null;
        zzd com_google_android_gms_internal_zztw_zzd = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    zztw.zza com_google_android_gms_internal_zztw_zza2 = (zztw.zza) zza.zza(parcel, zzI, zztw.zza.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    com_google_android_gms_internal_zztw_zza = com_google_android_gms_internal_zztw_zza2;
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    zztw.zzb com_google_android_gms_internal_zztw_zzb2 = (zztw.zzb) zza.zza(parcel, zzI, zztw.zzb.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    com_google_android_gms_internal_zztw_zzb = com_google_android_gms_internal_zztw_zzb2;
                    break;
                case 8:
                    str4 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    zzc com_google_android_gms_internal_zztw_zzc2 = (zzc) zza.zza(parcel, zzI, zzc.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    com_google_android_gms_internal_zztw_zzc = com_google_android_gms_internal_zztw_zzc2;
                    break;
                case 16:
                    z = zza.zzc(parcel, zzI);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    zzd com_google_android_gms_internal_zztw_zzd2 = (zzd) zza.zza(parcel, zzI, (Creator) zzd.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    com_google_android_gms_internal_zztw_zzd = com_google_android_gms_internal_zztw_zzd2;
                    break;
                case 20:
                    str8 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = zza.zzc(parcel, zzI, zzf.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = zza.zzc(parcel, zzI, zzg.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = zza.zzc(parcel, zzI, zzh.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = zza.zzc(parcel, zzI);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zztw(hashSet, i, str, com_google_android_gms_internal_zztw_zza, str2, str3, i2, com_google_android_gms_internal_zztw_zzb, str4, str5, i3, str6, com_google_android_gms_internal_zztw_zzc, z, str7, com_google_android_gms_internal_zztw_zzd, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zztw[] zzgO(int i) {
        return new zztw[i];
    }
}
