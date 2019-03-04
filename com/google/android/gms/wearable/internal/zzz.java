package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzz implements Creator<zzy> {
    static void zza(zzy com_google_android_gms_wearable_internal_zzy, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzy.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_wearable_internal_zzy.statusCode);
        zzb.zzc(parcel, 3, com_google_android_gms_wearable_internal_zzy.zzaGk, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzib(i);
    }

    public zzy zzfB(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzI, zzao.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzy(i2, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzy[] zzib(int i) {
        return new zzy[i];
    }
}
