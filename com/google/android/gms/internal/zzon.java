package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzon implements Creator<zzom> {
    static void zza(zzom com_google_android_gms_internal_zzom, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzom.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzom.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzca(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdy(i);
    }

    public zzom zzca(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzI, DataSource.CREATOR);
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
            return new zzom(i, dataSource);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzom[] zzdy(int i) {
        return new zzom[i];
    }
}
