package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<zzac> {
    static void zza(zzac com_google_android_gms_wearable_internal_zzac, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzac.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_wearable_internal_zzac.statusCode);
        zzb.zza(parcel, 3, com_google_android_gms_wearable_internal_zzac.zzaGm, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfD(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzid(i);
    }

    public zzac zzfD(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzac(i2, i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzac[] zzid(int i) {
        return new zzac[i];
    }
}
