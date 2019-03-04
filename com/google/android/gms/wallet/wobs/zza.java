package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zza implements Creator<CommonWalletObject> {
    static void zza(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, commonWalletObject.getVersionCode());
        zzb.zza(parcel, 2, commonWalletObject.zzfl, false);
        zzb.zza(parcel, 3, commonWalletObject.zzaDE, false);
        zzb.zza(parcel, 4, commonWalletObject.name, false);
        zzb.zza(parcel, 5, commonWalletObject.zzaDy, false);
        zzb.zza(parcel, 6, commonWalletObject.zzaDA, false);
        zzb.zza(parcel, 7, commonWalletObject.zzaDB, false);
        zzb.zza(parcel, 8, commonWalletObject.zzaDC, false);
        zzb.zza(parcel, 9, commonWalletObject.zzaDD, false);
        zzb.zzc(parcel, 10, commonWalletObject.state);
        zzb.zzc(parcel, 11, commonWalletObject.zzaDF, false);
        zzb.zza(parcel, 12, commonWalletObject.zzaDG, i, false);
        zzb.zzc(parcel, 13, commonWalletObject.zzaDH, false);
        zzb.zza(parcel, 14, commonWalletObject.zzaDI, false);
        zzb.zza(parcel, 15, commonWalletObject.zzaDJ, false);
        zzb.zza(parcel, 17, commonWalletObject.zzaDL);
        zzb.zzc(parcel, 16, commonWalletObject.zzaDK, false);
        zzb.zzc(parcel, 19, commonWalletObject.zzaDN, false);
        zzb.zzc(parcel, 18, commonWalletObject.zzaDM, false);
        zzb.zzc(parcel, 20, commonWalletObject.zzaDO, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhI(i);
    }

    public CommonWalletObject zzfi(Parcel parcel) {
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList zzkb = zzls.zzkb();
        zzl com_google_android_gms_wallet_wobs_zzl = null;
        ArrayList zzkb2 = zzls.zzkb();
        String str9 = null;
        String str10 = null;
        ArrayList zzkb3 = zzls.zzkb();
        boolean z = false;
        ArrayList zzkb4 = zzls.zzkb();
        ArrayList zzkb5 = zzls.zzkb();
        ArrayList zzkb6 = zzls.zzkb();
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case 11:
                    zzkb = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzp.CREATOR);
                    break;
                case 12:
                    com_google_android_gms_wallet_wobs_zzl = (zzl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, zzl.CREATOR);
                    break;
                case 13:
                    zzkb2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case 16:
                    zzkb3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzd.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case 18:
                    zzkb4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzn.CREATOR);
                    break;
                case 19:
                    zzkb5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzj.CREATOR);
                    break;
                case 20:
                    zzkb6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzn.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, zzkb, com_google_android_gms_wallet_wobs_zzl, zzkb2, str9, str10, zzkb3, z, zzkb4, zzkb5, zzkb6);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CommonWalletObject[] zzhI(int i) {
        return new CommonWalletObject[i];
    }
}
