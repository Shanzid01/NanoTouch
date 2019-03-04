package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ReportUploader */
final class bx implements FilenameFilter {
    bx() {
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".cls") && !str.contains("Session");
    }
}
