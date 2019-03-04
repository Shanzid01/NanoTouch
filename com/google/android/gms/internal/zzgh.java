package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@zzgi
public class zzgh implements UncaughtExceptionHandler {
    private Context mContext;
    private UncaughtExceptionHandler zzwb;
    private UncaughtExceptionHandler zzwc;
    private zzhy zzwd;

    public zzgh(Context context, zzhy com_google_android_gms_internal_zzhy, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.zzwb = uncaughtExceptionHandler;
        this.zzwc = uncaughtExceptionHandler2;
        this.mContext = context;
        this.zzwd = com_google_android_gms_internal_zzhy;
    }

    public static zzgh zza(Context context, Thread thread, zzhy com_google_android_gms_internal_zzhy) {
        if (context == null || thread == null || com_google_android_gms_internal_zzhy == null) {
            return null;
        }
        if (!zzn(context)) {
            return null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        UncaughtExceptionHandler com_google_android_gms_internal_zzgh = new zzgh(context, com_google_android_gms_internal_zzhy, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof zzgh)) {
            return (zzgh) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(com_google_android_gms_internal_zzgh);
            return com_google_android_gms_internal_zzgh;
        } catch (Throwable e) {
            zzhx.zzc("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private Throwable zzd(Throwable th) {
        if (((Boolean) zzca.zzqp.get()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzO(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (zzP(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    private static boolean zzn(Context context) {
        return ((Boolean) zzca.zzqo.get()).booleanValue();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (zza(th)) {
            zzb(th);
            if (Looper.getMainLooper().getThread() != thread) {
                return;
            }
        }
        if (this.zzwb != null) {
            this.zzwb.uncaughtException(thread, th);
        } else if (this.zzwc != null) {
            this.zzwc.uncaughtException(thread, th);
        }
    }

    protected boolean zzO(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzgi.class);
        } catch (Throwable e) {
            zzhx.zza("Fail to check class type for class " + str, e);
            return z;
        }
    }

    protected boolean zzP(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    protected boolean zza(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (zzO(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    public void zzb(Throwable th) {
        if (zzn(this.mContext)) {
            Throwable zzd = zzd(th);
            if (zzd != null) {
                List arrayList = new ArrayList();
                arrayList.add(zzc(zzd));
                zzab.zzaM().zza(this.mContext, this.zzwd.zzzH, arrayList, zzab.zzaP().zzej());
            }
        }
    }

    protected String zzc(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", zzab.zzaM().zzev()).appendQueryParameter("js", this.zzwd.zzzH).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzca.zzcb())).toString();
    }
}
