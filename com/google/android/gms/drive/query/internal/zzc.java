package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<FieldWithSortOrder> {
    static void zza(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, fieldWithSortOrder.zzFG);
        zzb.zza(parcel, 1, fieldWithSortOrder.zzVg, false);
        zzb.zza(parcel, 2, fieldWithSortOrder.zzWz);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcE(i);
    }

    public FieldWithSortOrder zzbl(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzI);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public FieldWithSortOrder[] zzcE(int i) {
        return new FieldWithSortOrder[i];
    }
}
