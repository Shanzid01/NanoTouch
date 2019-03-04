package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<NotFilter> {
    static void zza(NotFilter notFilter, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, notFilter.zzFG);
        zzb.zza(parcel, 1, notFilter.zzWL, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcL(i);
    }

    public NotFilter zzbs(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzI, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public NotFilter[] zzcL(int i) {
        return new NotFilter[i];
    }
}
