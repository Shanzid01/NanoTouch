package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.List;

public class zzm implements Creator<SessionStopResult> {
    static void zza(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, sessionStopResult.getVersionCode());
        zzb.zza(parcel, 2, sessionStopResult.getStatus(), i, false);
        zzb.zzc(parcel, 3, sessionStopResult.getSessions(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzel(i);
    }

    public SessionStopResult zzcM(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzI = zza.zzI(parcel);
            List list2;
            switch (zza.zzaP(zzI)) {
                case 2:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzI, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzI, Session.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzI);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzJ) {
            return new SessionStopResult(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SessionStopResult[] zzel(int i) {
        return new SessionStopResult[i];
    }
}
