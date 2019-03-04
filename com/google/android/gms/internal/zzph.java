package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzph implements Creator<zzpg> {
    static void zza(zzpg com_google_android_gms_internal_zzpg, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzpg.zzabx, i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzpg.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzpg.zzanh);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzpg.zzani);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzpg.zzanj);
        zzb.zzc(parcel, 5, com_google_android_gms_internal_zzpg.zzank, false);
        zzb.zza(parcel, 6, com_google_android_gms_internal_zzpg.mTag, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfu(i);
    }

    public zzpg zzdv(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int zzJ = zza.zzJ(parcel);
        List list = zzpg.zzang;
        boolean z3 = true;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    locationRequest = (LocationRequest) zza.zza(parcel, zzI, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 3:
                    z3 = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzI, zzox.CREATOR);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzI);
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
            return new zzpg(i, locationRequest, z2, z3, z, list, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpg[] zzfu(int i) {
        return new zzpg[i];
    }
}
