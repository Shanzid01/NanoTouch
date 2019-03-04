package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

class zzw implements zzak, com.google.android.gms.analytics.zzc.zzb, com.google.android.gms.analytics.zzc.zzc {
    private final Context mContext;
    private zzd zzBR;
    private final zzf zzBS;
    private boolean zzBV;
    private volatile long zzCh;
    private volatile zza zzCi;
    private volatile zzb zzCj;
    private zzd zzCk;
    private final GoogleAnalytics zzCl;
    private final Queue<zzd> zzCm;
    private volatile int zzCn;
    private volatile Timer zzCo;
    private volatile Timer zzCp;
    private volatile Timer zzCq;
    private boolean zzCr;
    private boolean zzCs;
    private boolean zzCt;
    private long zzCu;
    private zzlv zzmW;

    class C07931 implements Runnable {
        final /* synthetic */ zzw zzCv;

        C07931(zzw com_google_android_gms_analytics_zzw) {
            this.zzCv = com_google_android_gms_analytics_zzw;
        }

        public void run() {
            this.zzCv.zzfN();
        }
    }

    enum zza {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    class zzb extends TimerTask {
        final /* synthetic */ zzw zzCv;

        private zzb(zzw com_google_android_gms_analytics_zzw) {
            this.zzCv = com_google_android_gms_analytics_zzw;
        }

        public void run() {
            if (this.zzCv.zzCi == zza.CONNECTED_SERVICE && this.zzCv.zzCm.isEmpty() && this.zzCv.zzCh + this.zzCv.zzCu < this.zzCv.zzmW.elapsedRealtime()) {
                zzae.zzab("Disconnecting due to inactivity");
                this.zzCv.zzdJ();
                return;
            }
            this.zzCv.zzCq.schedule(new zzb(this.zzCv), this.zzCv.zzCu);
        }
    }

    class zzc extends TimerTask {
        final /* synthetic */ zzw zzCv;

        private zzc(zzw com_google_android_gms_analytics_zzw) {
            this.zzCv = com_google_android_gms_analytics_zzw;
        }

        public void run() {
            if (this.zzCv.zzCi == zza.CONNECTING) {
                this.zzCv.zzfP();
            }
        }
    }

    class zzd {
        private final Map<String, String> zzCF;
        private final long zzCG;
        private final String zzCH;
        private final List<zzik> zzCI;

        public zzd(Map<String, String> map, long j, String str, List<zzik> list) {
            this.zzCF = map;
            this.zzCG = j;
            this.zzCH = str;
            this.zzCI = list;
        }

        public String getPath() {
            return this.zzCH;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.zzCH);
            if (this.zzCF != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.zzCF.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }

        public Map<String, String> zzfS() {
            return this.zzCF;
        }

        public long zzfT() {
            return this.zzCG;
        }

        public List<zzik> zzfU() {
            return this.zzCI;
        }
    }

    class zze extends TimerTask {
        final /* synthetic */ zzw zzCv;

        private zze(zzw com_google_android_gms_analytics_zzw) {
            this.zzCv = com_google_android_gms_analytics_zzw;
        }

        public void run() {
            this.zzCv.zzfQ();
        }
    }

    zzw(Context context, zzf com_google_android_gms_analytics_zzf) {
        this(context, com_google_android_gms_analytics_zzf, null, GoogleAnalytics.getInstance(context));
    }

    zzw(Context context, zzf com_google_android_gms_analytics_zzf, zzd com_google_android_gms_analytics_zzd, GoogleAnalytics googleAnalytics) {
        this.zzCm = new ConcurrentLinkedQueue();
        this.zzCk = com_google_android_gms_analytics_zzd;
        this.mContext = context;
        this.zzBS = com_google_android_gms_analytics_zzf;
        this.zzCl = googleAnalytics;
        this.zzCn = 0;
        this.zzCi = zza.DISCONNECTED;
        if (zzG(context)) {
            this.zzCu = 10000;
        } else {
            this.zzCu = 300000;
        }
        this.zzmW = zzlx.zzkc();
    }

    private static boolean zzG(Context context) {
        return context != null && GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(context.getPackageName());
    }

    private Timer zza(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void zzdJ() {
        if (this.zzCj != null && this.zzCi == zza.CONNECTED_SERVICE) {
            this.zzCi = zza.PENDING_DISCONNECT;
            this.zzCj.disconnect();
        }
    }

    private void zzfL() {
        this.zzCo = zza(this.zzCo);
        this.zzCp = zza(this.zzCp);
        this.zzCq = zza(this.zzCq);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void zzfN() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r3 = r8.zzBS;	 Catch:{ all -> 0x0074 }
        r3 = r3.getThread();	 Catch:{ all -> 0x0074 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.zzBS;	 Catch:{ all -> 0x0074 }
        r2 = r2.zzfi();	 Catch:{ all -> 0x0074 }
        r3 = new com.google.android.gms.analytics.zzw$1;	 Catch:{ all -> 0x0074 }
        r3.<init>(r8);	 Catch:{ all -> 0x0074 }
        r2.add(r3);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.zzCr;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.zzfa();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r2 = com.google.android.gms.analytics.zzw.C07942.zzCw;	 Catch:{ all -> 0x0074 }
        r3 = r8.zzCi;	 Catch:{ all -> 0x0074 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0074 }
        r2 = r2[r3];	 Catch:{ all -> 0x0074 }
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x008a;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00e5;
            case 7: goto L_0x0077;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0082;
    L_0x003e:
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2 = r2.poll();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.zzw.zzd) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to store  ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.zzae.zzab(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.zzBR;	 Catch:{ all -> 0x0074 }
        r3 = r7.zzfS();	 Catch:{ all -> 0x0074 }
        r4 = r7.zzfT();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.zzfU();	 Catch:{ all -> 0x0074 }
        r2.zza(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0077:
        r2 = "Blocked. Dropping hits.";
        com.google.android.gms.analytics.zzae.zzab(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2.clear();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x0082:
        r2 = r8.zzBV;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x001f;
    L_0x0086:
        r8.zzfO();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x008a:
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00db;
    L_0x0092:
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2 = r2.peek();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.zzw.zzd) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to service   ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.zzae.zzab(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.zzCl;	 Catch:{ all -> 0x0074 }
        r2 = r2.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00d5;
    L_0x00ba:
        r2 = r8.zzCj;	 Catch:{ all -> 0x0074 }
        r3 = r7.zzfS();	 Catch:{ all -> 0x0074 }
        r4 = r7.zzfT();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.zzfU();	 Catch:{ all -> 0x0074 }
        r2.zza(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
    L_0x00cf:
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x008a;
    L_0x00d5:
        r2 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.zzae.zzab(r2);	 Catch:{ all -> 0x0074 }
        goto L_0x00cf;
    L_0x00db:
        r2 = r8.zzmW;	 Catch:{ all -> 0x0074 }
        r2 = r2.elapsedRealtime();	 Catch:{ all -> 0x0074 }
        r8.zzCh = r2;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00e5:
        r2 = "Need to reconnect";
        com.google.android.gms.analytics.zzae.zzab(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.zzCm;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x001f;
    L_0x00f2:
        r8.zzfQ();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzw.zzfN():void");
    }

    private void zzfO() {
        this.zzBR.dispatch();
        this.zzBV = false;
    }

    private synchronized void zzfP() {
        if (this.zzCi != zza.CONNECTED_LOCAL) {
            if (zzG(this.mContext)) {
                this.zzCi = zza.BLOCKED;
                this.zzCj.disconnect();
                zzae.zzac("Attempted to fall back to local store from service.");
            } else {
                zzfL();
                zzae.zzab("falling back to local store");
                if (this.zzCk != null) {
                    this.zzBR = this.zzCk;
                } else {
                    zzv zzfE = zzv.zzfE();
                    zzfE.zza(this.mContext, this.zzBS);
                    this.zzBR = zzfE.zzE(null);
                }
                this.zzCi = zza.CONNECTED_LOCAL;
                zzfN();
            }
        }
    }

    private synchronized void zzfQ() {
        if (this.zzCt || this.zzCj == null || this.zzCi == zza.CONNECTED_LOCAL) {
            zzae.zzac("client not initialized.");
            zzfP();
        } else {
            try {
                this.zzCn++;
                zza(this.zzCp);
                this.zzCi = zza.CONNECTING;
                this.zzCp = new Timer("Failed Connect");
                this.zzCp.schedule(new zzc(), 3000);
                zzae.zzab("connecting to Analytics service");
                this.zzCj.connect();
            } catch (SecurityException e) {
                zzae.zzac("security exception on connectToService");
                zzfP();
            }
        }
    }

    private void zzfR() {
        this.zzCo = zza(this.zzCo);
        this.zzCo = new Timer("Service Reconnect");
        this.zzCo.schedule(new zze(), 5000);
    }

    public void dispatch() {
        switch (this.zzCi) {
            case CONNECTED_LOCAL:
                zzfO();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.zzBV = true;
                return;
        }
    }

    public synchronized void onConnected() {
        this.zzCp = zza(this.zzCp);
        this.zzCn = 0;
        zzae.zzab("Connected to service");
        this.zzCi = zza.CONNECTED_SERVICE;
        if (this.zzCs) {
            zzdJ();
            this.zzCs = false;
        } else {
            zzfN();
            this.zzCq = zza(this.zzCq);
            this.zzCq = new Timer("disconnect check");
            this.zzCq.schedule(new zzb(), this.zzCu);
        }
    }

    public synchronized void onDisconnected() {
        if (this.zzCi == zza.BLOCKED) {
            zzae.zzab("Service blocked.");
            zzfL();
        } else if (this.zzCi == zza.PENDING_DISCONNECT) {
            zzae.zzab("Disconnected from service");
            zzfL();
            this.zzCi = zza.DISCONNECTED;
        } else {
            zzae.zzab("Unexpected disconnect.");
            this.zzCi = zza.PENDING_CONNECTION;
            if (this.zzCn < 2) {
                zzfR();
            } else {
                zzfP();
            }
        }
    }

    public synchronized void zza(int i, Intent intent) {
        this.zzCi = zza.PENDING_CONNECTION;
        if (this.zzCn < 2) {
            zzae.zzac("Service unavailable (code=" + i + "), will retry.");
            zzfR();
        } else {
            zzae.zzac("Service unavailable (code=" + i + "), using local store.");
            zzfP();
        }
    }

    public void zzb(Map<String, String> map, long j, String str, List<zzik> list) {
        zzae.zzab("putHit called");
        this.zzCm.add(new zzd(map, j, str, list));
        zzfN();
    }

    public void zzfM() {
        if (this.zzCj == null) {
            this.zzCj = new zzc(this.mContext, this, this);
            zzfQ();
        }
    }

    public void zzfa() {
        zzae.zzab("clearHits called");
        this.zzCm.clear();
        switch (this.zzCi) {
            case CONNECTED_LOCAL:
                this.zzBR.zzl(0);
                this.zzCr = false;
                return;
            case CONNECTED_SERVICE:
                this.zzCj.zzfa();
                this.zzCr = false;
                return;
            default:
                this.zzCr = true;
                return;
        }
    }

    public synchronized void zzfh() {
        if (!this.zzCt) {
            zzae.zzab("setForceLocalDispatch called.");
            this.zzCt = true;
            switch (this.zzCi) {
                case CONNECTED_LOCAL:
                case PENDING_CONNECTION:
                case PENDING_DISCONNECT:
                case DISCONNECTED:
                    break;
                case CONNECTED_SERVICE:
                    zzdJ();
                    break;
                case CONNECTING:
                    this.zzCs = true;
                    break;
                default:
                    break;
            }
        }
    }
}
