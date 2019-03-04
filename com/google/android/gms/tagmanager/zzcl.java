package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzc.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcl implements zze {
    private boolean mClosed;
    private final Context mContext;
    private final ScheduledExecutorService zzasc;
    private String zzaxT;
    private final String zzaxw;
    private zzbe<zzj> zzazN;
    private zzr zzazO;
    private final zza zzazQ;
    private ScheduledFuture<?> zzazR;

    interface zzb {
        ScheduledExecutorService zztE();
    }

    class C14181 implements zzb {
        final /* synthetic */ zzcl zzazS;

        C14181(zzcl com_google_android_gms_tagmanager_zzcl) {
            this.zzazS = com_google_android_gms_tagmanager_zzcl;
        }

        public ScheduledExecutorService zztE() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    interface zza {
        zzck zza(zzr com_google_android_gms_tagmanager_zzr);
    }

    class C14192 implements zza {
        final /* synthetic */ zzcl zzazS;

        C14192(zzcl com_google_android_gms_tagmanager_zzcl) {
            this.zzazS = com_google_android_gms_tagmanager_zzcl;
        }

        public zzck zza(zzr com_google_android_gms_tagmanager_zzr) {
            return new zzck(this.zzazS.mContext, this.zzazS.zzaxw, com_google_android_gms_tagmanager_zzr);
        }
    }

    public zzcl(Context context, String str, zzr com_google_android_gms_tagmanager_zzr) {
        this(context, str, com_google_android_gms_tagmanager_zzr, null, null);
    }

    zzcl(Context context, String str, zzr com_google_android_gms_tagmanager_zzr, zzb com_google_android_gms_tagmanager_zzcl_zzb, zza com_google_android_gms_tagmanager_zzcl_zza) {
        this.zzazO = com_google_android_gms_tagmanager_zzr;
        this.mContext = context;
        this.zzaxw = str;
        if (com_google_android_gms_tagmanager_zzcl_zzb == null) {
            com_google_android_gms_tagmanager_zzcl_zzb = new C14181(this);
        }
        this.zzasc = com_google_android_gms_tagmanager_zzcl_zzb.zztE();
        if (com_google_android_gms_tagmanager_zzcl_zza == null) {
            this.zzazQ = new C14192(this);
        } else {
            this.zzazQ = com_google_android_gms_tagmanager_zzcl_zza;
        }
    }

    private zzck zzdh(String str) {
        zzck zza = this.zzazQ.zza(this.zzazO);
        zza.zza(this.zzazN);
        zza.zzcT(this.zzaxT);
        zza.zzdg(str);
        return zza;
    }

    private synchronized void zztD() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void release() {
        zztD();
        if (this.zzazR != null) {
            this.zzazR.cancel(false);
        }
        this.zzasc.shutdown();
        this.mClosed = true;
    }

    public synchronized void zza(zzbe<zzj> com_google_android_gms_tagmanager_zzbe_com_google_android_gms_internal_zzc_zzj) {
        zztD();
        this.zzazN = com_google_android_gms_tagmanager_zzbe_com_google_android_gms_internal_zzc_zzj;
    }

    public synchronized void zzcT(String str) {
        zztD();
        this.zzaxT = str;
    }

    public synchronized void zze(long j, String str) {
        zzbf.zzab("loadAfterDelay: containerId=" + this.zzaxw + " delay=" + j);
        zztD();
        if (this.zzazN == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzazR != null) {
            this.zzazR.cancel(false);
        }
        this.zzazR = this.zzasc.schedule(zzdh(str), j, TimeUnit.MILLISECONDS);
    }
}
