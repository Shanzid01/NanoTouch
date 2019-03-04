package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzgi
class zzw implements zzg, Runnable {
    private zzb zzlE;
    private final List<Object[]> zzmv = new Vector();
    private final AtomicReference<zzg> zzmw = new AtomicReference();
    CountDownLatch zzmx = new CountDownLatch(1);

    public zzw(zzb com_google_android_gms_internal_zzt_zzb) {
        this.zzlE = com_google_android_gms_internal_zzt_zzb;
        if (zzbe.zzbD().zzeC()) {
            zzhn.zzb(this);
        } else {
            run();
        }
    }

    private void zzaD() {
        if (!this.zzmv.isEmpty()) {
            for (Object[] objArr : this.zzmv) {
                if (objArr.length == 1) {
                    ((zzg) this.zzmw.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzg) this.zzmw.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzmv.clear();
        }
    }

    private Context zzi(Context context) {
        if (!((Boolean) zzca.zzqu.get()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public void run() {
        try {
            zza(zzj.zza(this.zzlE.zzlP.zzzH, zzi(this.zzlE.zzlN)));
        } finally {
            this.zzmx.countDown();
            this.zzlE = null;
        }
    }

    public String zza(Context context) {
        if (zzaC()) {
            zzg com_google_android_gms_internal_zzg = (zzg) this.zzmw.get();
            if (com_google_android_gms_internal_zzg != null) {
                zzaD();
                return com_google_android_gms_internal_zzg.zza(zzi(context));
            }
        }
        return "";
    }

    public String zza(Context context, String str) {
        if (zzaC()) {
            zzg com_google_android_gms_internal_zzg = (zzg) this.zzmw.get();
            if (com_google_android_gms_internal_zzg != null) {
                zzaD();
                return com_google_android_gms_internal_zzg.zza(zzi(context), str);
            }
        }
        return "";
    }

    public void zza(int i, int i2, int i3) {
        zzg com_google_android_gms_internal_zzg = (zzg) this.zzmw.get();
        if (com_google_android_gms_internal_zzg != null) {
            zzaD();
            com_google_android_gms_internal_zzg.zza(i, i2, i3);
            return;
        }
        this.zzmv.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzg com_google_android_gms_internal_zzg = (zzg) this.zzmw.get();
        if (com_google_android_gms_internal_zzg != null) {
            zzaD();
            com_google_android_gms_internal_zzg.zza(motionEvent);
            return;
        }
        this.zzmv.add(new Object[]{motionEvent});
    }

    protected void zza(zzg com_google_android_gms_internal_zzg) {
        this.zzmw.set(com_google_android_gms_internal_zzg);
    }

    protected boolean zzaC() {
        try {
            this.zzmx.await();
            return true;
        } catch (Throwable e) {
            zzhx.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
