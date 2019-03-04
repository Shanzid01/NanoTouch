package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collection;

public class zzb implements Creator<AutocompleteFilter> {
    static void zza(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, autocompleteFilter.zzpF());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, autocompleteFilter.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, autocompleteFilter.zzany, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfA(i);
    }

    public AutocompleteFilter zzdz(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        Collection collection = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 2:
                    collection = zza.zzB(parcel, zzI);
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
            return new AutocompleteFilter(i, z, collection);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AutocompleteFilter[] zzfA(int i) {
        return new AutocompleteFilter[i];
    }
}
