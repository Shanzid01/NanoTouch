package com.p019a.p020a.p023c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.AppEventsConstants;
import com.p019a.p020a.p023c.p024a.p025a.C0383d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0220t;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p018g.C0311p;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class C0413z implements UncaughtExceptionHandler {
    static final FilenameFilter f1376a = new aa();
    static final Comparator<File> f1377b = new ai();
    static final Comparator<File> f1378c = new aj();
    static final FilenameFilter f1379d = new ak();
    private static final Pattern f1380e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> f1381f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private final AtomicInteger f1382g = new AtomicInteger(0);
    private final AtomicBoolean f1383h = new AtomicBoolean(false);
    private final UncaughtExceptionHandler f1384i;
    private final File f1385j;
    private final AtomicBoolean f1386k;
    private final BroadcastReceiver f1387l;
    private final BroadcastReceiver f1388m;
    private final C0407t f1389n;
    private final C0226z f1390o;
    private boolean f1391p;
    private final C0395h f1392q;
    private final az f1393r;
    private final bz f1394s;

    C0413z(UncaughtExceptionHandler uncaughtExceptionHandler, C0410w c0410w, C0407t c0407t, C0226z c0226z, bz bzVar, C0395h c0395h) {
        this.f1384i = uncaughtExceptionHandler;
        this.f1389n = c0407t;
        this.f1390o = c0226z;
        this.f1392q = c0395h;
        this.f1394s = bzVar;
        this.f1386k = new AtomicBoolean(false);
        this.f1385j = c0395h.m2800u();
        this.f1393r = new az(c0395h.m2334B(), this.f1385j);
        m2835a(c0410w);
        this.f1388m = new al(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        this.f1387l = new am(this);
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        Context B = c0395h.m2334B();
        B.registerReceiver(this.f1388m, intentFilter);
        B.registerReceiver(this.f1387l, intentFilter2);
        this.f1383h.set(true);
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f1386k.set(true);
        try {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            if (!this.f1383h.getAndSet(true)) {
                C0326f.m2298h().mo511a("CrashlyticsCore", "Unregistering power receivers.");
                Context B = this.f1392q.m2334B();
                B.unregisterReceiver(this.f1388m);
                B.unregisterReceiver(this.f1387l);
            }
            this.f1389n.m2817a(new an(this, new Date(), thread, th));
            C0326f.m2298h().mo511a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f1384i.uncaughtException(thread, th);
            this.f1386k.set(false);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
            C0326f.m2298h().mo511a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f1384i.uncaughtException(thread, th);
            this.f1386k.set(false);
        } catch (Throwable th2) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f1384i.uncaughtException(thread, th);
            this.f1386k.set(false);
        }
    }

    private void m2842a(Date date, Thread thread, Throwable th) {
        m2850b(date, thread, th);
        m2879d();
        m2867l();
        m2881f();
        if (!this.f1392q.m2801v()) {
            m2870o();
        }
    }

    boolean m2876a() {
        return this.f1386k.get();
    }

    private void m2835a(C0410w c0410w) {
        C0326f.m2298h().mo511a("CrashlyticsCore", "Checking for previous crash marker.");
        File file = new File(this.f1392q.m2800u(), "crash_marker");
        if (file.exists()) {
            file.delete();
            if (c0410w != null) {
                try {
                    c0410w.m2820a();
                } catch (Throwable e) {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
                }
            }
        }
    }

    void m2871a(long j, String str) {
        this.f1389n.m2819b(new ao(this, j, str));
    }

    void m2873a(Thread thread, Throwable th) {
        this.f1389n.m2818a(new ap(this, new Date(), thread, th));
    }

    private void m2850b(Date date, Thread thread, Throwable th) {
        Closeable c0391d;
        Throwable e;
        Flushable flushable = null;
        try {
            Closeable closeable;
            new File(this.f1385j, "crash_marker").createNewFile();
            String j = m2865j();
            if (j != null) {
                C0395h.m2770e(j);
                c0391d = new C0391d(this.f1385j, j + "SessionCrash");
                try {
                    flushable = C0393f.m2709a((OutputStream) c0391d);
                    m2833a(flushable, date, thread, th, "crash", true);
                    closeable = c0391d;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        ax.m2571a(e, (OutputStream) c0391d);
                        C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                        C0214m.m1913a(c0391d, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        e = th2;
                        C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                        C0214m.m1913a(c0391d, "Failed to close fatal exception file output stream.");
                        throw e;
                    }
                }
            }
            C0326f.m2298h().mo519e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
            closeable = null;
            C0214m.m1914a(flushable, "Failed to flush to session begin file.");
            C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            e = e3;
            c0391d = null;
            C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            ax.m2571a(e, (OutputStream) c0391d);
            C0214m.m1914a(flushable, "Failed to flush to session begin file.");
            C0214m.m1913a(c0391d, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            e = th3;
            c0391d = null;
            C0214m.m1914a(flushable, "Failed to flush to session begin file.");
            C0214m.m1913a(c0391d, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m2829a(C0383d c0383d) {
        Closeable c0391d;
        Throwable th;
        Closeable closeable;
        Flushable flushable;
        Throwable th2;
        Flushable flushable2;
        Flushable flushable3 = null;
        try {
            String k = m2866k();
            if (k != null) {
                C0395h.m2770e(k);
                c0391d = new C0391d(this.f1385j, k + "SessionCrash");
                try {
                    flushable3 = C0393f.m2709a((OutputStream) c0391d);
                } catch (Throwable e) {
                    th = e;
                    closeable = c0391d;
                    flushable = flushable3;
                    th2 = th;
                    try {
                        C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the native crash logger", th2);
                        ax.m2571a(th2, (OutputStream) closeable);
                        C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                        C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th3) {
                        th2 = th3;
                        C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                        C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
                        throw th2;
                    }
                } catch (Throwable e2) {
                    th = e2;
                    closeable = c0391d;
                    flushable = flushable3;
                    th2 = th;
                    C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                    C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
                try {
                    be.m2614a(c0383d, new az(this.f1392q.m2334B(), this.f1385j, k), new bc(this.f1385j).m2607b(k), flushable3);
                } catch (Throwable e22) {
                    th = e22;
                    closeable = c0391d;
                    flushable = flushable3;
                    th2 = th;
                    C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the native crash logger", th2);
                    ax.m2571a(th2, (OutputStream) closeable);
                    C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                    C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable e222) {
                    th = e222;
                    closeable = c0391d;
                    flushable = flushable3;
                    th2 = th;
                    C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                    C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
            }
            C0326f.m2298h().mo519e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
            Object obj = flushable3;
            C0214m.m1914a(flushable3, "Failed to flush to session begin file.");
            C0214m.m1913a(c0391d, "Failed to close fatal exception file output stream.");
        } catch (Throwable e3) {
            closeable = flushable3;
            flushable2 = flushable3;
            th2 = e3;
            flushable = flushable2;
            C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the native crash logger", th2);
            ax.m2571a(th2, (OutputStream) closeable);
            C0214m.m1914a(flushable, "Failed to flush to session begin file.");
            C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable e32) {
            closeable = flushable3;
            flushable2 = flushable3;
            th2 = e32;
            flushable = flushable2;
            C0214m.m1914a(flushable, "Failed to flush to session begin file.");
            C0214m.m1913a(closeable, "Failed to close fatal exception file output stream.");
            throw th2;
        }
    }

    void m2872a(String str, String str2, String str3) {
        this.f1389n.m2819b(new ab(this, str, str2, str3));
    }

    void m2874a(Map<String, String> map) {
        this.f1389n.m2819b(new ac(this, map));
    }

    void m2877b() {
        this.f1389n.m2819b(new ad(this));
    }

    private String m2865j() {
        File[] e = m2880e();
        Arrays.sort(e, f1377b);
        return e.length > 0 ? m2826a(e[0]) : null;
    }

    private String m2866k() {
        File[] e = m2880e();
        Arrays.sort(e, f1377b);
        return e.length > 1 ? m2826a(e[1]) : null;
    }

    private String m2826a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean m2878c() {
        return ((Boolean) this.f1389n.m2817a(new ae(this))).booleanValue();
    }

    private void m2867l() {
        Date date = new Date();
        String c0390c = new C0390c(this.f1390o).toString();
        C0326f.m2298h().mo511a("CrashlyticsCore", "Opening an new session with ID " + c0390c);
        m2841a(c0390c, date);
        m2854c(c0390c);
        m2857d(c0390c);
        m2859e(c0390c);
        this.f1393r.m2585a(c0390c);
    }

    void m2879d() {
        m2843a(false);
    }

    private void m2843a(boolean z) {
        int i = z ? 1 : 0;
        m2828a(i + 8);
        File[] e = m2880e();
        Arrays.sort(e, f1377b);
        if (e.length > i) {
            m2861f(m2826a(e[i]));
            C0311p y = this.f1392q.m2804y();
            if (y != null) {
                int i2 = y.f972c;
                C0326f.m2298h().mo511a("CrashlyticsCore", "Closing open sessions.");
                while (i < e.length) {
                    File file = e[i];
                    String a = m2826a(file);
                    C0326f.m2298h().mo511a("CrashlyticsCore", "Closing session: " + a);
                    m2838a(file, a, i2);
                    i++;
                }
                return;
            }
            C0326f.m2298h().mo511a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
            return;
        }
        C0326f.m2298h().mo511a("CrashlyticsCore", "No open sessions to be closed.");
    }

    private void m2830a(C0391d c0391d) {
        if (c0391d != null) {
            try {
                c0391d.m2708a();
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void m2839a(String str) {
        for (File delete : m2851b(str)) {
            delete.delete();
        }
    }

    private File[] m2851b(String str) {
        return m2846a(new as(str));
    }

    private File[] m2868m() {
        return m2846a(f1376a);
    }

    File[] m2880e() {
        return m2846a(new ar("BeginSession"));
    }

    private File[] m2846a(FilenameFilter filenameFilter) {
        return m2852b(this.f1385j.listFiles(filenameFilter));
    }

    private File[] m2852b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void m2840a(String str, int i) {
        cc.m2706a(this.f1385j, new ar(str + "SessionEvent"), i, f1378c);
    }

    void m2881f() {
        cc.m2706a(this.f1385j, f1376a, 4, f1378c);
    }

    private void m2828a(int i) {
        int i2 = 0;
        Set hashSet = new HashSet();
        File[] e = m2880e();
        Arrays.sort(e, f1377b);
        int min = Math.min(i, e.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(m2826a(e[i3]));
        }
        this.f1393r.m2586a(hashSet);
        File[] a = m2846a(new aq());
        int length = a.length;
        while (i2 < length) {
            File file = a[i2];
            Object name = file.getName();
            Matcher matcher = f1380e.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                C0326f.m2298h().mo511a("CrashlyticsCore", "Trimming open session file: " + name);
                file.delete();
            }
            i2++;
        }
    }

    void m2882g() {
        this.f1389n.m2818a(new af(this));
    }

    void m2875a(File[] fileArr) {
        m2869n();
        for (File file : fileArr) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Found invalid session part file: " + file);
            String a = m2826a(file);
            FilenameFilter agVar = new ag(this, a);
            C0326f.m2298h().mo511a("CrashlyticsCore", "Deleting all part files for invalid session: " + a);
            for (File file2 : m2846a(agVar)) {
                C0326f.m2298h().mo511a("CrashlyticsCore", "Deleting session file: " + file2);
                file2.delete();
            }
        }
    }

    private void m2869n() {
        File file = new File(this.f1392q.m2800u(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
    }

    private void m2841a(String str, Date date) {
        Closeable c0391d;
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        try {
            c0391d = new C0391d(this.f1385j, str + "BeginSession");
            try {
                flushable = C0393f.m2709a((OutputStream) c0391d);
                this.f1394s.m2691a((C0393f) flushable, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f1392q.mo529a()}), date.getTime() / 1000);
                C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                C0214m.m1913a(c0391d, "Failed to close begin session file.");
            } catch (Exception e2) {
                e = e2;
                Closeable closeable = c0391d;
                try {
                    ax.m2571a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    c0391d = outputStream;
                    C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                    C0214m.m1913a(c0391d, "Failed to close begin session file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                C0214m.m1914a(flushable, "Failed to flush to session begin file.");
                C0214m.m1913a(c0391d, "Failed to close begin session file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            ax.m2571a(e, outputStream);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            c0391d = null;
            C0214m.m1914a(flushable, "Failed to flush to session begin file.");
            C0214m.m1913a(c0391d, "Failed to close begin session file.");
            throw e;
        }
    }

    private void m2854c(String str) {
        Closeable c0391d;
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        try {
            c0391d = new C0391d(this.f1385j, str + "SessionApp");
            try {
                flushable = C0393f.m2709a((OutputStream) c0391d);
                this.f1394s.m2693a((C0393f) flushable, this.f1392q.m2787h(), this.f1392q.m2790k(), this.f1392q.m2789j(), this.f1390o.m1959b(), C0220t.determineFrom(this.f1392q.m2788i()).getId());
                C0214m.m1914a(flushable, "Failed to flush to session app file.");
                C0214m.m1913a(c0391d, "Failed to close session app file.");
            } catch (Exception e2) {
                e = e2;
                Closeable closeable = c0391d;
                try {
                    ax.m2571a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    c0391d = outputStream;
                    C0214m.m1914a(flushable, "Failed to flush to session app file.");
                    C0214m.m1913a(c0391d, "Failed to close session app file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                C0214m.m1914a(flushable, "Failed to flush to session app file.");
                C0214m.m1913a(c0391d, "Failed to close session app file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            ax.m2571a(e, outputStream);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            c0391d = null;
            C0214m.m1914a(flushable, "Failed to flush to session app file.");
            C0214m.m1913a(c0391d, "Failed to close session app file.");
            throw e;
        }
    }

    private void m2857d(String str) {
        Closeable c0391d;
        Throwable e;
        Flushable flushable = null;
        try {
            c0391d = new C0391d(this.f1385j, str + "SessionOS");
            try {
                flushable = C0393f.m2709a((OutputStream) c0391d);
                this.f1394s.m2694a((C0393f) flushable, C0214m.m1930g(this.f1392q.m2334B()));
                C0214m.m1914a(flushable, "Failed to flush to session OS file.");
                C0214m.m1913a(c0391d, "Failed to close session OS file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    ax.m2571a(e, (OutputStream) c0391d);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    C0214m.m1914a(flushable, "Failed to flush to session OS file.");
                    C0214m.m1913a(c0391d, "Failed to close session OS file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c0391d = null;
            ax.m2571a(e, (OutputStream) c0391d);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            c0391d = null;
            C0214m.m1914a(flushable, "Failed to flush to session OS file.");
            C0214m.m1913a(c0391d, "Failed to close session OS file.");
            throw e;
        }
    }

    private void m2859e(String str) {
        Throwable e;
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        Flushable flushable = null;
        try {
            OutputStream c0391d = new C0391d(this.f1385j, str + "SessionDevice");
            try {
                flushable = C0393f.m2709a(c0391d);
                Context B = this.f1392q.m2334B();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                this.f1394s.m2690a((C0393f) flushable, this.f1390o.m1963f(), C0214m.m1893a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C0214m.m1917b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C0214m.m1929f(B), this.f1390o.m1964g(), C0214m.m1931h(B), Build.MANUFACTURER, Build.PRODUCT);
                C0214m.m1914a(flushable, "Failed to flush session device info.");
                C0214m.m1913a((Closeable) c0391d, "Failed to close session device file.");
            } catch (Exception e2) {
                e = e2;
                outputStream2 = c0391d;
                try {
                    ax.m2571a(e, outputStream2);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    outputStream = outputStream2;
                    C0214m.m1914a(flushable, "Failed to flush session device info.");
                    C0214m.m1913a((Closeable) outputStream, "Failed to close session device file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                C0214m.m1914a(flushable, "Failed to flush session device info.");
                C0214m.m1913a((Closeable) outputStream, "Failed to close session device file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            ax.m2571a(e, outputStream2);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            outputStream = null;
            C0214m.m1914a(flushable, "Failed to flush session device info.");
            C0214m.m1913a((Closeable) outputStream, "Failed to close session device file.");
            throw e;
        }
    }

    private void m2861f(String str) {
        Throwable e;
        Flushable flushable = null;
        Closeable c0391d;
        try {
            c0391d = new C0391d(this.f1385j, str + "SessionUser");
            try {
                flushable = C0393f.m2709a((OutputStream) c0391d);
                cb g = m2862g(str);
                if (g.m2705a()) {
                    C0214m.m1914a(flushable, "Failed to flush session user file.");
                    C0214m.m1913a(c0391d, "Failed to close session user file.");
                    return;
                }
                this.f1394s.m2692a((C0393f) flushable, g.f1317b, g.f1318c, g.f1319d);
                C0214m.m1914a(flushable, "Failed to flush session user file.");
                C0214m.m1913a(c0391d, "Failed to close session user file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    ax.m2571a(e, (OutputStream) c0391d);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    C0214m.m1914a(flushable, "Failed to flush session user file.");
                    C0214m.m1913a(c0391d, "Failed to close session user file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c0391d = null;
            ax.m2571a(e, (OutputStream) c0391d);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            c0391d = null;
            C0214m.m1914a(flushable, "Failed to flush session user file.");
            C0214m.m1913a(c0391d, "Failed to close session user file.");
            throw e;
        }
    }

    private cb m2862g(String str) {
        return m2876a() ? new cb(this.f1392q.m2793n(), this.f1392q.m2795p(), this.f1392q.m2794o()) : new bc(this.f1385j).m2604a(str);
    }

    private void m2833a(C0393f c0393f, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        Map map;
        Context B = this.f1392q.m2334B();
        long time = date.getTime() / 1000;
        float c = C0214m.m1923c(B);
        int a = C0214m.m1895a(B, this.f1391p);
        boolean d = C0214m.m1927d(B);
        int i = B.getResources().getConfiguration().orientation;
        long b = C0214m.m1917b() - C0214m.m1918b(B);
        long b2 = C0214m.m1919b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = C0214m.m1897a(B.getPackageName(), B);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(entry.getValue());
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (C0214m.m1916a(B, "com.crashlytics.CollectCustomKeys", true)) {
            Map g = this.f1392q.m2786g();
            if (g == null || g.size() <= 1) {
                map = g;
            } else {
                Map treeMap = new TreeMap(g);
            }
        } else {
            map = new TreeMap();
        }
        this.f1394s.m2689a(c0393f, time, thread, th, str, threadArr, c, a, d, i, b, b2, a2, linkedList, stackTrace, this.f1393r, map);
    }

    private void m2855c(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        String j = m2865j();
        if (j != null) {
            C0395h.m2768d(j);
            try {
                C0326f.m2298h().mo511a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                Closeable c0391d = new C0391d(this.f1385j, j + "SessionEvent" + C0214m.m1899a(this.f1382g.getAndIncrement()));
                try {
                    flushable = C0393f.m2709a((OutputStream) c0391d);
                    m2833a(flushable, date, thread, th, "error", false);
                    C0214m.m1914a(flushable, "Failed to flush to non-fatal file.");
                    C0214m.m1913a(c0391d, "Failed to close non-fatal file output stream.");
                } catch (Exception e2) {
                    e = e2;
                    closeable = c0391d;
                    try {
                        C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                        ax.m2571a(e, (OutputStream) closeable);
                        C0214m.m1914a(flushable, "Failed to flush to non-fatal file.");
                        C0214m.m1913a(closeable, "Failed to close non-fatal file output stream.");
                        m2840a(j, 64);
                        return;
                    } catch (Throwable th2) {
                        e = th2;
                        C0214m.m1914a(flushable, "Failed to flush to non-fatal file.");
                        C0214m.m1913a(closeable, "Failed to close non-fatal file output stream.");
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    closeable = c0391d;
                    C0214m.m1914a(flushable, "Failed to flush to non-fatal file.");
                    C0214m.m1913a(closeable, "Failed to close non-fatal file output stream.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                ax.m2571a(e, (OutputStream) closeable);
                C0214m.m1914a(flushable, "Failed to flush to non-fatal file.");
                C0214m.m1913a(closeable, "Failed to close non-fatal file output stream.");
                m2840a(j, 64);
                return;
            } catch (Throwable th4) {
                e = th4;
                closeable = null;
                C0214m.m1914a(flushable, "Failed to flush to non-fatal file.");
                C0214m.m1913a(closeable, "Failed to close non-fatal file output stream.");
                throw e;
            }
            try {
                m2840a(j, 64);
                return;
            } catch (Throwable e4) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e4);
                return;
            }
        }
        C0326f.m2298h().mo519e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
    }

    private void m2838a(File file, String str, int i) {
        boolean z;
        Closeable c0391d;
        Flushable a;
        Throwable e;
        Closeable closeable;
        C0391d c0391d2 = null;
        C0326f.m2298h().mo511a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a2 = m2846a(new ar(str + "SessionCrash"));
        boolean z2 = a2 != null && a2.length > 0;
        C0326f.m2298h().mo511a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a3 = m2846a(new ar(str + "SessionEvent"));
        if (a3 == null || a3.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C0326f.m2298h().mo511a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            try {
                c0391d = new C0391d(this.f1385j, str);
                try {
                    a = C0393f.m2709a((OutputStream) c0391d);
                } catch (Exception e2) {
                    e = e2;
                    a = null;
                    closeable = c0391d;
                    try {
                        C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                        ax.m2571a(e, (OutputStream) c0391d2);
                        C0214m.m1914a(a, "Error flushing session file stream");
                        m2830a(c0391d2);
                        C0326f.m2298h().mo511a("CrashlyticsCore", "Removing session part files for ID " + str);
                        m2839a(str);
                    } catch (Throwable th) {
                        e = th;
                        Object obj = c0391d2;
                        C0214m.m1914a(a, "Error flushing session file stream");
                        C0214m.m1913a(c0391d, "Failed to close CLS file");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    a = null;
                    C0214m.m1914a(a, "Error flushing session file stream");
                    C0214m.m1913a(c0391d, "Failed to close CLS file");
                    throw e;
                }
                try {
                    C0326f.m2298h().mo511a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                    m2831a((C0393f) a, file);
                    a.m2736a(4, new Date().getTime() / 1000);
                    a.m2739a(5, z2);
                    m2832a((C0393f) a, str);
                    if (z) {
                        File[] a4;
                        if (a3.length > i) {
                            C0326f.m2298h().mo511a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
                            m2840a(str, i);
                            a4 = m2846a(new ar(str + "SessionEvent"));
                        } else {
                            a4 = a3;
                        }
                        m2834a((C0393f) a, a4, str);
                    }
                    if (z2) {
                        m2831a((C0393f) a, a2[0]);
                    }
                    a.m2735a(11, 1);
                    a.m2748b(12, 3);
                    C0214m.m1914a(a, "Error flushing session file stream");
                    C0214m.m1913a(c0391d, "Failed to close CLS file");
                } catch (Exception e3) {
                    e = e3;
                    closeable = c0391d;
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    ax.m2571a(e, (OutputStream) c0391d2);
                    C0214m.m1914a(a, "Error flushing session file stream");
                    m2830a(c0391d2);
                    C0326f.m2298h().mo511a("CrashlyticsCore", "Removing session part files for ID " + str);
                    m2839a(str);
                } catch (Throwable th3) {
                    e = th3;
                    C0214m.m1914a(a, "Error flushing session file stream");
                    C0214m.m1913a(c0391d, "Failed to close CLS file");
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                a = null;
                C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                ax.m2571a(e, (OutputStream) c0391d2);
                C0214m.m1914a(a, "Error flushing session file stream");
                m2830a(c0391d2);
                C0326f.m2298h().mo511a("CrashlyticsCore", "Removing session part files for ID " + str);
                m2839a(str);
            } catch (Throwable th4) {
                e = th4;
                a = null;
                c0391d = null;
                C0214m.m1914a(a, "Error flushing session file stream");
                C0214m.m1913a(c0391d, "Failed to close CLS file");
                throw e;
            }
        }
        C0326f.m2298h().mo511a("CrashlyticsCore", "No events present for session ID " + str);
        C0326f.m2298h().mo511a("CrashlyticsCore", "Removing session part files for ID " + str);
        m2839a(str);
    }

    private void m2834a(C0393f c0393f, File[] fileArr, String str) {
        Arrays.sort(fileArr, C0214m.f785a);
        for (File name : fileArr) {
            try {
                C0326f.m2298h().mo511a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                m2831a(c0393f, name);
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void m2832a(C0393f c0393f, String str) {
        for (String str2 : new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"}) {
            File[] a = m2846a(new ar(str + str2));
            if (a.length == 0) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                C0326f.m2298h().mo511a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                m2831a(c0393f, a[0]);
            }
        }
    }

    private void m2831a(C0393f c0393f, File file) {
        Throwable th;
        if (file.exists()) {
            byte[] bArr = new byte[((int) file.length())];
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                int i = 0;
                while (i < bArr.length) {
                    try {
                        int read = fileInputStream.read(bArr, i, bArr.length - i);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                C0214m.m1913a(fileInputStream, "Failed to close file input stream.");
                c0393f.m2745a(bArr);
                return;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                C0214m.m1913a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        C0326f.m2298h().mo519e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private void m2870o() {
        for (File ahVar : m2868m()) {
            this.f1389n.m2818a(new ah(this, ahVar));
        }
    }
}
