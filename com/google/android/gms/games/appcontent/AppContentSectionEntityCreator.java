package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zznd(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zzmJ(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zzmV(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zzne(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zzmT(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzev(i);
    }

    public AppContentSectionEntity zzcV(Parcel parcel) {
        ArrayList arrayList = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    arrayList3 = zza.zzc(parcel, zzI, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayList2 = zza.zzc(parcel, zzI, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 9:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 10:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 14:
                    arrayList = zza.zzc(parcel, zzI, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AppContentSectionEntity[] zzev(int i) {
        return new AppContentSectionEntity[i];
    }
}
