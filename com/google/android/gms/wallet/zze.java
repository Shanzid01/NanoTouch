package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<zzd> {
    static void zza(zzd com_google_android_gms_wallet_zzd, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wallet_zzd.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_wallet_zzd.zzaCV, i, false);
        zzb.zza(parcel, 3, com_google_android_gms_wallet_zzd.zzaCW, i, false);
        zzb.zza(parcel, 4, com_google_android_gms_wallet_zzd.zzaCX, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzho(i);
    }

    public zzd zzeR(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        OfferWalletObject offerWalletObject = null;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < zzJ) {
            OfferWalletObject offerWalletObject2;
            LoyaltyWalletObject loyaltyWalletObject2;
            int zzg;
            GiftCardWalletObject giftCardWalletObject2;
            int zzI = zza.zzI(parcel);
            GiftCardWalletObject giftCardWalletObject3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = zza.zzg(parcel, zzI);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case 2:
                    zzg = i;
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = (LoyaltyWalletObject) zza.zza(parcel, zzI, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 3:
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = (OfferWalletObject) zza.zza(parcel, zzI, OfferWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case 4:
                    giftCardWalletObject2 = (GiftCardWalletObject) zza.zza(parcel, zzI, GiftCardWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
            }
            i = zzg;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
            giftCardWalletObject = giftCardWalletObject2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzd(i, loyaltyWalletObject, offerWalletObject, giftCardWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzd[] zzho(int i) {
        return new zzd[i];
    }
}
