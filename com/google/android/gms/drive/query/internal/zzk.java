package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<MatchAllFilter> {
    static void zza(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, matchAllFilter.zzFG);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcK(i);
    }

    public MatchAllFilter zzbr(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1000:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new MatchAllFilter(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public MatchAllFilter[] zzcK(int i) {
        return new MatchAllFilter[i];
    }
}
