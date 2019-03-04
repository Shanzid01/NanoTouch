package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<QueryEvent> {
    static void zza(QueryEvent queryEvent, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, queryEvent.zzFG);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbt(i);
    }

    public QueryEvent zzaf(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new QueryEvent(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public QueryEvent[] zzbt(int i) {
        return new QueryEvent[i];
    }
}
