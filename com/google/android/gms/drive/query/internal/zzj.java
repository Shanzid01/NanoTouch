package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzj implements Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, logicalFilter.zzFG);
        zzb.zza(parcel, 1, logicalFilter.zzWw, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzWK, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcJ(i);
    }

    public LogicalFilter zzbq(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            Operator operator2;
            ArrayList zzc;
            int zzI = zza.zzI(parcel);
            List list2;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) zza.zza(parcel, zzI, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzI, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = zza.zzg(parcel, zzI);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzc = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzJ) {
            return new LogicalFilter(i, operator, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LogicalFilter[] zzcJ(int i) {
        return new LogicalFilter[i];
    }
}
