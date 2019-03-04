package com.p026b.p027a.p028a.p029a;

import com.p026b.p027a.p028a.p029a.p031b.C0456a;
import java.io.File;

/* compiled from: BaseDiscCache */
public abstract class C0451a implements C0450b {
    protected File f1395a;
    private C0456a f1396b;

    public C0451a(File file, C0456a c0456a) {
        this.f1395a = file;
        this.f1396b = c0456a;
    }

    public File mo914a(String str) {
        return new File(this.f1395a, this.f1396b.mo918a(str));
    }

    public void mo915a() {
        File[] listFiles = this.f1395a.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
