package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzd implements Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.zzFG);
        zzb.zzc(parcel, 2, parcelableEventList.zzmv, false);
        zzb.zza(parcel, 3, parcelableEventList.zzXv, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzXw);
        zzb.zzb(parcel, 5, parcelableEventList.zzXx, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcV(i);
    }

    public ParcelableEventList zzbB(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzJ = zza.zzJ(parcel);
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzI, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzI, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 5:
                    list = zza.zzC(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ParcelableEventList(i, list2, dataHolder, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ParcelableEventList[] zzcV(int i) {
        return new ParcelableEventList[i];
    }
}
