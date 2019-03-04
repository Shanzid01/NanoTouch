package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zziq implements Creator<zzip> {
    static void zza(zzip com_google_android_gms_internal_zzip, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzip.zzFO, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzip.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzip.zzFP, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzip.zzFQ, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzQ(i);
    }

    public zzip[] zzQ(int i) {
        return new zzip[i];
    }

    public zzip zzm(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzip(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
