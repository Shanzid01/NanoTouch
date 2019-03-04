package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<LocationRequest> {
    static void zza(LocationRequest locationRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, locationRequest.mPriority);
        zzb.zzc(parcel, 1000, locationRequest.getVersionCode());
        zzb.zza(parcel, 2, locationRequest.zzamf);
        zzb.zza(parcel, 3, locationRequest.zzamg);
        zzb.zza(parcel, 4, locationRequest.zzabz);
        zzb.zza(parcel, 5, locationRequest.zzalO);
        zzb.zzc(parcel, 6, locationRequest.zzamh);
        zzb.zza(parcel, 7, locationRequest.zzami);
        zzb.zza(parcel, 8, locationRequest.zzamj);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdp(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfl(i);
    }

    public LocationRequest zzdp(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 5:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case 6:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 7:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 8:
                    j4 = zza.zzi(parcel, zzI);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LocationRequest[] zzfl(int i) {
        return new LocationRequest[i];
    }
}
