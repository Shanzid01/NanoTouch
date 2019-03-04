package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class aq implements FilenameFilter {
    private aq() {
    }

    public boolean accept(File file, String str) {
        return !C0413z.f1376a.accept(file, str) && C0413z.f1380e.matcher(str).matches();
    }
}
