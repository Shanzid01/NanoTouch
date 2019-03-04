package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, parcelableCollaborator.zzFG);
        zzb.zza(parcel, 2, parcelableCollaborator.zzWX);
        zzb.zza(parcel, 3, parcelableCollaborator.zzWY);
        zzb.zza(parcel, 4, parcelableCollaborator.zzyL, false);
        zzb.zza(parcel, 5, parcelableCollaborator.zzWZ, false);
        zzb.zza(parcel, 6, parcelableCollaborator.zzSJ, false);
        zzb.zza(parcel, 7, parcelableCollaborator.zzXa, false);
        zzb.zza(parcel, 8, parcelableCollaborator.zzXb, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcQ(i);
    }

    public ParcelableCollaborator zzbw(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ParcelableCollaborator[] zzcQ(int i) {
        return new ParcelableCollaborator[i];
    }
}
