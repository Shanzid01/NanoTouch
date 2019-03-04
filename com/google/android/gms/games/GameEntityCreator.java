package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GameEntityCreator implements Creator<GameEntity> {
    static void zza(GameEntity gameEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, gameEntity.getApplicationId(), false);
        zzb.zza(parcel, 2, gameEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, gameEntity.getPrimaryCategory(), false);
        zzb.zza(parcel, 4, gameEntity.getSecondaryCategory(), false);
        zzb.zza(parcel, 5, gameEntity.getDescription(), false);
        zzb.zza(parcel, 6, gameEntity.getDeveloperName(), false);
        zzb.zza(parcel, 7, gameEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        zzb.zza(parcel, 10, gameEntity.zzmx());
        zzb.zza(parcel, 11, gameEntity.zzmz());
        zzb.zza(parcel, 12, gameEntity.zzmA(), false);
        zzb.zzc(parcel, 13, gameEntity.zzmB());
        zzb.zzc(parcel, 14, gameEntity.getAchievementTotalCount());
        zzb.zzc(parcel, 15, gameEntity.getLeaderboardCount());
        zzb.zza(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        zzb.zza(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        zzb.zzc(parcel, 1000, gameEntity.getVersionCode());
        zzb.zza(parcel, 19, gameEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 18, gameEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 21, gameEntity.isMuted());
        zzb.zza(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        zzb.zza(parcel, 23, gameEntity.areSnapshotsEnabled());
        zzb.zza(parcel, 22, gameEntity.zzmy());
        zzb.zza(parcel, 25, gameEntity.hasGamepadSupport());
        zzb.zza(parcel, 24, gameEntity.getThemeColor(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeo(i);
    }

    public GameEntity zzcP(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        boolean z8 = false;
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
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 11:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 12:
                    str7 = zza.zzo(parcel, zzI);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 14:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 15:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case 16:
                    z3 = zza.zzc(parcel, zzI);
                    break;
                case 17:
                    z4 = zza.zzc(parcel, zzI);
                    break;
                case 18:
                    str8 = zza.zzo(parcel, zzI);
                    break;
                case 19:
                    str9 = zza.zzo(parcel, zzI);
                    break;
                case 20:
                    str10 = zza.zzo(parcel, zzI);
                    break;
                case 21:
                    z5 = zza.zzc(parcel, zzI);
                    break;
                case 22:
                    z6 = zza.zzc(parcel, zzI);
                    break;
                case 23:
                    z7 = zza.zzc(parcel, zzI);
                    break;
                case 24:
                    str11 = zza.zzo(parcel, zzI);
                    break;
                case 25:
                    z8 = zza.zzc(parcel, zzI);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11, z8);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GameEntity[] zzeo(int i) {
        return new GameEntity[i];
    }
}
