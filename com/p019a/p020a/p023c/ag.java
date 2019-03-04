package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class ag implements FilenameFilter {
    final /* synthetic */ String f1222a;
    final /* synthetic */ C0413z f1223b;

    ag(C0413z c0413z, String str) {
        this.f1223b = c0413z;
        this.f1222a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f1222a);
    }
}
