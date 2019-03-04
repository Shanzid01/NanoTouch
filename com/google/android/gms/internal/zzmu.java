package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.internal.zzxc.zzd;
import com.google.android.gms.internal.zzxd.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzmu {
    public static RawDataPoint zza(zzd[] com_google_android_gms_internal_zzxc_zzdArr, zzb com_google_android_gms_internal_zzxd_zzb) {
        return new RawDataPoint(4, com_google_android_gms_internal_zzxd_zzb.zzaIA, zzmt.zza(com_google_android_gms_internal_zzxd_zzb), zzmx.zza(com_google_android_gms_internal_zzxc_zzdArr, com_google_android_gms_internal_zzxd_zzb.zzaIC), com_google_android_gms_internal_zzxd_zzb.zzaID, com_google_android_gms_internal_zzxd_zzb.zzaIF, zzmt.zzb(com_google_android_gms_internal_zzxd_zzb), zzmt.zzc(com_google_android_gms_internal_zzxd_zzb));
    }

    public static List<RawDataPoint> zza(zzd[] com_google_android_gms_internal_zzxc_zzdArr, zzb[] com_google_android_gms_internal_zzxd_zzbArr) {
        List<RawDataPoint> arrayList = new ArrayList(com_google_android_gms_internal_zzxd_zzbArr.length);
        for (zzb zza : com_google_android_gms_internal_zzxd_zzbArr) {
            arrayList.add(zza(com_google_android_gms_internal_zzxc_zzdArr, zza));
        }
        return arrayList;
    }

    public static zzb zzb(RawDataPoint rawDataPoint) {
        zzb com_google_android_gms_internal_zzxd_zzb = new zzb();
        com_google_android_gms_internal_zzxd_zzb.zzaIA = rawDataPoint.zzYG;
        com_google_android_gms_internal_zzxd_zzb.zzaIC = zzmx.zza(rawDataPoint.zzYI);
        com_google_android_gms_internal_zzxd_zzb.zzaID = rawDataPoint.zzZJ;
        com_google_android_gms_internal_zzxd_zzb.zzaIF = rawDataPoint.zzZK;
        com_google_android_gms_internal_zzxd_zzb.zzaIB = rawDataPoint.zzYH;
        com_google_android_gms_internal_zzxd_zzb.zzaIH = rawDataPoint.zzYK;
        com_google_android_gms_internal_zzxd_zzb.zzaII = rawDataPoint.zzYL;
        return com_google_android_gms_internal_zzxd_zzb;
    }

    public static zzb[] zzl(List<RawDataPoint> list) {
        zzb[] com_google_android_gms_internal_zzxd_zzbArr = new zzb[list.size()];
        for (int i = 0; i < list.size(); i++) {
            com_google_android_gms_internal_zzxd_zzbArr[i] = zzb((RawDataPoint) list.get(i));
        }
        return com_google_android_gms_internal_zzxd_zzbArr;
    }
}
