package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<WalletFragmentStyle> {
    static void zza(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, walletFragmentStyle.zzFG);
        zzb.zza(parcel, 2, walletFragmentStyle.zzaER, false);
        zzb.zzc(parcel, 3, walletFragmentStyle.zzaES);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhF(i);
    }

    public WalletFragmentStyle zzfh(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public WalletFragmentStyle[] zzhF(int i) {
        return new WalletFragmentStyle[i];
    }
}
