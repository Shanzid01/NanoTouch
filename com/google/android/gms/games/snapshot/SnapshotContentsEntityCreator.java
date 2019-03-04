package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    static void zza(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, snapshotContentsEntity.zzkq(), i, false);
        zzb.zzc(parcel, 1000, snapshotContentsEntity.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfa(i);
    }

    public SnapshotContentsEntity zzdi(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    contents = (Contents) zza.zza(parcel, zzI, Contents.CREATOR);
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
            return new SnapshotContentsEntity(i, contents);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SnapshotContentsEntity[] zzfa(int i) {
        return new SnapshotContentsEntity[i];
    }
}
