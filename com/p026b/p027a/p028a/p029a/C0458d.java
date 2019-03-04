package com.p026b.p027a.p028a.p029a;

import java.io.File;

/* compiled from: LimitedDiscCache */
class C0458d implements Runnable {
    final /* synthetic */ C0452c f1400a;

    C0458d(C0452c c0452c) {
        this.f1400a = c0452c;
    }

    public void run() {
        int i = 0;
        File[] listFiles = this.f1400a.a.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i < length) {
                File file = listFiles[i];
                i2 += this.f1400a.mo917a(file);
                this.f1400a.f1399d.put(file, Long.valueOf(file.lastModified()));
                i++;
            }
            this.f1400a.f1397b.set(i2);
        }
    }
}
