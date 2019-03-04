package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<ValuesRemovedDetails> {
    static void zza(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, valuesRemovedDetails.zzFG);
        zzb.zzc(parcel, 2, valuesRemovedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesRemovedDetails.zzXf);
        zzb.zzc(parcel, 4, valuesRemovedDetails.zzXg);
        zzb.zza(parcel, 5, valuesRemovedDetails.zzXF, false);
        zzb.zzc(parcel, 6, valuesRemovedDetails.zzXG);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdb(i);
    }

    public ValuesRemovedDetails zzbH(Parcel parcel) {
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
            return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ValuesRemovedDetails[] zzdb(int i) {
        return new ValuesRemovedDetails[i];
    }
}
