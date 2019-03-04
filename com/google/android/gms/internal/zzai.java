package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzah.zza;
import java.util.concurrent.Future;

@zzgi
public class zzai {
    protected zzah zza(Context context, zzhy com_google_android_gms_internal_zzhy, final zzhq<zzah> com_google_android_gms_internal_zzhq_com_google_android_gms_internal_zzah) {
        final zzah com_google_android_gms_internal_zzaj = new zzaj(context, com_google_android_gms_internal_zzhy);
        com_google_android_gms_internal_zzaj.zza(new zza(this) {
            final /* synthetic */ zzai zznO;

            public void zzbk() {
                com_google_android_gms_internal_zzhq_com_google_android_gms_internal_zzah.zzb(com_google_android_gms_internal_zzaj);
            }
        });
        return com_google_android_gms_internal_zzaj;
    }

    public Future<zzah> zza(Context context, zzhy com_google_android_gms_internal_zzhy, String str) {
        final Future com_google_android_gms_internal_zzhq = new zzhq();
        final Context context2 = context;
        final zzhy com_google_android_gms_internal_zzhy2 = com_google_android_gms_internal_zzhy;
        final String str2 = str;
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzai zznO;

            public void run() {
                this.zznO.zza(context2, com_google_android_gms_internal_zzhy2, com_google_android_gms_internal_zzhq).zzg(str2);
            }
        });
        return com_google_android_gms_internal_zzhq;
    }
}
