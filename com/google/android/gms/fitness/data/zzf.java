package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, dataSet.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataSet.getVersionCode());
        zzb.zza(parcel, 2, dataSet.getDataType(), i, false);
        zzb.zzd(parcel, 3, dataSet.zzlw(), false);
        zzb.zzc(parcel, 4, dataSet.zzlx(), false);
        zzb.zza(parcel, 5, dataSet.zzlo());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdk(i);
    }

    public DataSet zzbN(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzJ = zza.zzJ(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzI, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzI, DataType.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzI, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    list = zza.zzc(parcel, zzI, DataSource.CREATOR);
                    break;
                case 5:
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DataSet[] zzdk(int i) {
        return new DataSet[i];
    }
}
