package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentAnnotationEntity.zzmO(), i, false);
        zzb.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzb.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzb.zza(parcel, 6, appContentAnnotationEntity.zzmR(), false);
        zzb.zza(parcel, 7, appContentAnnotationEntity.zzmM(), false);
        zzb.zzc(parcel, 8, appContentAnnotationEntity.zzmN());
        zzb.zzc(parcel, 9, appContentAnnotationEntity.zzmQ());
        zzb.zza(parcel, 10, appContentAnnotationEntity.zzmP(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzes(i);
    }

    public AppContentAnnotationEntity zzcS(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 10:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new AppContentAnnotationEntity(i3, str5, uri, str4, str3, str2, str, i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AppContentAnnotationEntity[] zzes(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
