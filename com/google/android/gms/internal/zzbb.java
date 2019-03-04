package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Creator<zzba> {
    static void zza(zzba com_google_android_gms_internal_zzba, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzba.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzba.zzpa, false);
        zzb.zzc(parcel, 3, com_google_android_gms_internal_zzba.height);
        zzb.zzc(parcel, 4, com_google_android_gms_internal_zzba.heightPixels);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzba.zzpb);
        zzb.zzc(parcel, 6, com_google_android_gms_internal_zzba.width);
        zzb.zzc(parcel, 7, com_google_android_gms_internal_zzba.widthPixels);
        zzb.zza(parcel, 8, com_google_android_gms_internal_zzba.zzpc, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzg(i);
    }

    public zzba zzc(Parcel parcel) {
        zzba[] com_google_android_gms_internal_zzbaArr = null;
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i5 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 8:
                    com_google_android_gms_internal_zzbaArr = (zzba[]) zza.zzb(parcel, zzI, zzba.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzba(i5, str, i4, i3, z, i2, i, com_google_android_gms_internal_zzbaArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzba[] zzg(int i) {
        return new zzba[i];
    }
}
