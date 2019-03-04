package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<DrivePreferences> {
    static void zza(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, drivePreferences.zzFG);
        zzb.zza(parcel, 2, drivePreferences.zzSk);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbj(i);
    }

    public DrivePreferences zzY(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new DrivePreferences(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DrivePreferences[] zzbj(int i) {
        return new DrivePreferences[i];
    }
}
