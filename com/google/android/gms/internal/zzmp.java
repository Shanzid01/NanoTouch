package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzxc.zzc;
import com.google.android.gms.internal.zzxc.zzd;
import java.util.List;

public class zzmp {
    public static final zzmp zzZU = new zzmp();

    public zzc zzc(DataType dataType) {
        zzc com_google_android_gms_internal_zzxc_zzc = new zzc();
        com_google_android_gms_internal_zzxc_zzc.name = dataType.getName();
        List fields = dataType.getFields();
        com_google_android_gms_internal_zzxc_zzc.zzaIf = new zzd[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            com_google_android_gms_internal_zzxc_zzc.zzaIf[i] = zzmq.zzZV.zzb((Field) fields.get(i));
        }
        return com_google_android_gms_internal_zzxc_zzc;
    }
}
