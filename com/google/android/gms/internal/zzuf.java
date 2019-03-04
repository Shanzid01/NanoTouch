package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zztw.zzg;
import java.util.HashSet;
import java.util.Set;

public class zzuf implements Creator<zzg> {
    static void zza(zzg com_google_android_gms_internal_zztw_zzg, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        Set set = com_google_android_gms_internal_zztw_zzg.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, com_google_android_gms_internal_zztw_zzg.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, com_google_android_gms_internal_zztw_zzg.zzawB);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, com_google_android_gms_internal_zztw_zzg.mValue, true);
        }
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgW(i);
    }

    public zzg zzeJ(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = zza.zzc(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzg(hashSet, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzg[] zzgW(int i) {
        return new zzg[i];
    }
}
