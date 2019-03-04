package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzan extends Thread {
    private boolean mStarted = false;
    private final int zznW;
    private final int zznY;
    private final Object zznh;
    private boolean zzoj = false;
    private boolean zzok = false;
    private final zzam zzol;
    private final zzal zzom;
    private final zzgh zzon;
    private final int zzoo;
    private final int zzop;
    private final int zzoq;

    @zzgi
    class zza {
        final /* synthetic */ zzan zzos;
        final int zzox;
        final int zzoy;

        zza(zzan com_google_android_gms_internal_zzan, int i, int i2) {
            this.zzos = com_google_android_gms_internal_zzan;
            this.zzox = i;
            this.zzoy = i2;
        }
    }

    public zzan(zzam com_google_android_gms_internal_zzam, zzal com_google_android_gms_internal_zzal, zzgh com_google_android_gms_internal_zzgh) {
        this.zzol = com_google_android_gms_internal_zzam;
        this.zzom = com_google_android_gms_internal_zzal;
        this.zzon = com_google_android_gms_internal_zzgh;
        this.zznh = new Object();
        this.zznW = ((Integer) zzca.zzqC.get()).intValue();
        this.zzop = ((Integer) zzca.zzqD.get()).intValue();
        this.zznY = ((Integer) zzca.zzqE.get()).intValue();
        this.zzoq = ((Integer) zzca.zzqF.get()).intValue();
        this.zzoo = ((Integer) zzca.zzqG.get()).intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzok) {
            try {
                if (zzbu()) {
                    Activity activity = this.zzol.getActivity();
                    if (activity == null) {
                        zzhx.zzY("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzhx.zzY("ContentFetchTask: sleeping");
                    zzbw();
                }
                Thread.sleep((long) (this.zzoo * 1000));
            } catch (Throwable th) {
                zzhx.zzb("Error in ContentFetchTask", th);
                this.zzon.zzb(th);
            }
            synchronized (this.zznh) {
                while (this.zzoj) {
                    try {
                        zzhx.zzY("ContentFetchTask: waiting");
                        this.zznh.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zznh) {
            this.zzoj = false;
            this.zznh.notifyAll();
            zzhx.zzY("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzak com_google_android_gms_internal_zzak) {
        int i = 0;
        if (view == null) {
            return new zza(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(this, 0, 0);
            }
            com_google_android_gms_internal_zzak.zzi(text.toString());
            return new zza(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzic)) {
            com_google_android_gms_internal_zzak.zzbp();
            return zza((WebView) view, com_google_android_gms_internal_zzak) ? new zza(this, 0, 1) : new zza(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                zza zza = zza(viewGroup.getChildAt(i), com_google_android_gms_internal_zzak);
                i3 += zza.zzox;
                i2 += zza.zzoy;
                i++;
            }
            return new zza(this, i3, i2);
        }
    }

    void zza(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                zzf(view);
            }
        }
    }

    void zza(zzak com_google_android_gms_internal_zzak, WebView webView, String str) {
        com_google_android_gms_internal_zzak.zzbo();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    com_google_android_gms_internal_zzak.zzh(optString);
                } else {
                    com_google_android_gms_internal_zzak.zzh(webView.getTitle() + "\n" + optString);
                }
            }
            if (com_google_android_gms_internal_zzak.zzbl()) {
                this.zzom.zzb(com_google_android_gms_internal_zzak);
            }
        } catch (JSONException e) {
            zzhx.zzY("Json string may be malformed.");
        } catch (Throwable th) {
            zzhx.zza("Failed to get webview content.", th);
            this.zzon.zzb(th);
        }
    }

    boolean zza(final WebView webView, final zzak com_google_android_gms_internal_zzak) {
        if (!zzme.zzkj()) {
            return false;
        }
        com_google_android_gms_internal_zzak.zzbp();
        webView.post(new Runnable(this) {
            final /* synthetic */ zzan zzos;
            ValueCallback<String> zzot = new C11571(this);

            class C11571 implements ValueCallback<String> {
                final /* synthetic */ C11582 zzow;

                C11571(C11582 c11582) {
                    this.zzow = c11582;
                }

                public /* synthetic */ void onReceiveValue(Object obj) {
                    zzk((String) obj);
                }

                public void zzk(String str) {
                    this.zzow.zzos.zza(com_google_android_gms_internal_zzak, webView, str);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzot);
                    } catch (Throwable th) {
                        this.zzot.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzbt() {
        synchronized (this.zznh) {
            if (this.mStarted) {
                zzhx.zzY("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    boolean zzbu() {
        try {
            Context context = this.zzol.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && zzk(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzak zzbv() {
        return this.zzom.zzbs();
    }

    public void zzbw() {
        synchronized (this.zznh) {
            this.zzoj = true;
            zzhx.zzY("ContentFetchThread: paused, mPause = " + this.zzoj);
        }
    }

    public boolean zzbx() {
        return this.zzoj;
    }

    boolean zzf(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ zzan zzos;

            public void run() {
                this.zzos.zzg(view);
            }
        });
        return true;
    }

    void zzg(View view) {
        try {
            zzak com_google_android_gms_internal_zzak = new zzak(this.zznW, this.zzop, this.zznY, this.zzoq);
            zza zza = zza(view, com_google_android_gms_internal_zzak);
            com_google_android_gms_internal_zzak.zzbq();
            if (zza.zzox != 0 || zza.zzoy != 0) {
                if (zza.zzoy != 0 || com_google_android_gms_internal_zzak.zzbr() != 0) {
                    if (zza.zzoy != 0 || !this.zzom.zza(com_google_android_gms_internal_zzak)) {
                        this.zzom.zzc(com_google_android_gms_internal_zzak);
                    }
                }
            }
        } catch (Throwable e) {
            zzhx.zzb("Exception in fetchContentOnUIThread", e);
            this.zzon.zzb(e);
        }
    }

    boolean zzk(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }
}
