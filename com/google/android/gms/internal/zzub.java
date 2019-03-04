package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zztw.zzb.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzub implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_internal_zztw_zzb_zzb, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        Set set = com_google_android_gms_internal_zztw_zzb_zzb.zzauX;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, com_google_android_gms_internal_zztw_zzb_zzb.zzFG);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, com_google_android_gms_internal_zztw_zzb_zzb.zzlj);
        }
        if (set.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, com_google_android_gms_internal_zztw_zzb_zzb.zzxX, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, com_google_android_gms_internal_zztw_zzb_zzb.zzli);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgS(i);
    }

    public zzb zzeF(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = zza.zzg(parcel, zzI);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzb(hashSet, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzb[] zzgS(int i) {
        return new zzb[i];
    }
}
