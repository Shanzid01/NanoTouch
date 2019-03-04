package com.google.analytics.tracking.android;

import android.util.Log;

/* compiled from: Log */
public class av {
    private static boolean f2013a;

    public static void m3813a(boolean z) {
        f2013a = z;
    }

    public static boolean m3814a() {
        return f2013a;
    }

    public static int m3812a(String str) {
        return Log.d("GAV2", m3823j(str));
    }

    public static int m3815b(String str) {
        if (f2013a) {
            return m3812a(str);
        }
        return 0;
    }

    public static int m3816c(String str) {
        return Log.e("GAV2", m3823j(str));
    }

    public static int m3817d(String str) {
        return Log.i("GAV2", m3823j(str));
    }

    public static int m3818e(String str) {
        if (f2013a) {
            return m3817d(str);
        }
        return 0;
    }

    public static int m3819f(String str) {
        return Log.v("GAV2", m3823j(str));
    }

    public static int m3820g(String str) {
        if (f2013a) {
            return m3819f(str);
        }
        return 0;
    }

    public static int m3821h(String str) {
        return Log.w("GAV2", m3823j(str));
    }

    public static int m3822i(String str) {
        if (f2013a) {
            return m3821h(str);
        }
        return 0;
    }

    private static String m3823j(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }
}
