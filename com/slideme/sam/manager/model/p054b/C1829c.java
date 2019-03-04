package com.slideme.sam.manager.model.p054b;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: BuildHelper */
public class C1829c {
    private static String f3267a;
    private static String f3268b;
    private static String f3269c;
    private static String f3270d;
    private static int f3271e;
    private static String f3272f;

    public static String m5499a() {
        if (TextUtils.isEmpty(f3267a)) {
            return Build.MODEL;
        }
        return f3267a;
    }

    public static String m5500b() {
        if (TextUtils.isEmpty(f3269c)) {
            return Build.BRAND;
        }
        return f3269c;
    }

    public static String m5501c() {
        if (TextUtils.isEmpty(f3272f)) {
            return Build.CPU_ABI;
        }
        return f3272f;
    }

    public static String m5502d() {
        if (TextUtils.isEmpty(f3270d)) {
            return Build.BOARD;
        }
        return f3270d;
    }

    public static String m5503e() {
        if (TextUtils.isEmpty(f3268b)) {
            return Build.MANUFACTURER;
        }
        return f3268b;
    }

    public static int m5504f() {
        if (f3271e > 0) {
            return f3271e;
        }
        return VERSION.SDK_INT;
    }
}
