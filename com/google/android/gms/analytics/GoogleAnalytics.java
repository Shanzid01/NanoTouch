package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzra;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static volatile GoogleAnalytics zzEl;
    private static List<Runnable> zzEm;
    private static boolean zzEv;
    private final Context mContext;
    private final zzra zzAM;
    private final zzk zzAN;
    private final zzf zzBS;
    private String zzBa;
    private String zzBb;
    private boolean zzBs;
    private final zzy zzEn;
    private final zzaj zzEo;
    private final zzai zzEp;
    private final zzg zzEq;
    private final zza zzEr;
    private Set<zza> zzEs;
    private boolean zzEt;
    private volatile boolean zzEu;

    interface zza {
        void zzn(Activity activity);

        void zzo(Activity activity);
    }

    class zzb implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics zzEw;

        zzb(GoogleAnalytics googleAnalytics) {
            this.zzEw = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.zzEw.zzl(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.zzEw.zzm(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, null, zzv.zzfE(), null);
    }

    protected GoogleAnalytics(Context context, zzf com_google_android_gms_analytics_zzf, zzaj com_google_android_gms_analytics_zzaj, zzak com_google_android_gms_analytics_zzak) {
        zzx.zzl(context);
        Context applicationContext = context.getApplicationContext();
        zzx.zzl(applicationContext);
        zzx.zzl(com_google_android_gms_analytics_zzaj);
        this.zzEn = zzy.zzfV();
        this.mContext = applicationContext;
        this.zzAM = zzra.zzaf(applicationContext);
        zzx.zzl(this.zzAM);
        this.zzEo = com_google_android_gms_analytics_zzaj;
        if (com_google_android_gms_analytics_zzf != null) {
            this.zzBS = com_google_android_gms_analytics_zzf;
        } else {
            this.zzBS = new zzx(this, com_google_android_gms_analytics_zzak);
        }
        this.zzAN = new zzk(this.zzAM);
        this.zzEq = new zzg(this.zzAM);
        this.zzEp = new zzai(this.zzAM);
        this.zzEr = new zza(this.zzAM, this.zzAN);
        this.zzEs = new HashSet();
        zzgk();
    }

    public static GoogleAnalytics getInstance(Context context) {
        zzx.zzl(context);
        if (zzEl == null) {
            synchronized (GoogleAnalytics.class) {
                if (zzEl == null) {
                    zzEl = new GoogleAnalytics(context);
                    if (zzEm != null) {
                        for (Runnable run : zzEm) {
                            run.run();
                        }
                        zzEm = null;
                    }
                }
            }
        }
        return zzEl;
    }

    private Tracker zza(Tracker tracker) {
        if (this.zzBa != null) {
            tracker.set("&an", this.zzBa);
        }
        if (this.zzBb != null) {
            tracker.set("&av", this.zzBb);
        }
        return tracker;
    }

    private int zzao(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    static GoogleAnalytics zzgj() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = zzEl;
        }
        return googleAnalytics;
    }

    private void zzgk() {
        if (!zzEv) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                zzae.zzab("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                zzae.zzac("Couldn't get ApplicationInfo to load global config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    zzaa com_google_android_gms_analytics_zzaa = (zzaa) new zzz(this.mContext).zzD(i);
                    if (com_google_android_gms_analytics_zzaa != null) {
                        zza(com_google_android_gms_analytics_zzaa);
                    }
                }
            }
        }
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.zzEo.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.zzEt) {
            application.registerActivityLifecycleCallbacks(new zzb(this));
            this.zzEt = true;
        }
    }

    public boolean getAppOptOut() {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_APP_OPT_OUT);
        return this.zzEu;
    }

    public String getClientId() {
        return this.zzAN.getValue("&cid");
    }

    public Context getContext() {
        return this.mContext;
    }

    public Logger getLogger() {
        return zzae.getLogger();
    }

    public boolean isDryRunEnabled() {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_DRY_RUN);
        return this.zzBs;
    }

    public Tracker newTracker(int i) {
        Tracker zza;
        synchronized (this) {
            this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_TRACKER);
            Tracker tracker = new Tracker(this, null, null, null);
            if (i > 0) {
                zzam com_google_android_gms_analytics_zzam = (zzam) new zzal(this.mContext).zzD(i);
                if (com_google_android_gms_analytics_zzam != null) {
                    tracker.zza(com_google_android_gms_analytics_zzam);
                }
            }
            zza = zza(tracker);
        }
        return zza;
    }

    public Tracker newTracker(String str) {
        Tracker zza;
        synchronized (this) {
            this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.GET_TRACKER);
            zza = zza(new Tracker(this, str, null, null));
        }
        return zza;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.zzEt) {
            zzl(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.zzEt) {
            zzm(activity);
        }
    }

    public void setAppOptOut(boolean z) {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.SET_APP_OPT_OUT);
        this.zzEu = z;
        if (this.zzEu) {
            this.zzBS.zzfa();
        }
    }

    public void setDryRun(boolean z) {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.SET_DRY_RUN);
        this.zzBs = z;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int i) {
        this.zzEo.setLocalDispatchPeriod(i);
    }

    public void setLogger(Logger logger) {
        this.zzEn.zza(com.google.android.gms.analytics.zzy.zza.SET_LOGGER);
        zzae.setLogger(logger);
    }

    void zza(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.zzEs.add(com_google_android_gms_analytics_GoogleAnalytics_zza);
        if (this.mContext instanceof Application) {
            enableAutoActivityReports((Application) this.mContext);
        }
    }

    void zza(zzaa com_google_android_gms_analytics_zzaa) {
        zzae.zzab("Loading global config values.");
        if (com_google_android_gms_analytics_zzaa.zzfZ()) {
            this.zzBa = com_google_android_gms_analytics_zzaa.zzga();
            zzae.zzab("app name loaded: " + this.zzBa);
        }
        if (com_google_android_gms_analytics_zzaa.zzgb()) {
            this.zzBb = com_google_android_gms_analytics_zzaa.zzgc();
            zzae.zzab("app version loaded: " + this.zzBb);
        }
        if (com_google_android_gms_analytics_zzaa.zzgd()) {
            int zzao = zzao(com_google_android_gms_analytics_zzaa.zzge());
            if (zzao >= 0) {
                zzae.zzab("log level loaded: " + zzao);
                getLogger().setLogLevel(zzao);
            }
        }
        if (com_google_android_gms_analytics_zzaa.zzgf()) {
            this.zzEo.setLocalDispatchPeriod(com_google_android_gms_analytics_zzaa.zzgg());
        }
        if (com_google_android_gms_analytics_zzaa.zzgh()) {
            setDryRun(com_google_android_gms_analytics_zzaa.zzgi());
        }
    }

    void zzb(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.zzEs.remove(com_google_android_gms_analytics_GoogleAnalytics_zza);
    }

    void zzfj() {
        this.zzBS.zzfj();
    }

    zzd zzgl() {
        return this.zzEo.zzE(this.mContext);
    }

    zzf zzgm() {
        return this.zzBS;
    }

    public zzai zzgn() {
        return this.zzEp;
    }

    public zzg zzgo() {
        return this.zzEq;
    }

    public zzk zzgp() {
        return this.zzAN;
    }

    public zza zzgq() {
        return this.zzEr;
    }

    void zzl(Activity activity) {
        for (zza zzn : this.zzEs) {
            zzn.zzn(activity);
        }
    }

    void zzm(Activity activity) {
        for (zza zzo : this.zzEs) {
            zzo.zzo(activity);
        }
    }

    void zzx(Map<String, String> map) {
        zzx.zzl(map);
        synchronized (this) {
            zzan.zza((Map) map, "&ul", zzan.zza(Locale.getDefault()));
            zzan.zza((Map) map, "&sr", this.zzEp);
            map.put("&_u", this.zzEn.zzfX());
            this.zzEn.zzfW();
            this.zzBS.zzx(map);
        }
    }
}
