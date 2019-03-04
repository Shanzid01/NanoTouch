package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzqe implements Creator<zzqd> {
    static void zza(zzqd com_google_android_gms_internal_zzqd, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzqd.name, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzqd.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzqd.zzaoQ, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzqd.zzaoR, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzqd.zzaoS, false);
        zzb.zzb(parcel, 5, com_google_android_gms_internal_zzqd.zzaoT, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfK(i);
    }

    public zzqd zzdH(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    list = zza.zzC(parcel, zzI);
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
            return new zzqd(i, str4, str3, str2, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzqd[] zzfK(int i) {
        return new zzqd[i];
    }
}
