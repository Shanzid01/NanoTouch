package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.zzid.zza;

@zzgi
public abstract class zzfy extends zzgb implements zza {
    private boolean zzsg = false;
    private final zzid zzvy;
    protected boolean zzvz = false;

    protected zzfy(Context context, zzhe.zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic, zzgc.zza com_google_android_gms_internal_zzgc_zza) {
        super(context, com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic, com_google_android_gms_internal_zzgc_zza);
        this.zzvy = com_google_android_gms_internal_zzic.zzeG();
    }

    private boolean zzd(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 1) {
            return false;
        }
        try {
            this.zznh.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zzgb.zza("Ad request cancelled.", -1);
        }
    }

    public void onStop() {
        synchronized (this.zzvM) {
            this.zzmu.stopLoading();
            zzab.zzaO().zza(this.zzmu.getWebView());
        }
    }

    public void zza(zzic com_google_android_gms_internal_zzic, boolean z) {
        boolean z2 = true;
        synchronized (this.zznh) {
            zzhx.zzY("WebView finished loading.");
            this.zzvz = true;
            if (z) {
                z2 = false;
            }
            this.zzsg = z2;
            this.zznh.notify();
        }
    }

    protected void zzf(long j) {
        while (zzd(j)) {
            if (this.zzsg) {
                throw new zzgb.zza("Received cancellation request from creative.", 0);
            } else if (this.zzvz) {
                return;
            }
        }
        throw new zzgb.zza("Timed out waiting for WebView to finish loading.", 2);
    }
}
