package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzjs extends zzjt {
    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    protected final long zzKa;
    protected final Runnable zzKb = new zza();
    protected boolean zzKc;

    class zza implements Runnable {
        final /* synthetic */ zzjs zzKd;

        private zza(zzjs com_google_android_gms_internal_zzjs) {
            this.zzKd = com_google_android_gms_internal_zzjs;
        }

        public void run() {
            this.zzKd.zzKc = false;
            this.zzKd.zzK(this.zzKd.zzo(SystemClock.elapsedRealtime()));
        }
    }

    public zzjs(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.zzKa = j;
        zzK(false);
    }

    protected final void zzK(boolean z) {
        if (this.zzKc != z) {
            this.zzKc = z;
            if (z) {
                this.mHandler.postDelayed(this.zzKb, this.zzKa);
            } else {
                this.mHandler.removeCallbacks(this.zzKb);
            }
        }
    }

    public void zzhm() {
        zzK(false);
    }

    protected abstract boolean zzo(long j);
}
