package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zztw.zzf;
import java.util.HashSet;
import java.util.Set;

public class zzue implements Creator<zzf> {
    static void zza(zzf com_google_android_gms_internal_zztw_zzf, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = com_google_android_gms_internal_zztw_zzf.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, com_google_android_gms_internal_zztw_zzf.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, com_google_android_gms_internal_zztw_zzf.zzawz, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, com_google_android_gms_internal_zztw_zzf.zzZO, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, com_google_android_gms_internal_zztw_zzf.zzavu, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, com_google_android_gms_internal_zztw_zzf.zzawA, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, com_google_android_gms_internal_zztw_zzf.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, com_google_android_gms_internal_zztw_zzf.zzawB);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, com_google_android_gms_internal_zztw_zzf.zzavK, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, com_google_android_gms_internal_zztw_zzf.zzSy, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, com_google_android_gms_internal_zztw_zzf.zzJp);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgV(i);
    }

    public zzf zzeI(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = zza.zzc(parcel, zzI);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzf(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzf[] zzgV(int i) {
        return new zzf[i];
    }
}
