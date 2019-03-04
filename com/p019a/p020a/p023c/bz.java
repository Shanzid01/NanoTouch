package com.p019a.p020a.p023c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.AppEventsConstants;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0213k;
import p006b.p007a.p008a.p009a.p010a.p012b.aa;

/* compiled from: SessionDataWriter */
class bz {
    private static final C0389b f1303a = C0389b.m2588a(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    private RunningAppProcessInfo f1304b;
    private Thread[] f1305c;
    private List<StackTraceElement[]> f1306d;
    private StackTraceElement[] f1307e;
    private final Context f1308f;
    private final C0389b f1309g;
    private final C0389b f1310h;
    private final int f1311i = 8;

    public bz(Context context, String str, String str2) {
        this.f1308f = context;
        this.f1309g = C0389b.m2588a(str2);
        this.f1310h = str == null ? null : C0389b.m2588a(str.replace("-", ""));
    }

    public void m2691a(C0393f c0393f, String str, String str2, long j) {
        c0393f.m2737a(1, C0389b.m2588a(str2));
        c0393f.m2737a(2, C0389b.m2588a(str));
        c0393f.m2736a(3, j);
    }

    public void m2693a(C0393f c0393f, String str, String str2, String str3, String str4, int i) {
        C0389b a = C0389b.m2588a(str);
        C0389b a2 = C0389b.m2588a(str2);
        C0389b a3 = C0389b.m2588a(str3);
        C0389b a4 = C0389b.m2588a(str4);
        c0393f.m2754g(7, 2);
        c0393f.m2756k(m2669a(a, a2, a3, a4, i));
        c0393f.m2737a(1, a);
        c0393f.m2737a(2, a2);
        c0393f.m2737a(3, a3);
        c0393f.m2754g(5, 2);
        c0393f.m2756k(m2664a());
        c0393f.m2738a(1, new C0213k().m1889a(this.f1308f));
        c0393f.m2737a(6, a4);
        c0393f.m2748b(10, i);
    }

    public void m2694a(C0393f c0393f, boolean z) {
        C0389b a = C0389b.m2588a(VERSION.RELEASE);
        C0389b a2 = C0389b.m2588a(VERSION.CODENAME);
        c0393f.m2754g(8, 2);
        c0393f.m2756k(m2670a(a, a2, z));
        c0393f.m2748b(1, 3);
        c0393f.m2737a(2, a);
        c0393f.m2737a(3, a2);
        c0393f.m2739a(4, z);
    }

    public void m2690a(C0393f c0393f, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<aa, String> map, int i3, String str3, String str4) {
        C0389b a = C0389b.m2588a(str);
        C0389b a2 = m2678a(str2);
        C0389b a3 = m2678a(str4);
        C0389b a4 = m2678a(str3);
        c0393f.m2754g(9, 2);
        c0393f.m2756k(m2666a(i, a, a2, i2, j, j2, z, map, i3, a4, a3));
        c0393f.m2737a(1, a);
        c0393f.m2748b(3, i);
        c0393f.m2737a(4, a2);
        c0393f.m2735a(5, i2);
        c0393f.m2736a(6, j);
        c0393f.m2736a(7, j2);
        c0393f.m2739a(10, z);
        for (Entry entry : map.entrySet()) {
            c0393f.m2754g(11, 2);
            c0393f.m2756k(m2667a((aa) entry.getKey(), (String) entry.getValue()));
            c0393f.m2748b(1, ((aa) entry.getKey()).protobufIndex);
            c0393f.m2737a(2, C0389b.m2588a((String) entry.getValue()));
        }
        c0393f.m2735a(12, i3);
        if (a4 != null) {
            c0393f.m2737a(13, a4);
        }
        if (a3 != null) {
            c0393f.m2737a(14, a3);
        }
    }

    public void m2692a(C0393f c0393f, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        C0389b a = C0389b.m2588a(str);
        C0389b a2 = m2678a(str2);
        C0389b a3 = m2678a(str3);
        int b = 0 + C0393f.m2715b(1, a);
        if (str2 != null) {
            b += C0393f.m2715b(2, a2);
        }
        if (str3 != null) {
            b += C0393f.m2715b(3, a3);
        }
        c0393f.m2754g(6, 2);
        c0393f.m2756k(b);
        c0393f.m2737a(1, a);
        if (str2 != null) {
            c0393f.m2737a(2, a2);
        }
        if (str3 != null) {
            c0393f.m2737a(3, a3);
        }
    }

    public void m2689a(C0393f c0393f, long j, Thread thread, Throwable th, String str, Thread[] threadArr, float f, int i, boolean z, int i2, long j2, long j3, RunningAppProcessInfo runningAppProcessInfo, List<StackTraceElement[]> list, StackTraceElement[] stackTraceElementArr, az azVar, Map<String, String> map) {
        this.f1304b = runningAppProcessInfo;
        this.f1306d = list;
        this.f1307e = stackTraceElementArr;
        this.f1305c = threadArr;
        C0389b a = azVar.m2582a();
        if (a == null) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "No log data to include with this event.");
        }
        azVar.m2587b();
        c0393f.m2754g(10, 2);
        c0393f.m2756k(m2675a(thread, th, str, j, (Map) map, f, i, z, i2, j2, j3, a));
        c0393f.m2736a(1, j);
        c0393f.m2737a(2, C0389b.m2588a(str));
        m2683a(c0393f, thread, th, i2, (Map) map);
        m2679a(c0393f, f, i, z, i2, j2, j3);
        m2681a(c0393f, a);
    }

    private void m2683a(C0393f c0393f, Thread thread, Throwable th, int i, Map<String, String> map) {
        c0393f.m2754g(3, 2);
        c0393f.m2756k(m2674a(thread, th, i, (Map) map));
        m2682a(c0393f, thread, th);
        if (!(map == null || map.isEmpty())) {
            m2686a(c0393f, (Map) map);
        }
        if (this.f1304b != null) {
            c0393f.m2739a(3, this.f1304b.importance != 100);
        }
        c0393f.m2735a(4, i);
    }

    private void m2682a(C0393f c0393f, Thread thread, Throwable th) {
        c0393f.m2754g(1, 2);
        c0393f.m2756k(m2673a(thread, th));
        m2684a(c0393f, thread, this.f1307e, 4, true);
        int length = this.f1305c.length;
        for (int i = 0; i < length; i++) {
            m2684a(c0393f, this.f1305c[i], (StackTraceElement[]) this.f1306d.get(i), 0, false);
        }
        m2685a(c0393f, th, 1, 2);
        c0393f.m2754g(3, 2);
        c0393f.m2756k(m2688c());
        c0393f.m2737a(1, f1303a);
        c0393f.m2737a(2, f1303a);
        c0393f.m2736a(3, 0);
        c0393f.m2754g(4, 2);
        c0393f.m2756k(m2687b());
        c0393f.m2736a(1, 0);
        c0393f.m2736a(2, 0);
        c0393f.m2737a(3, this.f1309g);
        if (this.f1310h != null) {
            c0393f.m2737a(4, this.f1310h);
        }
    }

    private void m2686a(C0393f c0393f, Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            c0393f.m2754g(2, 2);
            c0393f.m2756k(m2672a((String) entry.getKey(), (String) entry.getValue()));
            c0393f.m2737a(1, C0389b.m2588a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            c0393f.m2737a(2, C0389b.m2588a(str));
        }
    }

    private void m2685a(C0393f c0393f, Throwable th, int i, int i2) {
        int i3 = 0;
        c0393f.m2754g(i2, 2);
        c0393f.m2756k(m2677a(th, 1));
        c0393f.m2737a(1, C0389b.m2588a(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            c0393f.m2737a(3, C0389b.m2588a(localizedMessage));
        }
        for (StackTraceElement a : th.getStackTrace()) {
            m2680a(c0393f, 4, a, true);
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return;
        }
        if (i < this.f1311i) {
            m2685a(c0393f, cause, i + 1, 6);
            return;
        }
        while (cause != null) {
            cause = cause.getCause();
            i3++;
        }
        c0393f.m2735a(7, i3);
    }

    private void m2684a(C0393f c0393f, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        c0393f.m2754g(1, 2);
        c0393f.m2756k(m2676a(thread, stackTraceElementArr, i, z));
        c0393f.m2737a(1, C0389b.m2588a(thread.getName()));
        c0393f.m2735a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            m2680a(c0393f, 3, a, z);
        }
    }

    private void m2680a(C0393f c0393f, int i, StackTraceElement stackTraceElement, boolean z) {
        int i2 = 4;
        c0393f.m2754g(i, 2);
        c0393f.m2756k(m2671a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            c0393f.m2736a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            c0393f.m2736a(1, 0);
        }
        c0393f.m2737a(2, C0389b.m2588a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            c0393f.m2737a(3, C0389b.m2588a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            c0393f.m2736a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        c0393f.m2735a(5, i2);
    }

    private void m2679a(C0393f c0393f, float f, int i, boolean z, int i2, long j, long j2) {
        c0393f.m2754g(5, 2);
        c0393f.m2756k(m2665a(f, i, z, i2, j, j2));
        c0393f.m2734a(1, f);
        c0393f.m2750c(2, i);
        c0393f.m2739a(3, z);
        c0393f.m2735a(4, i2);
        c0393f.m2736a(5, j);
        c0393f.m2736a(6, j2);
    }

    private void m2681a(C0393f c0393f, C0389b c0389b) {
        if (c0389b != null) {
            c0393f.m2754g(6, 2);
            c0393f.m2756k(m2668a(c0389b));
            c0393f.m2737a(1, c0389b);
        }
    }

    private int m2669a(C0389b c0389b, C0389b c0389b2, C0389b c0389b3, C0389b c0389b4, int i) {
        int b = ((0 + C0393f.m2715b(1, c0389b)) + C0393f.m2715b(2, c0389b2)) + C0393f.m2715b(3, c0389b3);
        int a = m2664a();
        return ((b + (a + (C0393f.m2728j(5) + C0393f.m2729l(a)))) + C0393f.m2715b(6, c0389b4)) + C0393f.m2723e(10, i);
    }

    private int m2664a() {
        return 0 + C0393f.m2715b(1, C0389b.m2588a(new C0213k().m1889a(this.f1308f)));
    }

    private int m2670a(C0389b c0389b, C0389b c0389b2, boolean z) {
        return (((0 + C0393f.m2723e(1, 3)) + C0393f.m2715b(2, c0389b)) + C0393f.m2715b(3, c0389b2)) + C0393f.m2716b(4, z);
    }

    private int m2667a(aa aaVar, String str) {
        return C0393f.m2723e(1, aaVar.protobufIndex) + C0393f.m2715b(2, C0389b.m2588a(str));
    }

    private int m2666a(int i, C0389b c0389b, C0389b c0389b2, int i2, long j, long j2, boolean z, Map<aa, String> map, int i3, C0389b c0389b3, C0389b c0389b4) {
        int i4;
        int i5;
        int e = C0393f.m2723e(3, i) + (0 + C0393f.m2715b(1, c0389b));
        if (c0389b2 == null) {
            i4 = 0;
        } else {
            i4 = C0393f.m2715b(4, c0389b2);
        }
        i4 = ((((i4 + e) + C0393f.m2720d(5, i2)) + C0393f.m2714b(6, j)) + C0393f.m2714b(7, j2)) + C0393f.m2716b(10, z);
        if (map != null) {
            i5 = i4;
            for (Entry entry : map.entrySet()) {
                i4 = m2667a((aa) entry.getKey(), (String) entry.getValue());
                i5 = (i4 + (C0393f.m2728j(11) + C0393f.m2729l(i4))) + i5;
            }
        } else {
            i5 = i4;
        }
        return (c0389b4 == null ? 0 : C0393f.m2715b(14, c0389b4)) + ((i5 + C0393f.m2720d(12, i3)) + (c0389b3 == null ? 0 : C0393f.m2715b(13, c0389b3)));
    }

    private int m2687b() {
        int b = ((0 + C0393f.m2714b(1, 0)) + C0393f.m2714b(2, 0)) + C0393f.m2715b(3, this.f1309g);
        if (this.f1310h != null) {
            return b + C0393f.m2715b(4, this.f1310h);
        }
        return b;
    }

    private int m2675a(Thread thread, Throwable th, String str, long j, Map<String, String> map, float f, int i, boolean z, int i2, long j2, long j3, C0389b c0389b) {
        int b = (0 + C0393f.m2714b(1, j)) + C0393f.m2715b(2, C0389b.m2588a(str));
        int a = m2674a(thread, th, i2, (Map) map);
        b += a + (C0393f.m2728j(3) + C0393f.m2729l(a));
        a = m2665a(f, i, z, i2, j2, j3);
        b += a + (C0393f.m2728j(5) + C0393f.m2729l(a));
        if (c0389b == null) {
            return b;
        }
        a = m2668a(c0389b);
        return b + (a + (C0393f.m2728j(6) + C0393f.m2729l(a)));
    }

    private int m2674a(Thread thread, Throwable th, int i, Map<String, String> map) {
        int i2;
        int a = m2673a(thread, th);
        a = (a + (C0393f.m2728j(1) + C0393f.m2729l(a))) + 0;
        if (map != null) {
            i2 = a;
            for (Entry entry : map.entrySet()) {
                a = m2672a((String) entry.getKey(), (String) entry.getValue());
                i2 = (a + (C0393f.m2728j(2) + C0393f.m2729l(a))) + i2;
            }
        } else {
            i2 = a;
        }
        if (this.f1304b != null) {
            i2 += C0393f.m2716b(3, this.f1304b.importance != 100);
        }
        return C0393f.m2720d(4, i) + i2;
    }

    private int m2673a(Thread thread, Throwable th) {
        int i;
        int a = m2676a(thread, this.f1307e, 4, true);
        a = (a + (C0393f.m2728j(1) + C0393f.m2729l(a))) + 0;
        int length = this.f1305c.length;
        int i2 = a;
        for (i = 0; i < length; i++) {
            a = m2676a(this.f1305c[i], (StackTraceElement[]) this.f1306d.get(i), 0, false);
            i2 += a + (C0393f.m2728j(1) + C0393f.m2729l(a));
        }
        a = m2677a(th, 1);
        a = (a + (C0393f.m2728j(2) + C0393f.m2729l(a))) + i2;
        i = m2688c();
        a += i + (C0393f.m2728j(3) + C0393f.m2729l(i));
        i = m2687b();
        return a + (i + (C0393f.m2728j(3) + C0393f.m2729l(i)));
    }

    private int m2672a(String str, String str2) {
        int b = C0393f.m2715b(1, C0389b.m2588a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + C0393f.m2715b(2, C0389b.m2588a(str2));
    }

    private int m2665a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((0 + C0393f.m2713b(1, f)) + C0393f.m2725f(2, i)) + C0393f.m2716b(3, z)) + C0393f.m2720d(4, i2)) + C0393f.m2714b(5, j)) + C0393f.m2714b(6, j2);
    }

    private int m2668a(C0389b c0389b) {
        return C0393f.m2715b(1, c0389b);
    }

    private int m2677a(Throwable th, int i) {
        int i2 = 0;
        int b = C0393f.m2715b(1, C0389b.m2588a(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += C0393f.m2715b(3, C0389b.m2588a(localizedMessage));
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i3 = 0;
        while (i3 < length) {
            int a = m2671a(stackTrace[i3], true);
            i3++;
            b = (a + (C0393f.m2728j(4) + C0393f.m2729l(a))) + b;
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return b;
        }
        if (i < this.f1311i) {
            i2 = m2677a(cause, i + 1);
            return b + (i2 + (C0393f.m2728j(6) + C0393f.m2729l(i2)));
        }
        while (cause != null) {
            cause = cause.getCause();
            i2++;
        }
        return b + C0393f.m2720d(7, i2);
    }

    private int m2688c() {
        return ((0 + C0393f.m2715b(1, f1303a)) + C0393f.m2715b(2, f1303a)) + C0393f.m2714b(3, 0);
    }

    private int m2671a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i;
        if (stackTraceElement.isNativeMethod()) {
            b = C0393f.m2714b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = C0393f.m2714b(1, 0) + 0;
        }
        b += C0393f.m2715b(2, C0389b.m2588a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b += C0393f.m2715b(3, C0389b.m2588a(stackTraceElement.getFileName()));
        }
        if (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) {
            i = b;
        } else {
            i = b + C0393f.m2714b(4, (long) stackTraceElement.getLineNumber());
        }
        return C0393f.m2720d(5, z ? 2 : 0) + i;
    }

    private int m2676a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int d = C0393f.m2720d(2, i) + C0393f.m2715b(1, C0389b.m2588a(thread.getName()));
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = m2671a(a, z);
            d += a2 + (C0393f.m2728j(3) + C0393f.m2729l(a2));
        }
        return d;
    }

    private C0389b m2678a(String str) {
        return str == null ? null : C0389b.m2588a(str);
    }
}
