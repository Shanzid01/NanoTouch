package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

/* compiled from: FutureApis */
class C0776t {
    public static int m3959a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            av.m3816c("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    static boolean m3960a(String str) {
        if (C0776t.m3959a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
