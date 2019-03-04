package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzar implements Creator<zzaq> {
    static void zza(zzaq com_google_android_gms_wearable_internal_zzaq, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzaq.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_wearable_internal_zzaq.packageName, false);
        zzb.zza(parcel, 3, com_google_android_gms_wearable_internal_zzaq.label, false);
        zzb.zza(parcel, 4, com_google_android_gms_wearable_internal_zzaq.zzaGC);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzih(i);
    }

    public zzaq zzfH(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzaq(i, str2, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzaq[] zzih(int i) {
        return new zzaq[i];
    }
}
