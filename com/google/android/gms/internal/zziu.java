package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zziu implements Creator<zzit> {
    static void zza(zzit com_google_android_gms_internal_zzit, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzit.id);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzit.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzit.zzFX, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzS(i);
    }

    public zzit[] zzS(int i) {
        return new zzit[i];
    }

    public zzit zzo(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzit(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
