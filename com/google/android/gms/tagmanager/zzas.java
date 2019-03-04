package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzas extends Thread implements zzar {
    private static zzas zzayL;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean zzCK = false;
    private final LinkedBlockingQueue<Runnable> zzayK = new LinkedBlockingQueue();
    private volatile zzat zzayM;

    private zzas(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzas zzam(Context context) {
        if (zzayL == null) {
            zzayL = new zzas(context);
        }
        return zzayL;
    }

    private String zzf(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zzayK.take();
                if (!this.zzCK) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzbf.zzaa(e.toString());
            } catch (Throwable th) {
                zzbf.zzZ("Error on Google TagManager Thread: " + zzf(th));
                zzbf.zzZ("Google TagManager is shutting down.");
                this.zzCK = true;
            }
        }
    }

    public void zzc(Runnable runnable) {
        this.zzayK.add(runnable);
    }

    void zzd(String str, long j) {
        final zzas com_google_android_gms_tagmanager_zzas = this;
        final long j2 = j;
        final String str2 = str;
        zzc(new Runnable(this) {
            final /* synthetic */ zzas zzayP;

            public void run() {
                if (this.zzayP.zzayM == null) {
                    zzct zztR = zzct.zztR();
                    zztR.zza(this.zzayP.mContext, com_google_android_gms_tagmanager_zzas);
                    this.zzayP.zzayM = zztR.zztS();
                }
                this.zzayP.zzayM.zzf(j2, str2);
            }
        });
    }

    public void zzdb(String str) {
        zzd(str, System.currentTimeMillis());
    }
}
