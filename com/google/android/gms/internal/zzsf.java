package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzsf implements Creator<zzse> {
    static void zza(zzse com_google_android_gms_internal_zzse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzse.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzse.zzatk, i, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzse.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgC(i);
    }

    public zzse zzeq(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzrw com_google_android_gms_internal_zzrw = null;
        while (parcel.dataPosition() < zzJ) {
            zzrw com_google_android_gms_internal_zzrw2;
            int zzg;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    IBinder iBinder3 = iBinder;
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = zza.zzg(parcel, zzI);
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    zzg = i;
                    zzrw com_google_android_gms_internal_zzrw3 = (zzrw) zza.zza(parcel, zzI, zzrw.CREATOR);
                    iBinder2 = iBinder;
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw3;
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzI);
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    iBinder2 = iBinder;
                    com_google_android_gms_internal_zzrw2 = com_google_android_gms_internal_zzrw;
                    zzg = i;
                    break;
            }
            i = zzg;
            com_google_android_gms_internal_zzrw = com_google_android_gms_internal_zzrw2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzse(i, com_google_android_gms_internal_zzrw, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzse[] zzgC(int i) {
        return new zzse[i];
    }
}
