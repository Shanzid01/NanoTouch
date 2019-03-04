package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.zzan;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzra {
    private static volatile zzra zzarZ;
    private final Context mContext;
    private final List<zzrb> zzasa = new CopyOnWriteArrayList();
    private final zzqw zzasb = new zzqw();
    private final ScheduledExecutorService zzasc = Executors.newSingleThreadScheduledExecutor(new zza());
    private volatile zzrf zzasd;

    class C13161 implements Runnable {
        final /* synthetic */ zzqx zzase;
        final /* synthetic */ zzra zzasf;

        public void run() {
            this.zzase.zzqT().zzb(this.zzase);
            for (zzrb zzb : this.zzasf.zzasa) {
                zzb.zzb(this.zzase);
            }
            this.zzasf.zza(this.zzase);
        }
    }

    class zza implements ThreadFactory {
        private static final AtomicInteger zzasg = new AtomicInteger();

        private zza() {
        }

        public Thread newThread(Runnable runnable) {
            return new zzb(runnable, "measurement-" + zzasg.incrementAndGet());
        }
    }

    class zzb extends Thread {
        zzb(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzra(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzx.zzl(applicationContext);
        this.mContext = applicationContext;
    }

    private void zza(zzqx com_google_android_gms_internal_zzqx) {
        zzx.zzbe("deliver should be called from worker thread");
        zzx.zzb(com_google_android_gms_internal_zzqx.zzqS(), (Object) "Measurement must be submitted");
        List<zzrc> zzqR = com_google_android_gms_internal_zzqx.zzqR();
        if (!zzqR.isEmpty()) {
            Set hashSet = new HashSet();
            for (zzrc com_google_android_gms_internal_zzrc : zzqR) {
                Uri zzqP = com_google_android_gms_internal_zzrc.zzqP();
                if (!hashSet.contains(zzqP)) {
                    hashSet.add(zzqP);
                    com_google_android_gms_internal_zzrc.zza(com_google_android_gms_internal_zzqx);
                }
            }
        }
    }

    public static zzra zzaf(Context context) {
        zzx.zzl(context);
        if (zzarZ == null) {
            synchronized (zzra.class) {
                if (zzarZ == null) {
                    zzarZ = new zzra(context);
                }
            }
        }
        return zzarZ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public <V> Future<V> zza(Callable<V> callable) {
        zzx.zzl(callable);
        if (!(Thread.currentThread() instanceof zzb)) {
            return this.zzasc.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public zzrf zzqU() {
        if (this.zzasd == null) {
            synchronized (this) {
                if (this.zzasd == null) {
                    zzrf com_google_android_gms_internal_zzrf = new zzrf();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    com_google_android_gms_internal_zzrf.setAppId(packageName);
                    com_google_android_gms_internal_zzrf.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        Log.e("GA", "Error retrieving package info: appName set to " + packageName);
                    }
                    com_google_android_gms_internal_zzrf.setAppName(packageName);
                    com_google_android_gms_internal_zzrf.setAppVersion(str);
                    this.zzasd = com_google_android_gms_internal_zzrf;
                }
            }
        }
        return this.zzasd;
    }

    public zzrg zzqV() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zzrg com_google_android_gms_internal_zzrg = new zzrg();
        com_google_android_gms_internal_zzrg.setLanguage(zzan.zza(Locale.getDefault()));
        com_google_android_gms_internal_zzrg.zzgp(displayMetrics.widthPixels);
        com_google_android_gms_internal_zzrg.zzgq(displayMetrics.heightPixels);
        return com_google_android_gms_internal_zzrg;
    }
}
