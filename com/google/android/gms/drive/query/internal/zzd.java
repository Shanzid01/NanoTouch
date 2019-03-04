package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, filterHolder.zzWA, i, false);
        zzb.zzc(parcel, 1000, filterHolder.zzFG);
        zzb.zza(parcel, 2, filterHolder.zzWB, i, false);
        zzb.zza(parcel, 3, filterHolder.zzWC, i, false);
        zzb.zza(parcel, 4, filterHolder.zzWD, i, false);
        zzb.zza(parcel, 5, filterHolder.zzWE, i, false);
        zzb.zza(parcel, 6, filterHolder.zzWF, i, false);
        zzb.zza(parcel, 7, filterHolder.zzWG, i, false);
        zzb.zza(parcel, 8, filterHolder.zzWH, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcF(i);
    }

    public FilterHolder zzbm(Parcel parcel) {
        FullTextSearchFilter fullTextSearchFilter = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzI, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzI, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) zza.zza(parcel, zzI, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) zza.zza(parcel, zzI, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) zza.zza(parcel, zzI, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzI, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) zza.zza(parcel, zzI, HasFilter.CREATOR);
                    break;
                case 8:
                    fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzI, FullTextSearchFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public FilterHolder[] zzcF(int i) {
        return new FilterHolder[i];
    }
}
