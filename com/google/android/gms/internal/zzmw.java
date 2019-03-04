package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.Session.Builder;
import com.google.android.gms.internal.zzxe.zza;
import java.util.concurrent.TimeUnit;

public class zzmw {
    public static final zzmw zzZW = new zzmw();

    public Session zza(zza com_google_android_gms_internal_zzxe_zza) {
        String str = com_google_android_gms_internal_zzxe_zza.zzaIe == null ? FitnessActivities.UNKNOWN : com_google_android_gms_internal_zzxe_zza.zzaIe.packageName;
        Builder builder = new Builder();
        if (com_google_android_gms_internal_zzxe_zza.zzfl != null) {
            builder.setIdentifier(com_google_android_gms_internal_zzxe_zza.zzfl);
        }
        if (com_google_android_gms_internal_zzxe_zza.name != null) {
            builder.setName(com_google_android_gms_internal_zzxe_zza.name);
        }
        if (com_google_android_gms_internal_zzxe_zza.description != null) {
            builder.setDescription(com_google_android_gms_internal_zzxe_zza.description);
        }
        if (com_google_android_gms_internal_zzxe_zza.zzaIL != null) {
            builder.setStartTime(com_google_android_gms_internal_zzxe_zza.zzaIL.longValue(), TimeUnit.MILLISECONDS);
        }
        if (com_google_android_gms_internal_zzxe_zza.zzaIM != null) {
            builder.setEndTime(com_google_android_gms_internal_zzxe_zza.zzaIM.longValue(), TimeUnit.MILLISECONDS);
        }
        if (com_google_android_gms_internal_zzxe_zza.zzaIO != null) {
            builder.zzds(com_google_android_gms_internal_zzxe_zza.zzaIO.intValue());
        }
        builder.zzbL(str);
        return builder.build();
    }

    public zza zzb(Session session) {
        zza com_google_android_gms_internal_zzxe_zza = new zza();
        zzx.zzb(session.getIdentifier(), "session require identifier: " + session);
        com_google_android_gms_internal_zzxe_zza.zzfl = session.getIdentifier();
        if (session.getName() != null) {
            com_google_android_gms_internal_zzxe_zza.name = session.getName();
        }
        if (session.getDescription() != null) {
            com_google_android_gms_internal_zzxe_zza.description = session.getDescription();
        }
        com_google_android_gms_internal_zzxe_zza.zzaIL = Long.valueOf(session.getStartTime(TimeUnit.MILLISECONDS));
        com_google_android_gms_internal_zzxe_zza.zzaIM = Long.valueOf(session.getEndTime(TimeUnit.MILLISECONDS));
        com_google_android_gms_internal_zzxe_zza.zzaIO = Integer.valueOf(session.zzln());
        if (session.getAppPackageName() != null) {
            com_google_android_gms_internal_zzxe_zza.zzaIe = new zzxc.zza();
            com_google_android_gms_internal_zzxe_zza.zzaIe.packageName = session.getAppPackageName();
        }
        return com_google_android_gms_internal_zzxe_zza;
    }
}
