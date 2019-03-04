package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public class zzpz implements Creator<zzpy> {
    static void zza(zzpy com_google_android_gms_internal_zzpy, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zzpy.getId(), false);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzpy.zzpS(), false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzpy.zzpU(), i, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zzpy.getLatLng(), i, false);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzpy.zzpO());
        zzb.zza(parcel, 6, com_google_android_gms_internal_zzpy.getViewport(), i, false);
        zzb.zza(parcel, 7, com_google_android_gms_internal_zzpy.zzpT(), false);
        zzb.zza(parcel, 8, com_google_android_gms_internal_zzpy.getWebsiteUri(), i, false);
        zzb.zza(parcel, 9, com_google_android_gms_internal_zzpy.zzpI());
        zzb.zza(parcel, 10, com_google_android_gms_internal_zzpy.getRating());
        zzb.zzc(parcel, 11, com_google_android_gms_internal_zzpy.getPriceLevel());
        zzb.zza(parcel, 12, com_google_android_gms_internal_zzpy.zzpR());
        zzb.zza(parcel, 13, com_google_android_gms_internal_zzpy.zzpN(), false);
        zzb.zza(parcel, 14, com_google_android_gms_internal_zzpy.getAddress(), false);
        zzb.zza(parcel, 15, com_google_android_gms_internal_zzpy.getPhoneNumber(), false);
        zzb.zzb(parcel, 17, com_google_android_gms_internal_zzpy.zzpQ(), false);
        zzb.zza(parcel, 16, com_google_android_gms_internal_zzpy.zzpP(), false);
        zzb.zzc(parcel, 1000, com_google_android_gms_internal_zzpy.zzFG);
        zzb.zza(parcel, 19, com_google_android_gms_internal_zzpy.getName(), false);
        zzb.zza(parcel, 18, com_google_android_gms_internal_zzpy.zzaoI);
        zzb.zza(parcel, 20, com_google_android_gms_internal_zzpy.getPlaceTypes(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfI(i);
    }

    public zzpy zzdF(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        boolean z2 = false;
        zzqd com_google_android_gms_internal_zzqd = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case 3:
                    com_google_android_gms_internal_zzqd = (zzqd) zza.zza(parcel, zzI, (Creator) zzqd.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzI, (Creator) LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case 8:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 10:
                    f2 = zza.zzl(parcel, zzI);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 12:
                    j = zza.zzi(parcel, zzI);
                    break;
                case 13:
                    list2 = zza.zzB(parcel, zzI);
                    break;
                case 14:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 15:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 16:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 17:
                    list3 = zza.zzC(parcel, zzI);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 19:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 20:
                    list = zza.zzB(parcel, zzI);
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
            return new zzpy(i, str, list, list2, bundle, str2, str3, str4, str5, list3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, z2, com_google_android_gms_internal_zzqd);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzpy[] zzfI(int i) {
        return new zzpy[i];
    }
}
