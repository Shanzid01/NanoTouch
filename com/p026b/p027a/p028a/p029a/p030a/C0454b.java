package com.p026b.p027a.p028a.p029a.p030a;

import com.p026b.p027a.p028a.p029a.C0452c;
import com.p026b.p027a.p028a.p029a.p031b.C0456a;
import com.p026b.p027a.p034b.C0486a;
import com.p026b.p027a.p041c.C0524d;
import java.io.File;

/* compiled from: TotalSizeLimitedDiscCache */
public class C0454b extends C0452c {
    public C0454b(File file, int i) {
        this(file, C0486a.m2978a(), i);
    }

    public C0454b(File file, C0456a c0456a, int i) {
        super(file, c0456a, i);
        if (i < 2097152) {
            C0524d.m3154c("You set too small disc cache size (less than %1$d Mb)", Integer.valueOf(2));
        }
    }

    protected int mo917a(File file) {
        return (int) file.length();
    }
}
