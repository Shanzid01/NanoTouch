package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

@zzgi
public class zzaa {
    private final zza zzmF;
    private final Runnable zzmG;
    private zzax zzmH;
    private boolean zzmI;
    private boolean zzmJ;
    private long zzmK;

    public class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzaa(zzt com_google_android_gms_internal_zzt) {
        this(com_google_android_gms_internal_zzt, new zza(zzhw.zzzG));
    }

    zzaa(zzt com_google_android_gms_internal_zzt, zza com_google_android_gms_internal_zzaa_zza) {
        this.zzmI = false;
        this.zzmJ = false;
        this.zzmK = 0;
        this.zzmF = com_google_android_gms_internal_zzaa_zza;
        final WeakReference weakReference = new WeakReference(com_google_android_gms_internal_zzt);
        this.zzmG = new Runnable(this) {
            final /* synthetic */ zzaa zzmM;

            public void run() {
                this.zzmM.zzmI = false;
                zzt com_google_android_gms_internal_zzt = (zzt) weakReference.get();
                if (com_google_android_gms_internal_zzt != null) {
                    com_google_android_gms_internal_zzt.zzb(this.zzmM.zzmH);
                }
            }
        };
    }

    public void cancel() {
        this.zzmI = false;
        this.zzmF.removeCallbacks(this.zzmG);
    }

    public void pause() {
        this.zzmJ = true;
        if (this.zzmI) {
            this.zzmF.removeCallbacks(this.zzmG);
        }
    }

    public void resume() {
        this.zzmJ = false;
        if (this.zzmI) {
            this.zzmI = false;
            zza(this.zzmH, this.zzmK);
        }
    }

    public void zza(zzax com_google_android_gms_internal_zzax, long j) {
        if (this.zzmI) {
            zzhx.zzac("An ad refresh is already scheduled.");
            return;
        }
        this.zzmH = com_google_android_gms_internal_zzax;
        this.zzmI = true;
        this.zzmK = j;
        if (!this.zzmJ) {
            zzhx.zzaa("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzmF.postDelayed(this.zzmG, j);
        }
    }

    public boolean zzaG() {
        return this.zzmI;
    }

    public void zzc(zzax com_google_android_gms_internal_zzax) {
        zza(com_google_android_gms_internal_zzax, 60000);
    }
}
