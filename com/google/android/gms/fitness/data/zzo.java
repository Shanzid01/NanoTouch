package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzo implements Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzZJ);
        zzb.zzc(parcel, 1000, rawDataSet.zzFG);
        zzb.zzc(parcel, 2, rawDataSet.zzZL);
        zzb.zzc(parcel, 3, rawDataSet.zzZM, false);
        zzb.zza(parcel, 4, rawDataSet.zzYF);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdr(i);
    }

    public RawDataSet zzbU(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                    list = zza.zzc(parcel, zzI, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public RawDataSet[] zzdr(int i) {
        return new RawDataSet[i];
    }
}
