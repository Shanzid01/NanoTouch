package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentCardEntity.getVersionCode());
        zzb.zzc(parcel, 2, appContentCardEntity.zzmT(), false);
        zzb.zzc(parcel, 3, appContentCardEntity.zzmI(), false);
        zzb.zza(parcel, 4, appContentCardEntity.zzmJ(), false);
        zzb.zzc(parcel, 5, appContentCardEntity.zzmU());
        zzb.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzb.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzb.zza(parcel, 10, appContentCardEntity.zzmV(), false);
        zzb.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzb.zzc(parcel, 12, appContentCardEntity.zzmW());
        zzb.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzb.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcT(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzet(i);
    }

    public AppContentCardEntity zzcT(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzI, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = zza.zzc(parcel, zzI, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = zza.zzc(parcel, zzI, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 10:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 11:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 13:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 14:
                    str6 = zza.zzo(parcel, zzI);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AppContentCardEntity[] zzet(int i) {
        return new AppContentCardEntity[i];
    }
}
