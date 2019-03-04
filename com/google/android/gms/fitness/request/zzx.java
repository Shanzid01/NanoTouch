package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzx implements Creator<zzw> {
    static void zza(zzw com_google_android_gms_fitness_request_zzw, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzw.getDataType(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_request_zzw.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzw.zzlQ(), false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzw.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdL(i);
    }

    public zzw zzcn(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            DataType dataType2;
            String str2;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            String str3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    dataType2 = (DataType) zza.zza(parcel, zzI, DataType.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    dataType2 = dataType;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzI);
                    str2 = str3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = zza.zzg(parcel, zzI);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    str2 = str;
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzw(i, dataType, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzw[] zzdL(int i) {
        return new zzw[i];
    }
}
