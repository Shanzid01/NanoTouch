package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ClsFileOutputStream */
final class C0392e implements FilenameFilter {
    C0392e() {
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".cls_temp");
    }
}
