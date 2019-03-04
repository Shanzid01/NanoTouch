package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzct extends zzcs {
    private static final Object zzBQ = new Object();
    private static zzct zzaAF;
    private boolean connected = true;
    private Handler handler;
    private boolean zzaAA = false;
    private boolean zzaAB = true;
    private zzau zzaAC = new C14261(this);
    private zzbk zzaAD;
    private boolean zzaAE = false;
    private Context zzaAv;
    private zzat zzaAw;
    private volatile zzar zzaAx;
    private int zzaAy = 1800000;
    private boolean zzaAz = true;

    class C14261 implements zzau {
        final /* synthetic */ zzct zzaAG;

        C14261(zzct com_google_android_gms_tagmanager_zzct) {
            this.zzaAG = com_google_android_gms_tagmanager_zzct;
        }

        public void zzD(boolean z) {
            this.zzaAG.zzb(z, this.zzaAG.connected);
        }
    }

    class C14272 implements Callback {
        final /* synthetic */ zzct zzaAG;

        C14272(zzct com_google_android_gms_tagmanager_zzct) {
            this.zzaAG = com_google_android_gms_tagmanager_zzct;
        }

        public boolean handleMessage(Message message) {
            if (1 == message.what && zzct.zzBQ.equals(message.obj)) {
                this.zzaAG.dispatch();
                if (this.zzaAG.zzaAy > 0 && !this.zzaAG.zzaAE) {
                    this.zzaAG.handler.sendMessageDelayed(this.zzaAG.handler.obtainMessage(1, zzct.zzBQ), (long) this.zzaAG.zzaAy);
                }
            }
            return true;
        }
    }

    class C14283 implements Runnable {
        final /* synthetic */ zzct zzaAG;

        C14283(zzct com_google_android_gms_tagmanager_zzct) {
            this.zzaAG = com_google_android_gms_tagmanager_zzct;
        }

        public void run() {
            this.zzaAG.zzaAw.dispatch();
        }
    }

    private zzct() {
    }

    private void zzfF() {
        this.zzaAD = new zzbk(this);
        this.zzaAD.zzD(this.zzaAv);
    }

    private void zzfI() {
        this.handler = new Handler(this.zzaAv.getMainLooper(), new C14272(this));
        if (this.zzaAy > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzBQ), (long) this.zzaAy);
        }
    }

    public static zzct zztR() {
        if (zzaAF == null) {
            zzaAF = new zzct();
        }
        return zzaAF;
    }

    public synchronized void dispatch() {
        if (this.zzaAA) {
            this.zzaAx.zzc(new C14283(this));
        } else {
            zzbf.zzab("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzaAz = true;
        }
    }

    synchronized void zzE(boolean z) {
        zzb(this.zzaAE, z);
    }

    synchronized void zza(Context context, zzar com_google_android_gms_tagmanager_zzar) {
        if (this.zzaAv == null) {
            this.zzaAv = context.getApplicationContext();
            if (this.zzaAx == null) {
                this.zzaAx = com_google_android_gms_tagmanager_zzar;
            }
        }
    }

    synchronized void zzb(boolean z, boolean z2) {
        if (!(this.zzaAE == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.zzaAy > 0) {
                    this.handler.removeMessages(1, zzBQ);
                }
            }
            if (!z && z2 && this.zzaAy > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzBQ), (long) this.zzaAy);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            zzbf.zzab(append.append(str).toString());
            this.zzaAE = z;
            this.connected = z2;
        }
    }

    synchronized void zzfJ() {
        if (!this.zzaAE && this.connected && this.zzaAy > 0) {
            this.handler.removeMessages(1, zzBQ);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzBQ));
        }
    }

    synchronized zzat zztS() {
        if (this.zzaAw == null) {
            if (this.zzaAv == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzaAw = new zzbx(this.zzaAC, this.zzaAv);
        }
        if (this.handler == null) {
            zzfI();
        }
        this.zzaAA = true;
        if (this.zzaAz) {
            dispatch();
            this.zzaAz = false;
        }
        if (this.zzaAD == null && this.zzaAB) {
            zzfF();
        }
        return this.zzaAw;
    }
}
