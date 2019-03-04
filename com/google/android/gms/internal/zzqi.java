package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzqi implements Creator<zzqh> {
    static void zza(zzqh com_google_android_gms_internal_zzqh, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzqh.zzapb, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzqh.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzqh.zzapc, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzqh.zzapd, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzqh.zzaob, false);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzqh.zzape, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfL(i);
    }

    public zzqh zzdI(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 5:
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
            return new zzqh(i, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzqh[] zzfL(int i) {
        return new zzqh[i];
    }
}
