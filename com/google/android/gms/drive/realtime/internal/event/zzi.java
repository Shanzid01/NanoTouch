package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<ValuesAddedDetails> {
    static void zza(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, valuesAddedDetails.zzFG);
        zzb.zzc(parcel, 2, valuesAddedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesAddedDetails.zzXf);
        zzb.zzc(parcel, 4, valuesAddedDetails.zzXg);
        zzb.zza(parcel, 5, valuesAddedDetails.zzXD, false);
        zzb.zzc(parcel, 6, valuesAddedDetails.zzXE);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzda(i);
    }

    public ValuesAddedDetails zzbG(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i5 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ValuesAddedDetails[] zzda(int i) {
        return new ValuesAddedDetails[i];
    }
}
