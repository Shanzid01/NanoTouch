package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzg implements Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.zzFG);
        zzb.zza(parcel, 2, closeContentsRequest.zzTj, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzTl, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzan(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbB(i);
    }

    public CloseContentsRequest zzan(Parcel parcel) {
        Boolean bool = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < zzJ) {
            Contents contents2;
            int zzg;
            Boolean bool2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzI);
                    bool2 = bool3;
                    break;
                case 2:
                    zzg = i;
                    Contents contents3 = (Contents) zza.zza(parcel, zzI, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case 3:
                    bool2 = zza.zzd(parcel, zzI);
                    contents2 = contents;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i;
                    break;
            }
            i = zzg;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CloseContentsRequest[] zzbB(int i) {
        return new CloseContentsRequest[i];
    }
}
