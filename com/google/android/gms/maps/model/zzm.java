package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzm implements Creator<PolygonOptions> {
    static void zza(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, polygonOptions.getVersionCode());
        zzb.zzc(parcel, 2, polygonOptions.getPoints(), false);
        zzb.zzd(parcel, 3, polygonOptions.zzqJ(), false);
        zzb.zza(parcel, 4, polygonOptions.getStrokeWidth());
        zzb.zzc(parcel, 5, polygonOptions.getStrokeColor());
        zzb.zzc(parcel, 6, polygonOptions.getFillColor());
        zzb.zza(parcel, 7, polygonOptions.getZIndex());
        zzb.zza(parcel, 8, polygonOptions.isVisible());
        zzb.zza(parcel, 9, polygonOptions.isGeodesic());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgb(i);
    }

    public PolygonOptions zzdY(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzI, LatLng.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzI, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = zza.zzl(parcel, zzI);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 7:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PolygonOptions[] zzgb(int i) {
        return new PolygonOptions[i];
    }
}
