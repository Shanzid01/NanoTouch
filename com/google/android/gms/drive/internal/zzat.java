package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzat implements Creator<OnDrivePreferencesResponse> {
    static void zza(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onDrivePreferencesResponse.zzFG);
        zzb.zza(parcel, 2, onDrivePreferencesResponse.zzUT, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbZ(i);
    }

    public OnDrivePreferencesResponse zzaG(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzI, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnDrivePreferencesResponse[] zzbZ(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
