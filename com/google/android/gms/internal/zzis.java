package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzis implements Creator<zzir> {
    static void zza(zzir com_google_android_gms_internal_zzir, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzir.zzFT, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzir.zzFG);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzir.zzFU, i, false);
        zzb.zzc(parcel, 4, com_google_android_gms_internal_zzir.zzFV);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzir.zzFW, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzR(i);
    }

    public zzir[] zzR(int i) {
        return new zzir[i];
    }

    public zzir zzn(Parcel parcel) {
        byte[] bArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = -1;
        zziz com_google_android_gms_internal_zziz = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    com_google_android_gms_internal_zziz = (zziz) zza.zza(parcel, zzI, zziz.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzI);
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
            return new zzir(i, str, com_google_android_gms_internal_zziz, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
