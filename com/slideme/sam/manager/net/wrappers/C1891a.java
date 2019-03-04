package com.slideme.sam.manager.net.wrappers;

import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;

/* compiled from: ApplicationDetailsGetter */
public class C1891a {
    private String f3457a;
    private String f3458b;
    private boolean f3459c;
    private boolean f3460d;
    private Catalog f3461e;
    private ArrayList<Application> f3462f;

    public ArrayList<Application> m5697a() {
        return this.f3462f;
    }

    public C1891a(String str, boolean z, String str2) {
        this(str, false, z, str2);
    }

    public C1891a(String str, boolean z, boolean z2, String str2) {
        this(str, z, z2, str2, -1);
    }

    public C1891a(String str, boolean z, boolean z2, String str2, int i) {
        this.f3459c = false;
        this.f3460d = false;
        if (z2) {
            this.f3458b = str;
        } else {
            this.f3457a = str;
        }
        this.f3459c = z2;
        this.f3460d = z;
        if (i > 0) {
            this.f3461e = new Catalog(str2, i);
        } else {
            this.f3461e = new Catalog(str2);
        }
    }

    public void m5698b() {
        if (this.f3459c) {
            this.f3461e.m5671b("pname:" + this.f3458b);
        } else {
            this.f3461e.m5667a(new String[]{this.f3457a});
        }
        this.f3461e.m5672b(true);
        this.f3461e.m5676c(true);
        this.f3461e.m5680d(this.f3460d);
        this.f3461e.m5689g();
        if (!C1922m.m5794a(this.f3461e.m5693i())) {
            this.f3462f = this.f3461e.m5693i();
        }
    }
}
