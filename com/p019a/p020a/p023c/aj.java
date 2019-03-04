package com.p019a.p020a.p023c;

import java.io.File;
import java.util.Comparator;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
final class aj implements Comparator<File> {
    aj() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2555a((File) obj, (File) obj2);
    }

    public int m2555a(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }
}
