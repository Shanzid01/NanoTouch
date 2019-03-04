package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.BleDevice;

public class zzc implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_fitness_request_zzb, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzb.getDeviceAddress(), false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_request_zzb.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzb.zzlP(), i, false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzb.zzlQ(), false);
        zzb.zza(parcel, 4, com_google_android_gms_fitness_request_zzb.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdz(i);
    }

    public zzb zzcb(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        BleDevice bleDevice = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    bleDevice = (BleDevice) zza.zza(parcel, zzI, BleDevice.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
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
            return new zzb(i, str2, bleDevice, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzb[] zzdz(int i) {
        return new zzb[i];
    }
}
