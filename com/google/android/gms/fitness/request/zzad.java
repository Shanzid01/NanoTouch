package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzad implements Creator<zzac> {
    static void zza(zzac com_google_android_gms_fitness_request_zzac, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzac.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_fitness_request_zzac.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzac.getDataType(), i, false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzac.zzmg(), false);
        zzb.zzc(parcel, 4, com_google_android_gms_fitness_request_zzac.zzabq);
        zzb.zzc(parcel, 5, com_google_android_gms_fitness_request_zzac.zzabr);
        zzb.zza(parcel, 6, com_google_android_gms_fitness_request_zzac.zzlI());
        zzb.zza(parcel, 7, com_google_android_gms_fitness_request_zzac.zzmd());
        zzb.zza(parcel, 8, com_google_android_gms_fitness_request_zzac.zzmb(), i, false);
        zzb.zza(parcel, 9, com_google_android_gms_fitness_request_zzac.zzmc());
        zzb.zzc(parcel, 10, com_google_android_gms_fitness_request_zzac.getAccuracyMode());
        zzb.zzc(parcel, 11, com_google_android_gms_fitness_request_zzac.zzme(), false);
        zzb.zza(parcel, 12, com_google_android_gms_fitness_request_zzac.zzmf());
        zzb.zza(parcel, 13, com_google_android_gms_fitness_request_zzac.zzlQ(), false);
        zzb.zza(parcel, 14, com_google_android_gms_fitness_request_zzac.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdO(i);
    }

    public zzac zzcq(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        String str = null;
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
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzI, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 10:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case 11:
                    list = zza.zzc(parcel, zzI, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = zza.zzi(parcel, zzI);
                    break;
                case 13:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case 14:
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
            return new zzac(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4, iBinder2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzac[] zzdO(int i) {
        return new zzac[i];
    }
}
