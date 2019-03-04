package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zzf implements Creator<FullWallet> {
    static void zza(FullWallet fullWallet, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, fullWallet.getVersionCode());
        zzb.zza(parcel, 2, fullWallet.zzaCY, false);
        zzb.zza(parcel, 3, fullWallet.zzaCZ, false);
        zzb.zza(parcel, 4, fullWallet.zzaDa, i, false);
        zzb.zza(parcel, 5, fullWallet.zzaDb, false);
        zzb.zza(parcel, 6, fullWallet.zzaDc, i, false);
        zzb.zza(parcel, 7, fullWallet.zzaDd, i, false);
        zzb.zza(parcel, 8, fullWallet.zzaDe, false);
        zzb.zza(parcel, 9, fullWallet.zzaDf, i, false);
        zzb.zza(parcel, 10, fullWallet.zzaDg, i, false);
        zzb.zza(parcel, 11, fullWallet.zzaDh, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhp(i);
    }

    public FullWallet zzeS(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    proxyCard = (ProxyCard) zza.zza(parcel, zzI, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    address2 = (Address) zza.zza(parcel, zzI, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) zza.zza(parcel, zzI, Address.CREATOR);
                    break;
                case 8:
                    strArr = zza.zzA(parcel, zzI);
                    break;
                case 9:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzI, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) zza.zza(parcel, zzI, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzI, InstrumentInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public FullWallet[] zzhp(int i) {
        return new FullWallet[i];
    }
}
