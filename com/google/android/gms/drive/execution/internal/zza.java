package com.google.android.gms.drive.execution.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ContentTransferInfoResponse> {
    static void zza(ContentTransferInfoResponse contentTransferInfoResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, contentTransferInfoResponse.zzFG);
        zzb.zzc(parcel, 2, contentTransferInfoResponse.zzJp);
        zzb.zzc(parcel, 3, contentTransferInfoResponse.zzrX);
        zzb.zza(parcel, 4, contentTransferInfoResponse.zzTc);
        zzb.zza(parcel, 5, contentTransferInfoResponse.zzTd);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzag(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbu(i);
    }

    public ContentTransferInfoResponse zzag(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 4:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzI);
                    break;
                case 5:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ContentTransferInfoResponse(i3, i2, i, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ContentTransferInfoResponse[] zzbu(int i) {
        return new ContentTransferInfoResponse[i];
    }
}
