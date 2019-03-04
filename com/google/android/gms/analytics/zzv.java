package com.google.android.gms.analytics;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.gms.analytics.zzy.zza;

class zzv extends zzaj {
    private static final Object zzBQ = new Object();
    private static zzv zzCf;
    private Context mContext;
    private Handler mHandler;
    private zzd zzBR;
    private volatile zzf zzBS;
    private int zzBT = 1800;
    private long zzBU = Long.MIN_VALUE;
    private boolean zzBV = true;
    private boolean zzBW;
    private String zzBX;
    private boolean zzBY = false;
    private boolean zzBZ = true;
    private boolean zzBs = false;
    private boolean zzCa = true;
    private zze zzCb = new C07911(this);
    private boolean zzCc;
    private zzu zzCd;
    private boolean zzCe = false;

    class C07911 implements zze {
        final /* synthetic */ zzv zzCg;

        C07911(zzv com_google_android_gms_analytics_zzv) {
            this.zzCg = com_google_android_gms_analytics_zzv;
        }

        public void zzD(boolean z) {
            this.zzCg.zzb(z, this.zzCg.zzBZ);
        }
    }

    class C07922 implements Callback {
        final /* synthetic */ zzv zzCg;

        C07922(zzv com_google_android_gms_analytics_zzv) {
            this.zzCg = com_google_android_gms_analytics_zzv;
        }

        public boolean handleMessage(Message message) {
            if (1 == message.what && zzv.zzBQ.equals(message.obj)) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime >= this.zzCg.zzBU + ((long) (this.zzCg.zzBT * 1000))) {
                    zzy.zzfV().zzF(true);
                    this.zzCg.dispatchLocalHits();
                    zzy.zzfV().zzF(false);
                    this.zzCg.zzBU = elapsedRealtime;
                }
                if (this.zzCg.zzBT > 0 && !this.zzCg.zzCe) {
                    this.zzCg.mHandler.sendMessageDelayed(this.zzCg.mHandler.obtainMessage(1, zzv.zzBQ), (long) (Math.min(60, this.zzCg.zzBT) * 1000));
                }
            }
            return true;
        }
    }

    private zzv() {
    }

    public static zzv zzfE() {
        if (zzCf == null) {
            zzCf = new zzv();
        }
        return zzCf;
    }

    private void zzfF() {
        this.zzCd = new zzu(this);
        this.zzCd.zzD(this.mContext);
    }

    private PendingIntent zzfG() {
        Intent intent = new Intent(this.mContext.getApplicationContext(), AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
    }

    private AlarmManager zzfH() {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getApplicationContext().getSystemService("alarm");
        alarmManager.cancel(zzfG());
        return alarmManager;
    }

    private void zzfI() {
        try {
            zzfH();
            ActivityInfo receiverInfo = this.mContext.getPackageManager().getReceiverInfo(new ComponentName(this.mContext, AnalyticsReceiver.class), 2);
            if (receiverInfo != null && receiverInfo.enabled && this.zzBT > 0) {
                zzh(this.zzBT, this.zzBT);
                zzae.zzab("Using a receiver for local dispatch.");
                this.zzCc = true;
                return;
            }
        } catch (NameNotFoundException e) {
        }
        zzae.zzab("Receiver for local dispatch not registered. For more reliable analytics, please see http://goo.gl/8Rd3yj for instructions.");
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C07922(this));
        if (this.zzBT > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, zzBQ), (long) (Math.min(60, this.zzBT) * 1000));
        }
    }

    private void zzh(int i, int i2) {
        if (!this.zzBY) {
            if (i < 1800) {
                i = 1800;
            }
            if (i2 < 1800) {
                i2 = 1800;
            }
        }
        zzfH().setInexactRepeating(2, (long) (i * 1000), (long) (i2 * 1000), zzfG());
    }

    synchronized void dispatchLocalHits() {
        zzF(null);
    }

    synchronized void setLocalDispatchPeriod(int i) {
        if (this.mHandler != null || this.zzCc) {
            zzy.zzfV().zza(zza.SET_DISPATCH_PERIOD);
            if (!this.zzCe && this.zzBZ && this.zzBT > 0) {
                if (this.mHandler != null) {
                    this.mHandler.removeMessages(1, zzBQ);
                }
                if (this.zzCc) {
                    zzfH();
                }
            }
            this.zzBT = i;
            AnalyticsService.zzC(i);
            if (i > 0 && !this.zzCe && this.zzBZ) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, zzBQ), (long) (Math.min(60, this.zzBT) * 1000));
                }
                if (this.zzCc) {
                    zzh(i, i);
                }
            }
        } else {
            zzae.zzab("Dispatch period set with null handler and no receiver. Dispatch will run once initialization is complete.");
            this.zzBT = i;
            AnalyticsService.zzC(i);
        }
    }

    synchronized zzd zzE(Context context) {
        if (context != null) {
            if (this.mContext == null) {
                this.mContext = context;
            }
        }
        if (this.zzBR == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzBR = new zzag(this.zzCb, this.mContext, new zzj());
            this.zzBR.setDryRun(this.zzBs);
            if (this.zzBX != null) {
                this.zzBR.zzff().zzak(this.zzBX);
                this.zzBX = null;
            }
        }
        if (this.mHandler == null && !this.zzCc) {
            zzfI();
        }
        if (this.zzCd == null && this.zzCa) {
            zzfF();
        }
        return this.zzBR;
    }

    synchronized void zzE(boolean z) {
        zzb(this.zzCe, z);
    }

    synchronized void zzF(Context context) {
        zzf com_google_android_gms_analytics_zzf = null;
        if (this.zzBS != null) {
            com_google_android_gms_analytics_zzf = this.zzBS;
        } else if (context != null) {
            com_google_android_gms_analytics_zzf = GoogleAnalytics.getInstance(context).zzgm();
        } else if (GoogleAnalytics.zzgj() != null) {
            com_google_android_gms_analytics_zzf = GoogleAnalytics.zzgj().zzgm();
        }
        if (com_google_android_gms_analytics_zzf == null) {
            zzae.zzab("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzBV = true;
        } else {
            zzy.zzfV().zza(zza.DISPATCH);
            com_google_android_gms_analytics_zzf.dispatch();
        }
    }

    synchronized void zza(Context context, zzf com_google_android_gms_analytics_zzf) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.zzBS == null) {
                this.zzBS = com_google_android_gms_analytics_zzf;
                if (this.zzBV) {
                    dispatchLocalHits();
                    this.zzBV = false;
                }
                if (this.zzBW) {
                    zzfh();
                    this.zzBW = false;
                }
            }
        }
    }

    synchronized void zzb(boolean z, boolean z2) {
        if (!(this.zzCe == z && this.zzBZ == z2)) {
            if (z || !z2) {
                if (this.zzBT > 0) {
                    if (this.mHandler != null) {
                        this.mHandler.removeMessages(1, zzBQ);
                    }
                    if (this.zzCc) {
                        zzfH();
                    }
                }
            }
            if (!z && z2 && this.zzBT > 0) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, zzBQ), (long) (Math.min(60, this.zzBT) * 1000));
                }
                if (this.zzCc) {
                    zzh(this.zzBT, this.zzBT);
                }
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            zzae.zzab(append.append(str).toString());
            this.zzCe = z;
            this.zzBZ = z2;
        }
    }

    synchronized void zzfJ() {
        if (!this.zzCe && this.zzBZ && this.zzBT > 0) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1, zzBQ);
                this.zzBU = Long.MIN_VALUE;
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, zzBQ));
            }
            if (this.zzCc) {
                zzh(0, this.zzBT);
            }
        }
    }

    void zzfh() {
        if (this.zzBS == null) {
            zzae.zzab("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.zzBW = true;
            return;
        }
        zzy.zzfV().zza(zza.SET_FORCE_LOCAL_DISPATCH);
        this.zzBS.zzfh();
    }
}
