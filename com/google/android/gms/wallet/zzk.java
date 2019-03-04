package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.zzd;
import com.google.android.gms.wallet.wobs.zzf;
import com.google.android.gms.wallet.wobs.zzj;
import com.google.android.gms.wallet.wobs.zzl;
import com.google.android.gms.wallet.wobs.zzn;
import com.google.android.gms.wallet.wobs.zzp;
import java.util.ArrayList;

public class zzk implements Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        zzb.zza(parcel, 2, loyaltyWalletObject.zzfl, false);
        zzb.zza(parcel, 3, loyaltyWalletObject.zzaDx, false);
        zzb.zza(parcel, 4, loyaltyWalletObject.zzaDy, false);
        zzb.zza(parcel, 5, loyaltyWalletObject.zzaDz, false);
        zzb.zza(parcel, 6, loyaltyWalletObject.zzapd, false);
        zzb.zza(parcel, 7, loyaltyWalletObject.zzaDA, false);
        zzb.zza(parcel, 8, loyaltyWalletObject.zzaDB, false);
        zzb.zza(parcel, 9, loyaltyWalletObject.zzaDC, false);
        zzb.zza(parcel, 10, loyaltyWalletObject.zzaDD, false);
        zzb.zza(parcel, 11, loyaltyWalletObject.zzaDE, false);
        zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        zzb.zzc(parcel, 13, loyaltyWalletObject.zzaDF, false);
        zzb.zza(parcel, 14, loyaltyWalletObject.zzaDG, i, false);
        zzb.zzc(parcel, 15, loyaltyWalletObject.zzaDH, false);
        zzb.zza(parcel, 17, loyaltyWalletObject.zzaDJ, false);
        zzb.zza(parcel, 16, loyaltyWalletObject.zzaDI, false);
        zzb.zza(parcel, 19, loyaltyWalletObject.zzaDL);
        zzb.zzc(parcel, 18, loyaltyWalletObject.zzaDK, false);
        zzb.zzc(parcel, 21, loyaltyWalletObject.zzaDN, false);
        zzb.zzc(parcel, 20, loyaltyWalletObject.zzaDM, false);
        zzb.zza(parcel, 23, loyaltyWalletObject.zzaDP, i, false);
        zzb.zzc(parcel, 22, loyaltyWalletObject.zzaDO, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhu(i);
    }

    public LoyaltyWalletObject zzeX(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList zzkb = zzls.zzkb();
        zzl com_google_android_gms_wallet_wobs_zzl = null;
        ArrayList zzkb2 = zzls.zzkb();
        String str11 = null;
        String str12 = null;
        ArrayList zzkb3 = zzls.zzkb();
        boolean z = false;
        ArrayList zzkb4 = zzls.zzkb();
        ArrayList zzkb5 = zzls.zzkb();
        ArrayList zzkb6 = zzls.zzkb();
        zzf com_google_android_gms_wallet_wobs_zzf = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str7 = zza.zzo(parcel, zzI);
                    break;
                case 9:
                    str8 = zza.zzo(parcel, zzI);
                    break;
                case 10:
                    str9 = zza.zzo(parcel, zzI);
                    break;
                case 11:
                    str10 = zza.zzo(parcel, zzI);
                    break;
                case 12:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 13:
                    zzkb = zza.zzc(parcel, zzI, zzp.CREATOR);
                    break;
                case 14:
                    com_google_android_gms_wallet_wobs_zzl = (zzl) zza.zza(parcel, zzI, zzl.CREATOR);
                    break;
                case 15:
                    zzkb2 = zza.zzc(parcel, zzI, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = zza.zzo(parcel, zzI);
                    break;
                case 17:
                    str12 = zza.zzo(parcel, zzI);
                    break;
                case 18:
                    zzkb3 = zza.zzc(parcel, zzI, zzd.CREATOR);
                    break;
                case 19:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 20:
                    zzkb4 = zza.zzc(parcel, zzI, zzn.CREATOR);
                    break;
                case 21:
                    zzkb5 = zza.zzc(parcel, zzI, zzj.CREATOR);
                    break;
                case 22:
                    zzkb6 = zza.zzc(parcel, zzI, zzn.CREATOR);
                    break;
                case 23:
                    com_google_android_gms_wallet_wobs_zzf = (zzf) zza.zza(parcel, zzI, zzf.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzkb, com_google_android_gms_wallet_wobs_zzl, zzkb2, str11, str12, zzkb3, z, zzkb4, zzkb5, zzkb6, com_google_android_gms_wallet_wobs_zzf);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LoyaltyWalletObject[] zzhu(int i) {
        return new LoyaltyWalletObject[i];
    }
}
