package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzm implements Creator<RawBucket> {
    static void zza(RawBucket rawBucket, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, rawBucket.zzON);
        zzb.zzc(parcel, 1000, rawBucket.zzFG);
        zzb.zza(parcel, 2, rawBucket.zzYq);
        zzb.zza(parcel, 3, rawBucket.zzYs, i, false);
        zzb.zzc(parcel, 4, rawBucket.zzZI);
        zzb.zzc(parcel, 5, rawBucket.zzYD, false);
        zzb.zzc(parcel, 6, rawBucket.zzYE);
        zzb.zza(parcel, 7, rawBucket.zzYF);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdp(i);
    }

    public RawBucket zzbS(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    session = (Session) zza.zza(parcel, zzI, Session.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzI, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 7:
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
            return new RawBucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public RawBucket[] zzdp(int i) {
        return new RawBucket[i];
    }
}
