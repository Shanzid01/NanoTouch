package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzgp implements Creator<zzgo> {
    static void zza(zzgo com_google_android_gms_internal_zzgo, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzgo.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzgo.zzwm, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzgo.zzwn, i, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzgo.zzlV, i, false);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzgo.zzlM, false);
        zzb.zza(parcel, 6, com_google_android_gms_internal_zzgo.applicationInfo, i, false);
        zzb.zza(parcel, 7, com_google_android_gms_internal_zzgo.zzwo, i, false);
        zzb.zza(parcel, 8, com_google_android_gms_internal_zzgo.zzwp, false);
        zzb.zza(parcel, 9, com_google_android_gms_internal_zzgo.zzwq, false);
        zzb.zza(parcel, 10, com_google_android_gms_internal_zzgo.zzwr, false);
        zzb.zza(parcel, 11, com_google_android_gms_internal_zzgo.zzlP, i, false);
        zzb.zza(parcel, 12, com_google_android_gms_internal_zzgo.zzws, false);
        zzb.zzc(parcel, 13, com_google_android_gms_internal_zzgo.zzwt);
        zzb.zzb(parcel, 14, com_google_android_gms_internal_zzgo.zzmf, false);
        zzb.zza(parcel, 15, com_google_android_gms_internal_zzgo.zzwu, false);
        zzb.zza(parcel, 17, com_google_android_gms_internal_zzgo.zzww, i, false);
        zzb.zza(parcel, 16, com_google_android_gms_internal_zzgo.zzwv);
        zzb.zzc(parcel, 19, com_google_android_gms_internal_zzgo.zzwy);
        zzb.zzc(parcel, 18, com_google_android_gms_internal_zzgo.zzwx);
        zzb.zza(parcel, 21, com_google_android_gms_internal_zzgo.zzwA, false);
        zzb.zza(parcel, 20, com_google_android_gms_internal_zzgo.zzwz);
        zzb.zzc(parcel, 23, com_google_android_gms_internal_zzgo.zzwC);
        zzb.zza(parcel, 22, com_google_android_gms_internal_zzgo.zzwB);
        zzb.zza(parcel, 25, com_google_android_gms_internal_zzgo.zzwE);
        zzb.zza(parcel, 24, com_google_android_gms_internal_zzgo.zzwD, false);
        zzb.zza(parcel, 26, com_google_android_gms_internal_zzgo.zzwF, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzh(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzv(i);
    }

    public zzgo zzh(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Bundle bundle = null;
        zzax com_google_android_gms_internal_zzax = null;
        zzba com_google_android_gms_internal_zzba = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzhy com_google_android_gms_internal_zzhy = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z2 = false;
        int i5 = 0;
        String str6 = null;
        long j = 0;
        String str7 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 3:
                    com_google_android_gms_internal_zzax = (zzax) zza.zza(parcel, zzI, zzax.CREATOR);
                    break;
                case 4:
                    com_google_android_gms_internal_zzba = (zzba) zza.zza(parcel, zzI, zzba.CREATOR);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zza.zza(parcel, zzI, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zza.zza(parcel, zzI, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 9:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 10:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 11:
                    com_google_android_gms_internal_zzhy = (zzhy) zza.zza(parcel, zzI, zzhy.CREATOR);
                    break;
                case 12:
                    bundle2 = zza.zzq(parcel, zzI);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 14:
                    list = zza.zzC(parcel, zzI);
                    break;
                case 15:
                    bundle3 = zza.zzq(parcel, zzI);
                    break;
                case 16:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 17:
                    messenger = (Messenger) zza.zza(parcel, zzI, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 19:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case 20:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 21:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 22:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 23:
                    i5 = zza.zzg(parcel, zzI);
                    break;
                case 24:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 25:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 26:
                    str7 = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzgo(i, bundle, com_google_android_gms_internal_zzax, com_google_android_gms_internal_zzba, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzhy, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, z2, i5, str6, j, str7);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzgo[] zzv(int i) {
        return new zzgo[i];
    }
}
