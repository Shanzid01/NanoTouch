package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class zzb implements Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel, 1, dataReadResult.zzmp(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataReadResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataReadResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel, 3, dataReadResult.zzmo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, dataReadResult.zzmn());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, dataReadResult.zzlx(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, dataReadResult.zzmq(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzed(i);
    }

    public DataReadResult zzcE(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzJ = zza.zzJ(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    zza.zza(parcel, zzI, arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzI, Status.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzI, arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    list2 = zza.zzc(parcel, zzI, DataSource.CREATOR);
                    break;
                case 7:
                    list = zza.zzc(parcel, zzI, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DataReadResult[] zzed(int i) {
        return new DataReadResult[i];
    }
}
