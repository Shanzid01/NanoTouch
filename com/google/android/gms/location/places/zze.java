package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze implements Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, placeFilter.zzany, false);
        zzb.zzc(parcel, 1000, placeFilter.zzFG);
        zzb.zza(parcel, 3, placeFilter.zzanC);
        zzb.zzc(parcel, 4, placeFilter.zzanD, false);
        zzb.zzb(parcel, 6, placeFilter.zzanE, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfC(i);
    }

    public PlaceFilter zzdB(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzJ = zza.zzJ(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    list3 = zza.zzB(parcel, zzI);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzI, zzj.CREATOR);
                    break;
                case 6:
                    list2 = zza.zzC(parcel, zzI);
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
            return new PlaceFilter(i, list3, z, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PlaceFilter[] zzfC(int i) {
        return new PlaceFilter[i];
    }
}
