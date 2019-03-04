package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.internal.zzxd.zzc;
import java.util.List;

public class zzmv {
    public static zzc zzb(RawDataSet rawDataSet) {
        zzc com_google_android_gms_internal_zzxd_zzc = new zzc();
        com_google_android_gms_internal_zzxd_zzc.zzaID = rawDataSet.zzZJ;
        com_google_android_gms_internal_zzxd_zzc.zzaIK = zzmu.zzl(rawDataSet.zzZM);
        com_google_android_gms_internal_zzxd_zzc.zzaIx = rawDataSet.zzYF;
        return com_google_android_gms_internal_zzxd_zzc;
    }

    public static zzc[] zzm(List<RawDataSet> list) {
        zzc[] com_google_android_gms_internal_zzxd_zzcArr = new zzc[list.size()];
        for (int i = 0; i < list.size(); i++) {
            com_google_android_gms_internal_zzxd_zzcArr[i] = zzb((RawDataSet) list.get(i));
        }
        return com_google_android_gms_internal_zzxd_zzcArr;
    }
}
