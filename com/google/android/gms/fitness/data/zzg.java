package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, dataSource.getDataType(), i, false);
        zzb.zzc(parcel, 1000, dataSource.getVersionCode());
        zzb.zza(parcel, 2, dataSource.getName(), false);
        zzb.zzc(parcel, 3, dataSource.getType());
        zzb.zza(parcel, 4, dataSource.getDevice(), i, false);
        zzb.zza(parcel, 5, dataSource.zzlz(), i, false);
        zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdl(i);
    }

    public DataSource zzbO(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        zza com_google_android_gms_fitness_data_zza = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataType = (DataType) zza.zza(parcel, zzI, DataType.CREATOR);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 4:
                    device = (Device) zza.zza(parcel, zzI, Device.CREATOR);
                    break;
                case 5:
                    com_google_android_gms_fitness_data_zza = (zza) zza.zza(parcel, zzI, zza.CREATOR);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzI);
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
            return new DataSource(i2, dataType, str2, i, device, com_google_android_gms_fitness_data_zza, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DataSource[] zzdl(int i) {
        return new DataSource[i];
    }
}
