package com.p019a.p020a.p023c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: ClsFileOutputStream */
class C0391d extends FileOutputStream {
    public static final FilenameFilter f1324a = new C0392e();
    private final String f1325b;
    private File f1326c;
    private File f1327d;
    private boolean f1328e = false;

    public C0391d(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.f1325b = file + File.separator + str;
        this.f1326c = new File(this.f1325b + ".cls_temp");
    }

    public synchronized void close() {
        if (!this.f1328e) {
            this.f1328e = true;
            super.flush();
            super.close();
            File file = new File(this.f1325b + ".cls");
            if (this.f1326c.renameTo(file)) {
                this.f1326c = null;
                this.f1327d = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.f1326c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.f1326c + " -> " + file + str);
            }
        }
    }

    public void m2708a() {
        if (!this.f1328e) {
            this.f1328e = true;
            super.flush();
            super.close();
        }
    }
}
