package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryEvent;

public class zzau implements Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onEventResponse.zzFG);
        zzb.zzc(parcel, 2, onEventResponse.zzTe);
        zzb.zza(parcel, 3, onEventResponse.zzUU, i, false);
        zzb.zza(parcel, 5, onEventResponse.zzUV, i, false);
        zzb.zza(parcel, 6, onEventResponse.zzUW, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzca(i);
    }

    public OnEventResponse zzaH(Parcel parcel) {
        int i = 0;
        QueryEvent queryEvent = null;
        int zzJ = zza.zzJ(parcel);
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzI, ChangeEvent.CREATOR);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzI, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryEvent = (QueryEvent) zza.zza(parcel, zzI, QueryEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent, queryEvent);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnEventResponse[] zzca(int i) {
        return new OnEventResponse[i];
    }
}
