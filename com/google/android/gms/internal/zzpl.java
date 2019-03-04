package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzpl implements Creator<zzpk> {
    static void zza(zzpk com_google_android_gms_internal_zzpk, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzpk.getRequestId(), false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzpk.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzpk.getExpirationTime());
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzpk.zzpB());
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzpk.getLatitude());
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzpk.getLongitude());
        zzb.zza(parcel, 6, com_google_android_gms_internal_zzpk.zzpC());
        zzb.zzc(parcel, 7, com_google_android_gms_internal_zzpk.zzpD());
        zzb.zzc(parcel, 8, com_google_android_gms_internal_zzpk.getNotificationResponsiveness());
        zzb.zzc(parcel, 9, com_google_android_gms_internal_zzpk.zzpE());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfy(i);
    }

    public zzpk zzdx(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 3:
                    s = zza.zzf(parcel, zzI);
                    break;
                case 4:
                    d = zza.zzm(parcel, zzI);
                    break;
                case 5:
                    d2 = zza.zzm(parcel, zzI);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 8:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 9:
                    i4 = zza.zzg(parcel, zzI);
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
            return new zzpk(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpk[] zzfy(int i) {
        return new zzpk[i];
    }
}
