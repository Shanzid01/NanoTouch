package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.io.IOException;

class zza {
    private static Object zzaxj = new Object();
    private static zza zzaxk;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile Info zzAO;
    private volatile long zzaxf;
    private volatile long zzaxg;
    private volatile long zzaxh;
    private zza zzaxi;
    private final zzlv zzmW;
    private final Thread zzzi;

    public interface zza {
        Info zzsC();
    }

    class C14131 implements zza {
        final /* synthetic */ zza zzaxl;

        C14131(zza com_google_android_gms_tagmanager_zza) {
            this.zzaxl = com_google_android_gms_tagmanager_zza;
        }

        public Info zzsC() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzaxl.mContext);
            } catch (IllegalStateException e) {
                zzbf.zzac("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                zzbf.zzac("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                zzbf.zzac("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                zzbf.zzac("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                zzbf.zzac("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    class C14142 implements Runnable {
        final /* synthetic */ zza zzaxl;

        C14142(zza com_google_android_gms_tagmanager_zza) {
            this.zzaxl = com_google_android_gms_tagmanager_zza;
        }

        public void run() {
            this.zzaxl.zzsA();
        }
    }

    private zza(Context context) {
        this(context, null, zzlx.zzkc());
    }

    zza(Context context, zza com_google_android_gms_tagmanager_zza_zza, zzlv com_google_android_gms_internal_zzlv) {
        this.zzaxf = 900000;
        this.zzaxg = 30000;
        this.mClosed = false;
        this.zzaxi = new C14131(this);
        this.zzmW = com_google_android_gms_internal_zzlv;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (com_google_android_gms_tagmanager_zza_zza != null) {
            this.zzaxi = com_google_android_gms_tagmanager_zza_zza;
        }
        this.zzzi = new Thread(new C14142(this));
    }

    static zza zzaj(Context context) {
        if (zzaxk == null) {
            synchronized (zzaxj) {
                if (zzaxk == null) {
                    zzaxk = new zza(context);
                    zzaxk.start();
                }
            }
        }
        return zzaxk;
    }

    private void zzsA() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.zzAO = this.zzaxi.zzsC();
                Thread.sleep(this.zzaxf);
            } catch (InterruptedException e) {
                zzbf.zzaa("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void zzsB() {
        if (this.zzmW.currentTimeMillis() - this.zzaxh >= this.zzaxg) {
            interrupt();
            this.zzaxh = this.zzmW.currentTimeMillis();
        }
    }

    void interrupt() {
        this.zzzi.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        zzsB();
        return this.zzAO == null ? true : this.zzAO.isLimitAdTrackingEnabled();
    }

    void start() {
        this.zzzi.start();
    }

    public String zzsz() {
        zzsB();
        return this.zzAO == null ? null : this.zzAO.getId();
    }
}
