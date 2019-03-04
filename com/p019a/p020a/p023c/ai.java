package com.p019a.p020a.p023c;

import java.io.File;
import java.util.Comparator;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
final class ai implements Comparator<File> {
    ai() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2554a((File) obj, (File) obj2);
    }

    public int m2554a(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }
}
