package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<BleDevice> {
    static void zza(BleDevice bleDevice, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, bleDevice.getAddress(), false);
        zzb.zzc(parcel, 1000, bleDevice.getVersionCode());
        zzb.zza(parcel, 2, bleDevice.getName(), false);
        zzb.zzb(parcel, 3, bleDevice.getSupportedProfiles(), false);
        zzb.zzc(parcel, 4, bleDevice.getDataTypes(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdf(i);
    }

    public BleDevice zzbK(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    list2 = zza.zzC(parcel, zzI);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzI, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public BleDevice[] zzdf(int i) {
        return new BleDevice[i];
    }
}
