package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzgc.zza;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgi
public class zzgg extends zzhl {
    private final Object zznh;
    private final zza zzvL;
    private final zzhe.zza zzvN;
    private final zzgq zzvO;
    private final zzgt zzvY;
    private Future<zzhe> zzvZ;

    public zzgg(Context context, zzt com_google_android_gms_internal_zzt, zzai com_google_android_gms_internal_zzai, zzhe.zza com_google_android_gms_internal_zzhe_zza, zza com_google_android_gms_internal_zzgc_zza) {
        this(com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzgc_zza, new zzgt(context, com_google_android_gms_internal_zzt, com_google_android_gms_internal_zzai, new zzht(), com_google_android_gms_internal_zzhe_zza));
    }

    zzgg(zzhe.zza com_google_android_gms_internal_zzhe_zza, zza com_google_android_gms_internal_zzgc_zza, zzgt com_google_android_gms_internal_zzgt) {
        this.zznh = new Object();
        this.zzvN = com_google_android_gms_internal_zzhe_zza;
        this.zzvO = com_google_android_gms_internal_zzhe_zza.zzyz;
        this.zzvL = com_google_android_gms_internal_zzgc_zza;
        this.zzvY = com_google_android_gms_internal_zzgt;
    }

    private zzhe zzu(int i) {
        return new zzhe(this.zzvN.zzyy.zzwn, null, null, i, null, null, this.zzvO.orientation, this.zzvO.zzsx, this.zzvN.zzyy.zzwq, false, null, null, null, null, null, this.zzvO.zzwJ, this.zzvN.zzlV, this.zzvO.zzwH, this.zzvN.zzyv, this.zzvO.zzwM, this.zzvO.zzwN, this.zzvN.zzys, null, this.zzvN.zzyy.zzwD);
    }

    public void onStop() {
        synchronized (this.zznh) {
            if (this.zzvZ != null) {
                this.zzvZ.cancel(true);
            }
        }
    }

    public void zzdw() {
        zzhe com_google_android_gms_internal_zzhe;
        int i;
        try {
            synchronized (this.zznh) {
                this.zzvZ = zzhn.submit(this.zzvY);
            }
            com_google_android_gms_internal_zzhe = (zzhe) this.zzvZ.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzhx.zzac("Timed out waiting for native ad.");
            i = 2;
            com_google_android_gms_internal_zzhe = null;
        } catch (ExecutionException e2) {
            i = 0;
            com_google_android_gms_internal_zzhe = null;
        } catch (InterruptedException e3) {
            com_google_android_gms_internal_zzhe = null;
            i = -1;
        } catch (CancellationException e4) {
            com_google_android_gms_internal_zzhe = null;
            i = -1;
        }
        if (com_google_android_gms_internal_zzhe == null) {
            com_google_android_gms_internal_zzhe = zzu(i);
        }
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzgg zzwa;

            public void run() {
                this.zzwa.zzvL.zza(com_google_android_gms_internal_zzhe);
            }
        });
    }
}
