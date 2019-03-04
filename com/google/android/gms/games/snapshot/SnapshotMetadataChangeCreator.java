package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void zza(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, snapshotMetadataChangeEntity.getVersionCode());
        zzb.zza(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        zzb.zza(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 5, snapshotMetadataChangeEntity.zzpc(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataChangeEntity.getProgressValue(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfb(i);
    }

    public SnapshotMetadataChangeEntity zzdj(Parcel parcel) {
        Long l = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Uri uri = null;
        com.google.android.gms.common.data.zza com_google_android_gms_common_data_zza = null;
        Long l2 = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    l2 = zza.zzj(parcel, zzI);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 5:
                    com_google_android_gms_common_data_zza = (com.google.android.gms.common.data.zza) zza.zza(parcel, zzI, com.google.android.gms.common.data.zza.CREATOR);
                    break;
                case 6:
                    l = zza.zzj(parcel, zzI);
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
            return new SnapshotMetadataChangeEntity(i, str, l2, com_google_android_gms_common_data_zza, uri, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SnapshotMetadataChangeEntity[] zzfb(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
