package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzah.zza;
import org.json.JSONObject;

@zzgi
public class zzaj implements zzah {
    private final zzic zzmu;

    public zzaj(Context context, zzhy com_google_android_gms_internal_zzhy) {
        this.zzmu = zzab.zzaN().zza(context, new zzba(), false, false, null, com_google_android_gms_internal_zzhy);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzbe.zzbD().zzeC()) {
            runnable.run();
        } else {
            zzhw.zzzG.post(runnable);
        }
    }

    public void destroy() {
        this.zzmu.destroy();
    }

    public void zza(final zza com_google_android_gms_internal_zzah_zza) {
        this.zzmu.zzeG().zza(new zzid.zza(this) {
            final /* synthetic */ zzaj zznS;

            public void zza(zzic com_google_android_gms_internal_zzic, boolean z) {
                com_google_android_gms_internal_zzah_zza.zzbk();
            }
        });
    }

    public void zza(zzat com_google_android_gms_internal_zzat, zzep com_google_android_gms_internal_zzep, zzct com_google_android_gms_internal_zzct, zzes com_google_android_gms_internal_zzes, boolean z, zzcw com_google_android_gms_internal_zzcw, zzcy com_google_android_gms_internal_zzcy, zzu com_google_android_gms_internal_zzu, zzeh com_google_android_gms_internal_zzeh) {
        this.zzmu.zzeG().zzb(com_google_android_gms_internal_zzat, com_google_android_gms_internal_zzep, com_google_android_gms_internal_zzct, com_google_android_gms_internal_zzes, z, com_google_android_gms_internal_zzcw, com_google_android_gms_internal_zzcy, new zzu(false), com_google_android_gms_internal_zzeh);
    }

    public void zza(String str, zzcv com_google_android_gms_internal_zzcv) {
        this.zzmu.zzeG().zza(str, com_google_android_gms_internal_zzcv);
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.zza(str, jSONObject);
            }
        });
    }

    public void zzb(String str, zzcv com_google_android_gms_internal_zzcv) {
        this.zzmu.zzeG().zzb(str, com_google_android_gms_internal_zzcv);
    }

    public void zzb(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.zzb(str, str2);
            }
        });
    }

    public void zzf(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void zzg(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzaj zznS;

            public void run() {
                this.zznS.zzmu.loadUrl(str);
            }
        });
    }
}
