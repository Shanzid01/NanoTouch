package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class AppMetadataCreator implements Creator<AppMetadata> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, appMetadata.getAppIdentifiers(), false);
        zzb.zzc(parcel, 1000, appMetadata.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public AppMetadata createFromParcel(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    list = zza.zzc(parcel, zzI, AppIdentifier.CREATOR);
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
            return new AppMetadata(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}
