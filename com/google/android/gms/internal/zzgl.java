package com.google.android.gms.internal;

import android.content.Context;

@zzgi
public final class zzgl {

    public interface zza {
        void zzb(zzgq com_google_android_gms_internal_zzgq);
    }

    interface zzb {
        boolean zzc(zzgo com_google_android_gms_internal_zzgo);
    }

    final class C12131 implements zzb {
        C12131() {
        }

        public boolean zzc(zzgo com_google_android_gms_internal_zzgo) {
            return com_google_android_gms_internal_zzgo.zzlP.zzzK;
        }
    }

    public static zzhl zza(Context context, zzgo com_google_android_gms_internal_zzgo, zza com_google_android_gms_internal_zzgl_zza) {
        return zza(context, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzgl_zza, new C12131());
    }

    static zzhl zza(Context context, zzgo com_google_android_gms_internal_zzgo, zza com_google_android_gms_internal_zzgl_zza, zzb com_google_android_gms_internal_zzgl_zzb) {
        return com_google_android_gms_internal_zzgl_zzb.zzc(com_google_android_gms_internal_zzgo) ? zzb(context, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzgl_zza) : zzc(context, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzgl_zza);
    }

    private static zzhl zzb(Context context, zzgo com_google_android_gms_internal_zzgo, zza com_google_android_gms_internal_zzgl_zza) {
        zzhx.zzY("Fetching ad response from local ad request service.");
        zzhl com_google_android_gms_internal_zzgm_zza = new com.google.android.gms.internal.zzgm.zza(context, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzgl_zza);
        com_google_android_gms_internal_zzgm_zza.start();
        return com_google_android_gms_internal_zzgm_zza;
    }

    private static zzhl zzc(Context context, zzgo com_google_android_gms_internal_zzgo, zza com_google_android_gms_internal_zzgl_zza) {
        zzhx.zzY("Fetching ad response from remote ad request service.");
        if (zzbe.zzbD().zzA(context)) {
            return new com.google.android.gms.internal.zzgm.zzb(context, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzgl_zza);
        }
        zzhx.zzac("Failed to connect to remote ad request service.");
        return null;
    }
}
