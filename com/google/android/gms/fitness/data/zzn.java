package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzYG);
        zzb.zzc(parcel, 1000, rawDataPoint.zzFG);
        zzb.zza(parcel, 2, rawDataPoint.zzYH);
        zzb.zza(parcel, 3, rawDataPoint.zzYI, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzZJ);
        zzb.zzc(parcel, 5, rawDataPoint.zzZK);
        zzb.zza(parcel, 6, rawDataPoint.zzYK);
        zzb.zza(parcel, 7, rawDataPoint.zzYL);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdq(i);
    }

    public RawDataPoint zzbT(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    valueArr = (Value[]) zza.zzb(parcel, zzI, Value.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 7:
                    j4 = zza.zzi(parcel, zzI);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public RawDataPoint[] zzdq(int i) {
        return new RawDataPoint[i];
    }
}
