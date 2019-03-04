package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzb implements Creator<CastDevice> {
    static void zza(CastDevice castDevice, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, castDevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, castDevice.getDeviceId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, castDevice.zzIF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, castDevice.getFriendlyName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, castDevice.getModelName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, castDevice.getDeviceVersion(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, castDevice.getServicePort());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, castDevice.getIcons(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, castDevice.getCapabilities());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, castDevice.getStatus());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzad(i);
    }

    public CastDevice[] zzad(int i) {
        return new CastDevice[i];
    }

    public CastDevice zzu(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 8:
                    list = zza.zzc(parcel, zzI, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 10:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, list, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
