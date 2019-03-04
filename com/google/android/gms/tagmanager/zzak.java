package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import java.io.File;

class zzak {
    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            zzbf.zzZ("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    static boolean zzam(String str) {
        if (version() < 9) {
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
