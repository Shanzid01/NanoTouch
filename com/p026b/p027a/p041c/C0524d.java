package com.p026b.p027a.p041c;

import android.util.Log;
import com.p026b.p027a.p034b.C0510g;

/* compiled from: L */
public final class C0524d {
    public static void m3151a(String str, Object... objArr) {
        C0524d.m3150a(3, null, str, objArr);
    }

    public static void m3153b(String str, Object... objArr) {
        C0524d.m3150a(4, null, str, objArr);
    }

    public static void m3154c(String str, Object... objArr) {
        C0524d.m3150a(5, null, str, objArr);
    }

    public static void m3152a(Throwable th) {
        C0524d.m3150a(6, th, null, new Object[0]);
    }

    public static void m3155d(String str, Object... objArr) {
        C0524d.m3150a(6, null, str, objArr);
    }

    private static void m3150a(int i, Throwable th, String str, Object... objArr) {
        String format;
        if (objArr.length > 0) {
            format = String.format(str, objArr);
        } else {
            format = str;
        }
        if (th != null) {
            if (format == null) {
                format = th.getMessage();
            }
            String stackTraceString = Log.getStackTraceString(th);
            format = String.format("%1$s\n%2$s", new Object[]{format, stackTraceString});
        }
        Log.println(i, C0510g.f1498a, format);
    }
}
