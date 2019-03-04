package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzaq implements Creator<StartBleScanRequest> {
    static void zza(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, startBleScanRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, startBleScanRequest.getVersionCode());
        zzb.zza(parcel, 2, startBleScanRequest.zzmk(), false);
        zzb.zzc(parcel, 3, startBleScanRequest.getTimeoutSecs());
        zzb.zza(parcel, 4, startBleScanRequest.zzlQ(), false);
        zzb.zza(parcel, 5, startBleScanRequest.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdX(i);
    }

    public StartBleScanRequest zzcy(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    list = zza.zzc(parcel, zzI, DataType.CREATOR);
                    break;
                case 2:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 5:
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
            return new StartBleScanRequest(i2, list, iBinder2, i, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public StartBleScanRequest[] zzdX(int i) {
        return new StartBleScanRequest[i];
    }
}
