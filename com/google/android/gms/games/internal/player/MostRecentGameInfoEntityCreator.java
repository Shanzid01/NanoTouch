package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, mostRecentGameInfoEntity.zzoF(), false);
        zzb.zzc(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        zzb.zza(parcel, 2, mostRecentGameInfoEntity.zzoG(), false);
        zzb.zza(parcel, 3, mostRecentGameInfoEntity.zzoH());
        zzb.zza(parcel, 4, mostRecentGameInfoEntity.zzoI(), i, false);
        zzb.zza(parcel, 5, mostRecentGameInfoEntity.zzoJ(), i, false);
        zzb.zza(parcel, 6, mostRecentGameInfoEntity.zzoK(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeS(i);
    }

    public MostRecentGameInfoEntity zzdc(Parcel parcel) {
        Uri uri = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 4:
                    uri3 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public MostRecentGameInfoEntity[] zzeS(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
