package com.mopub.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: DiskLruCache */
public final class C1500h {
    final /* synthetic */ C1498f f2171a;
    private final C1502j f2172b;
    private final boolean[] f2173c;
    private boolean f2174d;
    private boolean f2175e;

    private C1500h(C1498f c1498f, C1502j c1502j) {
        this.f2171a = c1498f;
        this.f2172b = c1502j;
        this.f2173c = c1502j.f2180d ? null : new boolean[c1498f.f2164e];
    }

    public OutputStream m4116a(int i) {
        OutputStream c;
        synchronized (this.f2171a) {
            File b;
            OutputStream fileOutputStream;
            if (this.f2172b.f2181e != this) {
                throw new IllegalStateException();
            }
            if (!this.f2172b.f2180d) {
                this.f2173c[i] = true;
            }
            b = this.f2172b.m4129b(i);
            try {
                fileOutputStream = new FileOutputStream(b);
            } catch (FileNotFoundException e) {
                this.f2171a.f2162c.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e2) {
                    c = C1498f.f2160l;
                }
            }
            c = new C1501i(this, fileOutputStream);
        }
        return c;
    }

    public void m4117a() {
        if (this.f2174d) {
            this.f2171a.m4100a(this, false);
            this.f2171a.m4112c(this.f2172b.f2178b);
        } else {
            this.f2171a.m4100a(this, true);
        }
        this.f2175e = true;
    }

    public void m4118b() {
        this.f2171a.m4100a(this, false);
    }
}
