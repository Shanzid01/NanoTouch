package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, userMetadata.zzFG);
        zzb.zza(parcel, 2, userMetadata.zzSI, false);
        zzb.zza(parcel, 3, userMetadata.zzSJ, false);
        zzb.zza(parcel, 4, userMetadata.zzSK, false);
        zzb.zza(parcel, 5, userMetadata.zzSL);
        zzb.zza(parcel, 6, userMetadata.zzSM, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzac(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbp(i);
    }

    public UserMetadata zzac(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public UserMetadata[] zzbp(int i) {
        return new UserMetadata[i];
    }
}
