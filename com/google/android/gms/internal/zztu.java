package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zztu implements Creator<zztt> {
    static void zza(zztt com_google_android_gms_internal_zztt, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = com_google_android_gms_internal_zztt.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, com_google_android_gms_internal_zztt.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, com_google_android_gms_internal_zztt.zzFA, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, com_google_android_gms_internal_zztt.zzavS, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, com_google_android_gms_internal_zztt.zzavK, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, com_google_android_gms_internal_zztt.zzavT, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, com_google_android_gms_internal_zztt.zzxV, true);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgN(i);
    }

    public zztt zzeA(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        zztr com_google_android_gms_internal_zztr = null;
        String str2 = null;
        zztr com_google_android_gms_internal_zztr2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            zztr com_google_android_gms_internal_zztr3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    com_google_android_gms_internal_zztr3 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    com_google_android_gms_internal_zztr2 = com_google_android_gms_internal_zztr3;
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    com_google_android_gms_internal_zztr3 = (zztr) zza.zza(parcel, zzI, zztr.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    com_google_android_gms_internal_zztr = com_google_android_gms_internal_zztr3;
                    break;
                case 7:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zztt(hashSet, i, str3, com_google_android_gms_internal_zztr2, str2, com_google_android_gms_internal_zztr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zztt[] zzgN(int i) {
        return new zztt[i];
    }
}
