package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzav implements Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.zzFG);
        zzb.zza(parcel, 2, onFetchThumbnailResponse.zzUX, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaI(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcb(i);
    }

    public OnFetchThumbnailResponse zzaI(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnFetchThumbnailResponse[] zzcb(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
