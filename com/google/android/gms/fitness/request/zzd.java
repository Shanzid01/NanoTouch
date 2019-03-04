package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class zzd implements Creator<DataDeleteRequest> {
    static void zza(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, dataDeleteRequest.zzlp());
        zzb.zzc(parcel, 1000, dataDeleteRequest.getVersionCode());
        zzb.zza(parcel, 2, dataDeleteRequest.zzlq());
        zzb.zzc(parcel, 3, dataDeleteRequest.getDataSources(), false);
        zzb.zzc(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        zzb.zzc(parcel, 5, dataDeleteRequest.getSessions(), false);
        zzb.zza(parcel, 6, dataDeleteRequest.zzlR());
        zzb.zza(parcel, 7, dataDeleteRequest.zzlS());
        zzb.zza(parcel, 8, dataDeleteRequest.zzlQ(), false);
        zzb.zza(parcel, 9, dataDeleteRequest.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdA(i);
    }

    public DataDeleteRequest zzcc(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzI, DataSource.CREATOR);
                    break;
                case 4:
                    list2 = zza.zzc(parcel, zzI, DataType.CREATOR);
                    break;
                case 5:
                    list3 = zza.zzc(parcel, zzI, Session.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 8:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 9:
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
            return new DataDeleteRequest(i, j, j2, list, list2, list3, z, z2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DataDeleteRequest[] zzdA(int i) {
        return new DataDeleteRequest[i];
    }
}
