package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<zzp> {
    static void zza(zzp com_google_android_gms_wallet_wobs_zzp, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wallet_wobs_zzp.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_wallet_wobs_zzp.zzaFl, false);
        zzb.zza(parcel, 3, com_google_android_gms_wallet_wobs_zzp.zzwG, false);
        zzb.zza(parcel, 4, com_google_android_gms_wallet_wobs_zzp.zzaFo, i, false);
        zzb.zza(parcel, 5, com_google_android_gms_wallet_wobs_zzp.zzaFp, i, false);
        zzb.zza(parcel, 6, com_google_android_gms_wallet_wobs_zzp.zzaFq, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhQ(i);
    }

    public zzp zzfq(Parcel parcel) {
        zzn com_google_android_gms_wallet_wobs_zzn = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        zzn com_google_android_gms_wallet_wobs_zzn2 = null;
        zzl com_google_android_gms_wallet_wobs_zzl = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    com_google_android_gms_wallet_wobs_zzl = (zzl) zza.zza(parcel, zzI, zzl.CREATOR);
                    break;
                case 5:
                    com_google_android_gms_wallet_wobs_zzn2 = (zzn) zza.zza(parcel, zzI, zzn.CREATOR);
                    break;
                case 6:
                    com_google_android_gms_wallet_wobs_zzn = (zzn) zza.zza(parcel, zzI, zzn.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzp(i, str2, str, com_google_android_gms_wallet_wobs_zzl, com_google_android_gms_wallet_wobs_zzn2, com_google_android_gms_wallet_wobs_zzn);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzp[] zzhQ(int i) {
        return new zzp[i];
    }
}
