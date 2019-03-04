package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzsd implements Creator<zzsc> {
    static void zza(zzsc com_google_android_gms_internal_zzsc, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzsc.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzsc.zzrr(), false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzsc.zzatl, i, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzsc.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzep(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgB(i);
    }

    public zzsc zzep(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzrr com_google_android_gms_internal_zzrr = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzJ) {
            zzrr com_google_android_gms_internal_zzrr2;
            IBinder iBinder3;
            int zzg;
            IBinder iBinder4;
            int zzI = zza.zzI(parcel);
            IBinder iBinder5;
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder5 = iBinder;
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr;
                    iBinder3 = iBinder2;
                    zzg = zza.zzg(parcel, zzI);
                    iBinder4 = iBinder5;
                    break;
                case 2:
                    zzg = i;
                    zzrr com_google_android_gms_internal_zzrr3 = com_google_android_gms_internal_zzrr;
                    iBinder3 = zza.zzp(parcel, zzI);
                    iBinder4 = iBinder;
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr3;
                    break;
                case 3:
                    iBinder3 = iBinder2;
                    zzg = i;
                    iBinder5 = iBinder;
                    com_google_android_gms_internal_zzrr2 = (zzrr) zza.zza(parcel, zzI, zzrr.CREATOR);
                    iBinder4 = iBinder5;
                    break;
                case 4:
                    iBinder4 = zza.zzp(parcel, zzI);
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr;
                    iBinder3 = iBinder2;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    iBinder4 = iBinder;
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr;
                    iBinder3 = iBinder2;
                    zzg = i;
                    break;
            }
            i = zzg;
            iBinder2 = iBinder3;
            com_google_android_gms_internal_zzrr = com_google_android_gms_internal_zzrr2;
            iBinder = iBinder4;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzsc(i, iBinder2, com_google_android_gms_internal_zzrr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzsc[] zzgB(int i) {
        return new zzsc[i];
    }
}
