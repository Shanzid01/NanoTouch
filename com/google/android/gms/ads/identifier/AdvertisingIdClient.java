package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzs;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzln;
    zzs zzlo;
    boolean zzlp;
    Object zzlq;
    zza zzlr;
    final long zzls;

    public final class Info {
        private final String zzlx;
        private final boolean zzly;

        public Info(String str, boolean z) {
            this.zzlx = str;
            this.zzly = z;
        }

        public String getId() {
            return this.zzlx;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzly;
        }

        public String toString() {
            return "{" + this.zzlx + "}" + this.zzly;
        }
    }

    class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzlt;
        private long zzlu;
        CountDownLatch zzlv = new CountDownLatch(1);
        boolean zzlw = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzlt = new WeakReference(advertisingIdClient);
            this.zzlu = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzlt.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzlw = true;
            }
        }

        public void cancel() {
            this.zzlv.countDown();
        }

        public void run() {
            try {
                if (!this.zzlv.await(this.zzlu, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaa() {
            return this.zzlw;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzlq = new Object();
        zzx.zzl(context);
        this.mContext = context;
        this.zzlp = false;
        this.zzls = j;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    private void zzZ() {
        synchronized (this.zzlq) {
            if (this.zzlr != null) {
                this.zzlr.cancel();
                try {
                    this.zzlr.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzls > 0) {
                this.zzlr = new zza(this, this.zzls);
            }
        }
    }

    static zzs zza(Context context, com.google.android.gms.common.zza com_google_android_gms_common_zza) {
        try {
            return com.google.android.gms.internal.zzs.zza.zzb(com_google_android_gms_common_zza.zzhJ());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        }
    }

    static com.google.android.gms.common.zza zzh(Context context) {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.zzI(context);
                ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (zzlo.zzka().zza(context, intent, com_google_android_gms_common_zza, 1)) {
                    return com_google_android_gms_common_zza;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzx.zzbe(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzln;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzlp;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.internal.zzlo.zzka();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.zzln;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzlp = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzlo = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzln = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() {
        Info info;
        zzx.zzbe("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzlp) {
                synchronized (this.zzlq) {
                    if (this.zzlr == null || !this.zzlr.zzaa()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzlp) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzl(this.zzln);
            zzx.zzl(this.zzlo);
            info = new Info(this.zzlo.getId(), this.zzlo.zzc(true));
        }
        zzZ();
        return info;
    }

    public void start() {
        zzb(true);
    }

    protected void zzb(boolean z) {
        zzx.zzbe("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzlp) {
                finish();
            }
            this.zzln = zzh(this.mContext);
            this.zzlo = zza(this.mContext, this.zzln);
            this.zzlp = true;
            if (z) {
                zzZ();
            }
        }
    }
}
