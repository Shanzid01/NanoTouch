package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class as implements FilenameFilter {
    private final String f1240a;

    public as(String str) {
        this.f1240a = str;
    }

    public boolean accept(File file, String str) {
        if (str.equals(this.f1240a + ".cls") || !str.contains(this.f1240a) || str.endsWith(".cls_temp")) {
            return false;
        }
        return true;
    }
}
