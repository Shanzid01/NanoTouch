package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzap implements Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.zzFG);
        zzb.zza(parcel, 2, onContentsResponse.zzTO, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzUP);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbV(i);
    }

    public OnContentsResponse zzaC(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            Contents contents2;
            int zzg;
            boolean z2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    boolean z3 = z;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzI);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    Contents contents3 = (Contents) zza.zza(parcel, zzI, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzI);
                    contents2 = contents;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    z2 = z;
                    contents2 = contents;
                    zzg = i;
                    break;
            }
            i = zzg;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnContentsResponse[] zzbV(int i) {
        return new OnContentsResponse[i];
    }
}
