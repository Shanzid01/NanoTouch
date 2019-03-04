package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzb.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, playerEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzb.zzc(parcel, 6, playerEntity.zzmE());
        zzb.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzb.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 14, playerEntity.getTitle(), false);
        zzb.zza(parcel, 15, playerEntity.zzmF(), i, false);
        zzb.zza(parcel, 16, playerEntity.getLevelInfo(), i, false);
        zzb.zzc(parcel, 1000, playerEntity.getVersionCode());
        zzb.zza(parcel, 19, playerEntity.zzmD());
        zzb.zza(parcel, 18, playerEntity.isProfileVisible());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeq(i);
    }

    public PlayerEntity zzcQ(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case 8:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 9:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 14:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zza.zza(parcel, zzI, (Creator) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) zza.zza(parcel, zzI, (Creator) PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 19:
                    z2 = zza.zzc(parcel, zzI);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PlayerEntity[] zzeq(int i) {
        return new PlayerEntity[i];
    }
}
