package com.mopub.common.p050b;

import android.util.Log;

/* compiled from: MoPubLog */
public class C1486i {
    public static int m4076a(String str) {
        return C1486i.m4077a(str, null);
    }

    public static int m4077a(String str, Throwable th) {
        return Log.d("MoPub", str, th);
    }

    public static int m4078b(String str) {
        return C1486i.m4079b(str, null);
    }

    public static int m4079b(String str, Throwable th) {
        return Log.w("MoPub", str, th);
    }
}
