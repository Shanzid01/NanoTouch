package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzrs implements Creator<zzrr> {
    static void zza(zzrr com_google_android_gms_internal_zzrr, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzrr.zzatf);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzrr.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_internal_zzrr.zzatg);
        zzb.zzc(parcel, 3, com_google_android_gms_internal_zzrr.zzath);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzem(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgy(i);
    }

    public zzrr zzem(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzrr(i4, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzrr[] zzgy(int i) {
        return new zzrr[i];
    }
}
