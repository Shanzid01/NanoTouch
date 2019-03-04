package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.zze;

public class zzx implements Creator<zzw> {
    static void zza(zzw com_google_android_gms_wearable_internal_zzw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzw.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_wearable_internal_zzw.statusCode);
        zzb.zza(parcel, 3, com_google_android_gms_wearable_internal_zzw.zzaGj, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzia(i);
    }

    public zzw zzfA(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        zze[] com_google_android_gms_wearable_zzeArr = null;
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
                    com_google_android_gms_wearable_zzeArr = (zze[]) zza.zzb(parcel, zzI, zze.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzw(i2, i, com_google_android_gms_wearable_zzeArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzw[] zzia(int i) {
        return new zzw[i];
    }
}
