package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzgi
public abstract class zzgb extends zzhl {
    protected final Context mContext;
    protected final zzic zzmu;
    protected final Object zznh = new Object();
    protected final com.google.android.gms.internal.zzgc.zza zzvL;
    protected final Object zzvM = new Object();
    protected final com.google.android.gms.internal.zzhe.zza zzvN;
    protected zzgq zzvO;

    class C12071 implements Runnable {
        final /* synthetic */ zzgb zzvP;

        C12071(zzgb com_google_android_gms_internal_zzgb) {
            this.zzvP = com_google_android_gms_internal_zzgb;
        }

        public void run() {
            this.zzvP.onStop();
        }
    }

    public final class zza extends Exception {
        private final int zzvR;

        public zza(String str, int i) {
            super(str);
            this.zzvR = i;
        }

        public int getErrorCode() {
            return this.zzvR;
        }
    }

    protected zzgb(Context context, com.google.android.gms.internal.zzhe.zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic, com.google.android.gms.internal.zzgc.zza com_google_android_gms_internal_zzgc_zza) {
        this.mContext = context;
        this.zzvN = com_google_android_gms_internal_zzhe_zza;
        this.zzvO = com_google_android_gms_internal_zzhe_zza.zzyz;
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zzvL = com_google_android_gms_internal_zzgc_zza;
    }

    public void onStop() {
    }

    public void zzdw() {
        int errorCode;
        synchronized (this.zznh) {
            zzhx.zzY("AdRendererBackgroundTask started.");
            int i = this.zzvN.errorCode;
            try {
                zzg(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzhx.zzaa(e.getMessage());
                } else {
                    zzhx.zzac(e.getMessage());
                }
                if (this.zzvO == null) {
                    this.zzvO = new zzgq(errorCode);
                } else {
                    this.zzvO = new zzgq(errorCode, this.zzvO.zzsx);
                }
                zzhw.zzzG.post(new C12071(this));
                i = errorCode;
            }
            final zzhe zzt = zzt(i);
            zzhw.zzzG.post(new Runnable(this) {
                final /* synthetic */ zzgb zzvP;

                public void run() {
                    synchronized (this.zzvP.zznh) {
                        this.zzvP.zzh(zzt);
                    }
                }
            });
        }
    }

    protected abstract void zzg(long j);

    protected void zzh(zzhe com_google_android_gms_internal_zzhe) {
        this.zzvL.zza(com_google_android_gms_internal_zzhe);
    }

    protected zzhe zzt(int i) {
        zzgo com_google_android_gms_internal_zzgo = this.zzvN.zzyy;
        return new zzhe(com_google_android_gms_internal_zzgo.zzwn, this.zzmu, this.zzvO.zzst, i, this.zzvO.zzsu, this.zzvO.zzwK, this.zzvO.orientation, this.zzvO.zzsx, com_google_android_gms_internal_zzgo.zzwq, this.zzvO.zzwI, null, null, null, null, null, this.zzvO.zzwJ, this.zzvN.zzlV, this.zzvO.zzwH, this.zzvN.zzyv, this.zzvO.zzwM, this.zzvO.zzwN, this.zzvN.zzys, null, com_google_android_gms_internal_zzgo.zzwD);
    }
}
