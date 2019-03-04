package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaw implements Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.zzFG);
        zzb.zza(parcel, 2, onListEntriesResponse.zzUY, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzTB);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaJ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcc(i);
    }

    public OnListEntriesResponse zzaJ(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            DataHolder dataHolder2;
            int zzg;
            boolean z2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzI);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzI, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzI);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnListEntriesResponse[] zzcc(int i) {
        return new OnListEntriesResponse[i];
    }
}
