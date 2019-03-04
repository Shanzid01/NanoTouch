package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ar implements FilenameFilter {
    private final String f1239a;

    public ar(String str) {
        this.f1239a = str;
    }

    public boolean accept(File file, String str) {
        return str.contains(this.f1239a) && !str.endsWith(".cls_temp");
    }
}
