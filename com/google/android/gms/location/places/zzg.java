package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<zzf> {
    static void zza(zzf com_google_android_gms_location_places_zzf, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, com_google_android_gms_location_places_zzf.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_location_places_zzf.zzpH(), i, false);
        zzb.zza(parcel, 3, com_google_android_gms_location_places_zzf.getInterval());
        zzb.zzc(parcel, 4, com_google_android_gms_location_places_zzf.getPriority());
        zzb.zza(parcel, 5, com_google_android_gms_location_places_zzf.getExpirationTime());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfE(i);
    }

    public zzf zzdC(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        PlaceFilter placeFilter = null;
        long j = zzf.zzanO;
        int i2 = 102;
        long j2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 2:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzI, PlaceFilter.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    j2 = zza.zzi(parcel, zzI);
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
            return new zzf(i, placeFilter, j, i2, j2);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzf[] zzfE(int i) {
        return new zzf[i];
    }
}
