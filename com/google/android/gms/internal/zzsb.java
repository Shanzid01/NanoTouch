package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzsb implements Creator<zzsa> {
    static void zza(zzsa com_google_android_gms_internal_zzsa, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzsa.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzsa.zzatk, i, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzsa.zzatl, i, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzsa.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgA(i);
    }

    public zzsa zzeo(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzrr com_google_android_gms_internal_zzrr = null;
        zzrw com_google_android_gms_internal_zzrw = null;
        while (parcel.dataPosition() < zzJ) {
            zzrr com_google_android_gms_internal_zzrr2;
            zzrw com_google_android_gms_internal_zzrw2;
            int zzg;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            IBinder iBinder3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    iBinder3 = iBinder;
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr;
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = zza.zzg(parcel, zzI);
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    zzg = i;
                    zzrr com_google_android_gms_internal_zzrr3 = com_google_android_gms_internal_zzrr;
                    com_google_android_gms_internal_zzrw2 = (zzrw) zza.zza(parcel, zzI, zzrw.CREATOR);
                    iBinder2 = iBinder;
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr3;
                    break;
                case 3:
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = i;
                    iBinder3 = iBinder;
                    com_google_android_gms_internal_zzrr2 = (zzrr) zza.zza(parcel, zzI, zzrr.CREATOR);
                    iBinder2 = iBinder3;
                    break;
                case 4:
                    iBinder2 = zza.zzp(parcel, zzI);
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr;
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    iBinder2 = iBinder;
                    com_google_android_gms_internal_zzrr2 = com_google_android_gms_internal_zzrr;
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = i;
                    break;
            }
            i = zzg;
            com_google_android_gms_internal_zzrw = com_google_android_gms_internal_zzrw2;
            com_google_android_gms_internal_zzrr = com_google_android_gms_internal_zzrr2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzsa(i, com_google_android_gms_internal_zzrw, com_google_android_gms_internal_zzrr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzsa[] zzgA(int i) {
        return new zzsa[i];
    }
}
