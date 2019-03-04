package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
final class aa implements FilenameFilter {
    aa() {
    }

    public boolean accept(File file, String str) {
        return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
    }
}
